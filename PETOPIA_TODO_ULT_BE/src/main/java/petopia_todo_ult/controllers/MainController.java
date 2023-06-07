package petopia_todo_ult.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import petopia_todo_ult.dto.LoginRequestDTO;
import petopia_todo_ult.dto.LoginResponseDTO;

import petopia_todo_ult.models.*;
import petopia_todo_ult.services.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private HistorialService historialService;

    @Autowired
    private ClinicaService clinicaService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SeguimientoService seguimientoService;

    @Autowired
    UserService userService;

    /////////////////////////////////////////////////////////////////////////

    @ModelAttribute("animalRepository")
    public List<Animal> listAnimal() {return animalService.getAllAnimals();}

    @ModelAttribute("historialRepository")
    public List<Historial> listHistorial() {return historialService.getAllHistorial();}

    @ModelAttribute("clinicaRepository")
    public List<Clinica> listClinicas() {return clinicaService.getAllClinicas();}

    @ModelAttribute("empleadoRepository")
    public List<Empleado> listEmpleado() {return empleadoService.getAllEmpleados();}

    @ModelAttribute("seguimientoRepository")
    public List<Seguimiento> listSeguimientos() {return seguimientoService.getAllSeguimientos();}

    ///////////////////////////////////////////////////////////////////////

    @GetMapping("api/v1/animals")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("api/v1/historial")
    public List<Historial> getAllHistoriales() {
        return historialService.getAllHistorial();
    }

    @PostMapping("api/v1/animals")
    public Animal createAnimal(
            @RequestParam("name") String name,
            @RequestParam("date_of_birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE ) Date dateOfBirth,
            @RequestParam("description") String description,
            @RequestParam("size") String size,
            @RequestParam("image") MultipartFile file,
            @RequestParam("sex") String sex,
            @RequestParam("animal_type") String animal_type,
            @RequestParam("token") String token,
            @RequestParam("email") String email
    ) throws Exception {
        if (file.isEmpty()) throw new Exception("please add file");
        Optional<User> user = userService.findUserByEmail(email);
        if (!user.isPresent()) {
            throw new Exception("no account registered with this email");
        }

        if (!user.get().getToken().toString().equals(token)) {
            throw new Exception("wrong or invalid token");
        }

        String fileName = file.getName();
        String type = file.getContentType();
        byte[] bytes = file.getBytes();

        Animal animal = new Animal();
        Image image = new Image(fileName, type, bytes);
        animal.setImage(image);
        animal.setName(name);
        animal.setSex(sex);
        animal.setSize(size);
        animal.setAnimal_type(animal_type);
        animal.setDescription(description);
        animal.setDate_of_birth(dateOfBirth);
        return animalService.createAnimal(animal);
    }

    @PatchMapping("api/v1/animals/{id}")
    public Animal updateAnimal(
            @PathVariable("id") Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "date_of_birth", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE ) Date dateOfBirth,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "image", required = false) MultipartFile file,
            @RequestParam(value = "sex", required = false) String sex,
            @RequestParam(value = "animal_type", required = false) String animal_type,
            @RequestParam("token") String token,
            @RequestParam("email") String email
    ) throws Exception {
        Optional<User> user = userService.findUserByEmail(email);
        if (!user.isPresent()) {
            throw new Exception("no account registered with this email");
        }

        if (!user.get().getToken().toString().equals(token)) {
            throw new Exception("wrong or invalid token");
        }

        return animalService.updateAnimalById(
                id, name,
                dateOfBirth, description,
                size, file, sex, animal_type
        );
    }

    @GetMapping("api/v1/animals/{id}")
    public Optional<Animal> getAnimal(@PathVariable("id") Long id) {
       return animalService.getAnimalById(id);
    }



    @DeleteMapping("api/v1/animals/{id}")
    public void deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimal(id);
    }

    // ** User APIs **

    @PostMapping("api/v1/users")
    public User registerUser(@RequestBody User userDto) throws Exception {
        if (userService.isUserExists(userDto.getEmail())) {
            throw new Exception("email already exists");
        }
        User newUser = userService.registerUser(userDto);
        newUser.setPassword(null);
        return newUser;
    }

    @GetMapping("api/v1/users/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> user = userService.findUserByEmail(email);
        user.get().setPassword(null);
        return user;
    }

    @GetMapping("api/v1/users/id/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.findUserById(id);
        user.get().setPassword(null);
        return user;
    }

    @PostMapping("api/v1/users/signin")
    public LoginResponseDTO signIn(
            @RequestBody LoginRequestDTO credentials,
            HttpServletResponse response
            ) throws Exception {
        Optional<User> userDB = userService.findUserByEmail(credentials.getEmail());
        if (!userDB.isPresent()) {
            throw new Exception("email does not exists");
        }

        if (!userDB.get().getPassword().equals(credentials.getPassword())) {
            throw new Exception("wrong password");
        }

        // generate and save
        UUID token = UUID.randomUUID();
        User user = new User();
        user.setToken(token);
        user.setId(userDB.get().getId());
        user.setName(userDB.get().getName());
        user.setPassword(userDB.get().getPassword());
        user.setEmail(userDB.get().getEmail());

        userService.saveUserData(user);
        // set response
        LoginResponseDTO res = new LoginResponseDTO();
        res.setStatus("ok");
        res.setToken(token);
        Cookie cookie = new Cookie("token", token.toString());
        response.addCookie(cookie);
        return res;
    }

    @PostMapping("api/v1/users/signout")
    public LoginResponseDTO signout(
            HttpServletResponse response
    ) {
        Cookie cookie = new Cookie("token", null);
        response.addCookie(cookie);

        LoginResponseDTO res = new LoginResponseDTO();
        res.setToken(null);
        res.setStatus("signout");
        return res;
    }
}

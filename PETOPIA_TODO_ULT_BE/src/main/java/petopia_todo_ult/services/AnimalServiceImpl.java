package petopia_todo_ult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import petopia_todo_ult.models.Animal;
import petopia_todo_ult.models.Image;
import petopia_todo_ult.repositories.AnimalRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal updateAnimalById(
            Long id, String name,
            Date dateOfBirth, String description,
            String size, MultipartFile file, String sex, String animal_type
            ) throws Exception {

        Animal animal = animalRepository.getById(id);

        if (animal.getId() != id) {
            throw new Exception("animal no longer exists");
        }

        animal.setId(id);
        if (!name.isEmpty()) animal.setName(name);
        if (dateOfBirth != null) animal.setDate_of_birth(dateOfBirth);
        if (!description.isEmpty()) animal.setDescription(description);
        if (!size.isEmpty()) animal.setSize(size);
        if (!animal_type.isEmpty()) animal.setAnimal_type(animal_type);
        if (file != null) {
            String fileName = file.getName();
            String type = file.getContentType();
            byte[] bytes = file.getBytes();
            animal.setImage(new Image(fileName, type, bytes));
        }
        if (!sex.isEmpty()) animal.setSex(sex);

        return animalRepository.save(animal);
    }

    public void saveAll(List<Animal> lista) {
        animalRepository.saveAll(lista);
    }

    @Override
    public String deleteAnimal(Long id) {
        animalRepository.deleteById(id);
        return "animal deleted";
    }

}

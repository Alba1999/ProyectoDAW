package petopia_todo_ult.services;

import org.springframework.web.multipart.MultipartFile;
import petopia_todo_ult.models.Animal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AnimalService {
    Animal createAnimal(Animal animal);

    Optional<Animal> getAnimalById(Long id);

    List<Animal> getAllAnimals();

    Animal updateAnimalById(
            Long id, String name,
            Date dateOfBirth, String description,
            String size, MultipartFile file, String sex, String animal_type
            ) throws Exception;

    String deleteAnimal(Long id);

}

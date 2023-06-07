package petopia_todo_ult.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petopia_todo_ult.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

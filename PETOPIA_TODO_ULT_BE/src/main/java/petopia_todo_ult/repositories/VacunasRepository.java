package petopia_todo_ult.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petopia_todo_ult.models.Vacunas;

@Repository
public interface VacunasRepository extends JpaRepository<Vacunas, Long>  {
}

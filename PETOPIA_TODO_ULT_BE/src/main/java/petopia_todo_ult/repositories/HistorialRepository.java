package petopia_todo_ult.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petopia_todo_ult.models.Historial;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
}

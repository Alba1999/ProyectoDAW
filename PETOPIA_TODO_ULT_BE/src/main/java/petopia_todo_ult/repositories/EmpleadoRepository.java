package petopia_todo_ult.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petopia_todo_ult.models.Empleado;
import petopia_todo_ult.models.Historial;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

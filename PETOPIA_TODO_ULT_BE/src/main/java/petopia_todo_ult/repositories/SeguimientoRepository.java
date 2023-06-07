package petopia_todo_ult.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petopia_todo_ult.models.Seguimiento;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
}

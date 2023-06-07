package petopia_todo_ult.services;

import petopia_todo_ult.models.Seguimiento;

import java.util.List;
import java.util.Optional;

public interface SeguimientoService {
    Seguimiento createSeguimiento (Seguimiento seguimiento);

    Optional<Seguimiento> getSeguimientoById (Long num_caso);

    List<Seguimiento> getAllSeguimientos();
}

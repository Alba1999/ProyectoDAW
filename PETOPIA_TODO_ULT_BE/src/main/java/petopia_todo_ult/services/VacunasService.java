package petopia_todo_ult.services;

import petopia_todo_ult.models.Vacunas;

import java.util.List;
import java.util.Optional;

public interface VacunasService {
    Vacunas createVacunas (Vacunas vacunas);

    Optional<Vacunas> getVacunasById (Long id_vac);

    List<Vacunas> getAllVacunas();
}

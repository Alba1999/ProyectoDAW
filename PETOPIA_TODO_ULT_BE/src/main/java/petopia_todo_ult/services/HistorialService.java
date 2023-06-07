package petopia_todo_ult.services;

import petopia_todo_ult.models.Historial;

import java.util.List;
import java.util.Optional;

public interface HistorialService {
    Historial createHistorial(Historial historial);

    Optional<Historial> getHistorialById(Long num_his);

    List<Historial> getAllHistorial();

}

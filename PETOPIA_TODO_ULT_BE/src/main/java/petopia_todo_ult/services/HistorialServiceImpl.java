package petopia_todo_ult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petopia_todo_ult.models.Historial;
import petopia_todo_ult.repositories.HistorialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialServiceImpl implements HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public Historial createHistorial(Historial historial) {
        return historialRepository.save(historial);
    }

    @Override
    public Optional<Historial> getHistorialById(Long num_his) {
        return historialRepository.findById(num_his);
    }

    @Override
    public List<Historial> getAllHistorial() {
        return historialRepository.findAll();
    }
}

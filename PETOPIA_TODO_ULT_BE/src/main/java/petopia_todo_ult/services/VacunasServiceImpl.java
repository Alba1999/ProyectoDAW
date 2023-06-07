package petopia_todo_ult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petopia_todo_ult.models.Vacunas;
import petopia_todo_ult.repositories.VacunasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VacunasServiceImpl implements VacunasService {
    @Autowired
    private VacunasRepository vacunasRepository;

    @Override
    public Vacunas createVacunas (Vacunas vacunas) {
        return vacunasRepository.save(vacunas);
    }

    @Override
    public Optional<Vacunas> getVacunasById (Long id_vac) {
        return vacunasRepository.findById(id_vac);
    }

    @Override
    public List<Vacunas> getAllVacunas() {
        return vacunasRepository.findAll();
    }
}

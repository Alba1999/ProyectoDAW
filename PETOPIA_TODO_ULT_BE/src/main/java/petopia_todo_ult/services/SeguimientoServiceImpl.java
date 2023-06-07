package petopia_todo_ult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petopia_todo_ult.models.Seguimiento;
import petopia_todo_ult.repositories.SeguimientoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {
    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Override
    public Seguimiento createSeguimiento (Seguimiento seguimiento) {
        return  seguimientoRepository.save(seguimiento);
    }

    @Override
    public Optional<Seguimiento> getSeguimientoById(Long num_caso) {
        return seguimientoRepository.findById(num_caso);
    }

    @Override
    public List<Seguimiento> getAllSeguimientos() {
        return seguimientoRepository.findAll();
    }
}

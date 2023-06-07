package petopia_todo_ult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petopia_todo_ult.models.Clinica;
import petopia_todo_ult.repositories.ClinicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaServiceImpl implements ClinicaService {
    @Autowired
    private ClinicaRepository clinicaRepository;

    @Override
    public Clinica createClinica (Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override
    public Optional<Clinica> getClinicasById(Long cif) {
        return clinicaRepository.findById(cif);
    }

    @Override
    public List<Clinica> getAllClinicas() {
        return clinicaRepository.findAll();
    }
}

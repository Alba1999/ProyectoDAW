package petopia_todo_ult.services;

import petopia_todo_ult.models.Clinica;

import java.util.List;
import java.util.Optional;

public interface ClinicaService {
    Clinica createClinica (Clinica clinica);

    Optional<Clinica> getClinicasById(Long cif);

    List<Clinica> getAllClinicas();
}

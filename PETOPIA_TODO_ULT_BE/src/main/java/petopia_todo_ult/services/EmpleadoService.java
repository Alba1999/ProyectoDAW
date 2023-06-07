package petopia_todo_ult.services;

import petopia_todo_ult.models.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    Empleado createEmpleado (Empleado empleado);

    Optional<Empleado> getEmpleadoById (Long num_Seg_soc);

    List<Empleado> getAllEmpleados();
}

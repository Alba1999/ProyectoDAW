package petopia_todo_ult.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seg_soc")
    private Long num_seg_soc;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_empleado")
    private TipoEmpleado tipo_empleado;

    @ManyToOne
    @JoinColumn(name = "clinica_cif")
    private Clinica clinica;

    @ManyToMany
    @JoinTable(name = "cuidado_animal",
            joinColumns = @JoinColumn(name = "empleado_num_seg_soc"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private Set<Animal> animals = new HashSet<>();
}

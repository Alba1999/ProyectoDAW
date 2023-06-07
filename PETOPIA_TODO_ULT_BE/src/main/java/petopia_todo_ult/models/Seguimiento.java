package petopia_todo_ult.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "seguimiento")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_caso")
    private Long num_caso;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "empleado_num_seg_soc", referencedColumnName = "num_seg_soc")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_animal_seg", referencedColumnName = "id")
    private Animal animal;
}

//@JoinColumn(name = "animal_chip")

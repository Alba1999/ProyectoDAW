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
@Table(name = "vacunas")
public class Vacunas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vac")
    private Long id_vac;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_caducidad")
    private Date fecha_caducidad;

    @Column(name = "marca")
    private String marca;

    @Column(name = "lote")
    private String lote;

    @ManyToOne
    @JoinColumn(name = "clinica_cif")
    private Clinica clinica;
}

package petopia_todo_ult.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_his")
    private Long num_his;

    private String patologias;

    private String veterinario;

    private Date fecha_consulta;

    private String medicamentos;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "clinica_historial",
            joinColumns = @JoinColumn(name = "historial_num_his"),
            inverseJoinColumns = @JoinColumn(name = "clinica_cif"))
    private Set<Clinica> clinicas = new HashSet<>();

}

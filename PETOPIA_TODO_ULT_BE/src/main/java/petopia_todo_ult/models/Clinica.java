package petopia_todo_ult.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @Column(name = "cif")
    private Long cif;

    private String num_contacto;

    private String nombre;

    private String direccion;

    private String ciudad;

    @ManyToMany(mappedBy = "clinicas")
    private Set<Historial> historiales = new HashSet<>();
}

package petopia_todo_ult.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chip;
    private String name;

    //private String species;

    private String sex;

    private String color;

    private String size;

    @Enumerated(EnumType.STRING)
    private State state;

    private Date date_of_birth;

    private String description;

    private String animal_type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;
}



//@Entity
//public class Card {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private Date createdAt;
//
//    private String description;
//
//
//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }
//
//    private File file;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "image_id")
//    private Image image;
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//}

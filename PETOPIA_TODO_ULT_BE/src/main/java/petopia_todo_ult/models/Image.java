package petopia_todo_ult.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.sql.Blob;

@Entity
 @ToString
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    private String type;

    @Lob
    @Column(name = "picture", length = 100000)
    private byte[] picture;

//    @OneToOne(mappedBy = "image")
//    @JsonIgnore
//    private Card card;

    public Image(String name, String type, byte[] picture){
        this.name = name;
        this.type = type;
        this.picture = picture;
    }

    public Image() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}

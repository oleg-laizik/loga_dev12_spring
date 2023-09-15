package loga.dev.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Data;
import jakarta.persistence.*;
@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String content;

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Note() {

    }
}

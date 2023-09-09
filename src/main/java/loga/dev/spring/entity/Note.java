package loga.dev.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Data;

@Data
@Getter
@Setter
@ToString
public class Note {

    private Long id;

    private String title;

    private String content;

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

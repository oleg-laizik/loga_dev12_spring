package loga.dev12.spring.entity;

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

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

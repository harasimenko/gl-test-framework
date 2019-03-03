package entitites;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EntityPostDTO {
    private Integer userId;
    private String title;
    private String body;

    public EntityPostDTO(Integer userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}

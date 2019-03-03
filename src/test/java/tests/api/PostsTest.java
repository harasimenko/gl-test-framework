package tests.api;

import com.jayway.restassured.response.Response;
import commonLibs.api.PostsAPI;
import entitites.EntityGetDTO;
import entitites.EntityPostDTO;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostsTest extends BaseTest {
    private PostsAPI postsAPI = new PostsAPI();

    @Test(description = "User is able to create a new post")
    public void createNewPost() {
        String title = faker.book().title();
        String body = faker.book().author();
        Integer userId = 1;

        EntityPostDTO postDTO = new EntityPostDTO(userId, title, body);

        Response response = postsAPI.createNewPost(postDTO);
        Integer postId = response.getBody().as(EntityGetDTO.class).getId();
        response.then().assertThat().statusCode(SC_CREATED);

        postsAPI.getPosts(1).then()
                .assertThat().body("userId", equalTo(userId));
//                .assertThat().body("id", equalTo(postId))
//                .assertThat().body("title", equalTo(title))
//                .assertThat().body("body", equalTo(body));
    }
}
package tests.api;

import com.jayway.restassured.response.Response;
import commonLibs.steps.PostsSteps;
import entitites.EntityPostDTO;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;

public class PostsTest extends BaseTest {
    private PostsSteps postsSteps = new PostsSteps();

    @Test(description = "User is able to create a new post")
    public void createNewPost() {
        EntityPostDTO entityPostDTO = postsSteps.getNewPostPostDto();

        Response response = postsSteps.createNewPost(entityPostDTO);
        Integer postId = postsSteps.getPostId(response);

        postsSteps.verifyStatusCode(response, SC_CREATED);
        postsSteps.verifyPost(postId, entityPostDTO);
    }
}
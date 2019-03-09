package commonLibs.steps;

import com.jayway.restassured.response.Response;
import commonLibs.api.PostsAPI;
import entitites.EntityGetDTO;
import entitites.EntityPostDTO;
import io.qameta.allure.Step;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostsSteps extends BaseSteps {
    PostsAPI postsAPI = new PostsAPI();

    public EntityPostDTO getNewPostPostDto() {
        String title = faker.book().title();
        String body = faker.book().author();
        //hardcoded userId because of limitation of public API
        Integer userId = 1;

        return new EntityPostDTO(userId, title, body);
    }

    @Step("User creates a new post")
    public Response createNewPost(EntityPostDTO entityPostDTO) {
        return postsAPI.createNewPost(entityPostDTO);
    }

    @Step("User gets post by id")
    public Response getPost(Integer id) {
        return postsAPI.getPost(id);
    }

    @Step("User gets post id from response")
    public Integer getPostId(Response response) {
        return response.getBody().as(EntityGetDTO.class).getId();
    }

    @Step("Verify response status code")
    public void verifyStatusCode(Response response, int httpStatus) {
        response.then().assertThat().statusCode(SC_CREATED);
    }

    @Step("Verify post")
    public void verifyPost(Integer postId, EntityPostDTO entityPostDTO) {
        Response response = getPost(postId);
        verifyUserId(response, entityPostDTO);
        verifyTitle(response, entityPostDTO);
        verifyBody(response, entityPostDTO);
    }

    @Step("Verify user id")
    public void verifyUserId(Response response, EntityPostDTO entityPostDTO) {
        response.then()
                .assertThat().body("userId", equalTo(entityPostDTO.getUserId()));
    }

    @Step("Verify title")
    public void verifyTitle(Response response, EntityPostDTO entityPostDTO) {
        response.then()
                .assertThat().body("title", equalTo(entityPostDTO.getTitle()));
    }

    @Step("Verify body")
    public void verifyBody(Response response, EntityPostDTO entityPostDTO) {
        response.then()
                .assertThat().body("body", equalTo(entityPostDTO.getBody()));
    }
}

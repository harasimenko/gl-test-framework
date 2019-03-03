package commonLibs.api;

import com.jayway.restassured.response.Response;
import entitites.EntityPostDTO;

import static tests.api.BaseTest.configReader;

public class PostsAPI extends BaseAPI {
    public Response createNewPost(EntityPostDTO entityPostDTO) {
        return apiRequest().body(entityPostDTO).
                post(configReader.getPostsUrl());
    }

    public Response getPosts(Integer id) {
        return apiRequest().get(configReader.getPostsUrl() + "/" + id);
    }
}

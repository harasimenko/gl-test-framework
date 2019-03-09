package commonLibs.api;

import com.jayway.restassured.response.Response;
import commonLibs.configReaders.EnvironmentConfigReader;
import entitites.EntityPostDTO;

import java.io.IOException;

public class PostsAPI extends BaseAPI {
    EnvironmentConfigReader configReader;

    {
        try {
            configReader = new EnvironmentConfigReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response createNewPost(EntityPostDTO entityPostDTO) {
        return apiRequest().body(entityPostDTO).
                post(configReader.getPostsUrl());
    }

    public Response getPost(Integer id) {
        return apiRequest().get(configReader.getPostsUrl() + "/" + id);
    }
}

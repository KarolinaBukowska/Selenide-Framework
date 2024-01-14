package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Data;
import data.Users;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

public class BaseTest {

    protected Users users;
    protected Data data;

    public void setUpUsersData(String relativePath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String filePath = getPathToResource(relativePath);
            System.out.println("Attempting to load file from path: " + filePath);
            users = objectMapper.readValue(new File(filePath), Users.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpTestData(String relativePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String filePath = getPathToResource(relativePath);
            data = objectMapper.readValue(new File(filePath), Data.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getPathToResource(String relativePath) {
        return Paths.get("src", "test", "resources", relativePath).toString();
    }

}

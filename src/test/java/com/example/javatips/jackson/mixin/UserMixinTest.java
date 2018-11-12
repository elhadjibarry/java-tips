package com.example.javatips.jackson.mixin;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 */
public class UserMixinTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(123, "James", 23, "Male", "james@gmail.com", "1234567890");
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test
    public void testJacksonMixin() throws IOException {

        ObjectMapper objectMapper = buildObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        System.out.println(userJson);

        objectMapper.addMixIn(User.class, UserMixin.class);
        final User userPojo = objectMapper.readValue(userJson, User.class);
        System.out.println(userPojo);
    }

    private static ObjectMapper buildObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig()
                                               .getDefaultVisibilityChecker()
                                               .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                                               .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                                               .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                                               .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return objectMapper;
    }
}

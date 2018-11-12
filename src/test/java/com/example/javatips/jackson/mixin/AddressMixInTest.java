package com.example.javatips.jackson.mixin;

import java.io.IOException;
import org.junit.Test;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 */
public class AddressMixInTest {

    @Test
    public void testAdressMix() throws IOException {

        Address address = new Address("Hyderabad",  "Telangana");
        ObjectMapper mapper = buildMapper();
        final String json = mapper.writeValueAsString(address);
        System.out.println(json);
        mapper.addMixIn(Address.class, AddressMixin.class);
        final Address deserializedUser = mapper.readValue(json, Address.class);
        System.out.println(deserializedUser);
    }


    private static ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(mapper.getSerializationConfig()
                                   .getDefaultVisibilityChecker()
                                   .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                                   .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                                   .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                                   .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return mapper;
    }

}

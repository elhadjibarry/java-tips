package com.example.javatips.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public abstract class UserMixin {

    @JsonCreator
    public UserMixin(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("age") int age,
                     @JsonProperty("gender") String gender, @JsonProperty("email") String email, @JsonProperty("phoneNo") String phoneNo) {

    }

}

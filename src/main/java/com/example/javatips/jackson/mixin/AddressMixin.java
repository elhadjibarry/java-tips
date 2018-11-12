package com.example.javatips.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class AddressMixin {

    @JsonCreator
    public AddressMixin(
            @JsonProperty("city") String city,
            @JsonProperty("state") String state) {
        System.out.println("Wont be called");
    }
}

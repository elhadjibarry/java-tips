package com.example.javatips.jackson.mixin;

/**
 *
 */
public class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
        ;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", state=" + state + "]";
    }
}

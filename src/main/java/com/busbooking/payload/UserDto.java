package com.busbooking.payload;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Getters and setters
}


package com.wms.model;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
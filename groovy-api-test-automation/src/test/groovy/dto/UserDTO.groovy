package dto

import groovy.transform.CompileStatic
import helpers.StringHelper

@CompileStatic
class UserDTO {
    public String Email, Name, Gender, Status

    UserDTO() {}

    UserDTO(String email, String name, String gender, String status) {
        Email = email
        Name = name
        Gender = gender
        Status = status
    }

    static UserDTO getDefault() {
        return new UserDTO() {
            {
                Email = StringHelper.getRandomEmail()
                Name = "My name"
                Gender = "male"
                Status = "active"
            }
        }
    }
}

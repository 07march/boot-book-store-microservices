package by.bookstore.userservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private static int incId = 1;
    private int id = incId++;

    @NotBlank(message = "not blank!")
    @NotNull(message = "Login is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String login;

    @NotBlank(message = "not blank!")
    @NotNull(message = "name is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String name;

    @NotBlank(message = "not blank!")
    @NotNull(message = "password is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String password;

    @NotNull(message = "not null! enter USER or ADMIN")
    private String role;

}

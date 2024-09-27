package com.ProjectBlogProject.playloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min=4, message = "Name must should be 4 Alphabet")
    private String name;
    @Email(message = "Enter valid email address")
    private String email;
    @NotEmpty
    @Size(min = 5, message = "minmum 5 number of password enter")
    private String password;
    @NotEmpty
    @Size(min = 10, message = "write 10 sentence")
    private String about;
}

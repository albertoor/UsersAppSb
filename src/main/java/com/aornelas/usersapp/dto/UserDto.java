package com.aornelas.usersapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "user.fn.notnull")
    @Size(min = 3, max = 50, message = "user.fn.size")
    @JsonProperty("firstName")
    private String firstName;

    @NotNull(message = "user.ln.notnull")
    @Size(min = 3, max = 50, message = "user.ln.size")
    @JsonProperty("lastName")
    private String lastName;

    @NotNull(message = "user.email.notnull")
    @Email(message = "user.email.notValid")
    @JsonProperty("email")
    private String email;

    @JsonFormat(pattern = "MM-dd-yyyy")
    @JsonProperty("dob")
    private String dob;

    @NotNull
    @JsonFormat(pattern = "\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @NotNull
    @JsonProperty("password")
    private String password;











}

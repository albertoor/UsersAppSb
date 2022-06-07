package com.aornelas.usersapp.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Entity(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotNull(message = "First name cannot be null")
    @Size(min = 3, max = 50, message = "First name should be at least {min} characters length and {max} maximum")
    @Column(name = "first_name", length = 50)
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 3, max = 50, message = "Last name should be at least {min} characters length and {max} maximum")
    @Column(name = "last_name", length = 50)
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Please provide a valid address example@domain.com")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Date of birth cannot be null")
    @JsonFormat(pattern = "MM-dd-yyyy")
    @Column(name = "dob")
    private LocalDate dob;

    @NotNull(message = "Phone number cannot be null")
    @JsonFormat(pattern = "\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "password")
    private String password;

    public User(String firstName, String lastName, String email, LocalDate dob, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}

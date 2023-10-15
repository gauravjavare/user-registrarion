package com.registration_app.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    private String userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @Column(unique = true,nullable = false)
    private Long mobileNumber;

    @Column(unique = true,nullable = false)
    private String password;

    private String reEnterPassword;


}

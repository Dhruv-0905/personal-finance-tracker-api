package com.financetracker.entity;

import jakarta.presistence.*;
import jakarta.Validation.constraints.Email;
import jakarta.Validation.constraints.NotBlank;
import jakarta.Validation.constraints.Size;
import lombok.AllArgsConstrucor;
import lombok.Date;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import otg.hibernate.annotaitons.UpdateTimestamp;

import java.lang.annotation.Inherited;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor

public class User{
    @Id
    @GeneratedValue(stratergy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First name is a Mandatory Field")
    @Size(max = 50)
    @Column(name = "first name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is Mandatory Field")
    @Size(max = 50)
    @Column(name = "last name", nullable = false)
    private String lastName;

    @Email(message = "Enter a valid Email")
    @NotBlank(message = "Email is required")
    @Colums(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Passoword is Required")
    @Size(min = 8, message = "Password should be 8 atleast characters long")
    @Column(nullable = false)
    private String password;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updateable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "User", cascade = cascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();

}




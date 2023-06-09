package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String username;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    List<Post> posts;
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(User copy) {
        this.id= copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;

    }
}

package com.example.aufgabenverwaltung.model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Table(name = "crypto_user")
@NamedQuery(name = "User.checkPassword", query = "SELECT u FROM User u WHERE u.name = :name and password = public.crypt(text(:password), text(password))")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id",nullable = false, updatable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @ColumnTransformer(write = "public.crypt(?, gen_salt('bf', 8))")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGroup userGroup;

    public UserGroup getUserGroup() { return userGroup; }
    public void setUserGroup(UserGroup userGroup) { this.userGroup = userGroup; }

    public User(final String name, final String password, final String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    protected User(){}

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
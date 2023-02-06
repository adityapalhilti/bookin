package com.bookin.bookin.entity;


import com.bookin.bookin.requestmodels.JwtRegister;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username" ,nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "roles")
    private String roles;

    @Column(name="active")
    private boolean active;

    public Users(JwtRegister jwtRegister) {
    }
}

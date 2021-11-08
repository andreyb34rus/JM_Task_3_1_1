package com.andreyb34rus.JM_Task_3_1_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login_name")
    private String name; // уникальное значение

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();


    public String getRolesAsString() {
        boolean first = true;
        String s = "";
        for (Role role : getRoles()) {
            if (!first) {
                s += ", ";
            }
            s += role.getRole();
            first = false;
        }
        return s;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}

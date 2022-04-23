package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        this.users.add(user);
        user.setRole(this);
    }

    public void removeUser(User user){
        this.users.remove(user);
        user.setRole(null);
    }
}

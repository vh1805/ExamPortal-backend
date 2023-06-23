package com.Sprinhboot.ExamPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="roles")
public class Role {
    @Id
    private Long roleId;
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY , mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    public Role(){

    }
}

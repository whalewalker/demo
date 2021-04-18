package com.example.demo.models;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

import static com.example.demo.models.UserPermission.*;

@Getter
public enum  UserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions){
        this.permissions = permissions;
    }


}

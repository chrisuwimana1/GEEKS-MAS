package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {
    @Id
    @Column(length = 30)
    private String username;
    @Column(length = 30)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @OneToOne(mappedBy = "user")
    private Faculty faculty;

    @OneToOne(mappedBy = "user")
    private Student student;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAdmin(){
        return role.equals(Role.ADMIN);
    }

    public boolean isStudent(){
        return role.equals(Role.STUDENT);
    }

    public boolean isFaculty(){
        return role.equals(Role.FACULTY);
    }

    public Integer getIdOwner(){
        if(faculty != null){
            return faculty.getId();
        }else if (student != null){
            return student.getId();
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

}

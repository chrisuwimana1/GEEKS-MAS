package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Location implements Serializable {
    @Id
    @Column(length = 5)
    private String id;
    @Column(nullable = false, length = 30)
    private String name;

    public Location(){}
    public Location(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String location) {
        this.name = location;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", location='" + name + '\'' +
                '}';
    }
}

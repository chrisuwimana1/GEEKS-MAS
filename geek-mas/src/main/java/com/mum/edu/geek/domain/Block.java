package com.mum.edu.geek.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Block implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 20)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "block")
    private List<CancelledSession> cancelledSession;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CancelledSession> getCancelledSession() {
        return cancelledSession;
    }

    public void setCancelledSession(List<CancelledSession> cancelledSession) {
        this.cancelledSession = cancelledSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Block)) return false;
        Block block = (Block) o;
        return Objects.equals(getId(), block.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cancelledSession=" + cancelledSession +
                '}';
    }
}

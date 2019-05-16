package com.mum.edu.geek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames={"faculty_id", "startDate"}),
        @UniqueConstraint(columnNames={"faculty_id", "block_id"})
})
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false, length = 10)
    private String roomId;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Course course;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Faculty faculty;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Block block;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Objects.equals(getId(), section.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", roomId='" + roomId + '\'' +
                ", course=" + course +
                ", faculty=" + faculty +
                ", block=" + block +
                '}';
    }
}
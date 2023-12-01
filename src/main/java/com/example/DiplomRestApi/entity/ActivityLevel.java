package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "activityLevels")
public class ActivityLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public ActivityLevel() {
    }

    public ActivityLevel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityLevel that = (ActivityLevel) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ActivityLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

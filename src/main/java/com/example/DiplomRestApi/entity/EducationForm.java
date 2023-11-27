package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "education_forms")
public class EducationForm {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public EducationForm() {
    }

    public EducationForm(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        EducationForm that = (EducationForm) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EducationForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

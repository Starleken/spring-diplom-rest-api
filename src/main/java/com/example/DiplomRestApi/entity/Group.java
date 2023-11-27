package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curator_id")
    public Curator curator;

    public Group() {
    }

    public Group(Long id, String name, Curator curator) {
        this.id = id;
        this.name = name;
        this.curator = curator;
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

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && Objects.equals(name, group.name) && Objects.equals(curator, group.curator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, curator);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", curator=" + curator +
                '}';
    }
}

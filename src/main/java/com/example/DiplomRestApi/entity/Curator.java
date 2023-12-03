package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "curators")
public class Curator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    public Group group;

    public Curator() {
    }

    public Curator(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curator curator = (Curator) o;
        return Objects.equals(id, curator.id) && Objects.equals(user, curator.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }

    @Override
    public String toString() {
        return "Curator{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}

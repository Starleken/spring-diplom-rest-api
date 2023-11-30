package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registrationAddress")
    private String registrationAddress;

    @Column(name = "residentialAddress")
    private String residentialAddress;

    @ManyToOne()
    @JoinColumn(name = "educationForm_id")
    private EducationForm educationForm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
    }

    public Student(Long id, String registrationAddress, String residentialAddress, EducationForm educationForm, User user, Group group) {
        this.id = id;
        this.registrationAddress = registrationAddress;
        this.residentialAddress = residentialAddress;
        this.educationForm = educationForm;
        this.user = user;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(registrationAddress, student.registrationAddress) && Objects.equals(residentialAddress, student.residentialAddress) && Objects.equals(educationForm, student.educationForm) && Objects.equals(user, student.user) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationAddress, residentialAddress, educationForm, user, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", registrationAddress='" + registrationAddress + '\'' +
                ", residentialAddress='" + residentialAddress + '\'' +
                ", educationForm=" + educationForm +
                ", user=" + user +
                ", group=" + group +
                '}';
    }
}

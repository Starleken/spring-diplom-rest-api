package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registrationAddress")
    private String registrationAddress;

    @Column(name = "residentialAddress")
    private String residentialAddress;

    @ManyToOne()
    @JoinColumn(name = "educationForm_id")
    private EducationFormEntity educationForm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String registrationAddress, String residentialAddress, EducationFormEntity educationForm, UserEntity user, GroupEntity group) {
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

    public EducationFormEntity getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationFormEntity educationFormEntity) {
        this.educationForm = educationFormEntity;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity groupEntity) {
        this.group = groupEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity studentEntity = (StudentEntity) o;
        return id == studentEntity.id && Objects.equals(registrationAddress, studentEntity.registrationAddress) && Objects.equals(residentialAddress, studentEntity.residentialAddress) && Objects.equals(educationForm, studentEntity.educationForm) && Objects.equals(user, studentEntity.user) && Objects.equals(group, studentEntity.group);
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

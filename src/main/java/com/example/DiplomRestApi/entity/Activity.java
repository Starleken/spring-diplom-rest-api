package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Date date;

    @Column(nullable = false)
    private Integer place;

    @Column
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "activityType_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private ActivityType activityType;

    @ManyToOne
    @JoinColumn(name = "activityLevel_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private ActivityLevel activityLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private User user;

    public Activity() {
    }

    public Activity(Long id, String name, Date date, Integer place, String imageURL, ActivityType activityType, ActivityLevel activityLevel) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.imageURL = imageURL;
        this.activityType = activityType;
        this.activityLevel = activityLevel;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(id, activity.id) && Objects.equals(name, activity.name) && Objects.equals(date, activity.date) && Objects.equals(place, activity.place) && Objects.equals(imageURL, activity.imageURL) && Objects.equals(activityType, activity.activityType) && Objects.equals(activityLevel, activity.activityLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, place, imageURL, activityType, activityLevel);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", place=" + place +
                ", imageURL='" + imageURL + '\'' +
                ", activityType=" + activityType +
                ", activityLevel=" + activityLevel +
                '}';
    }
}

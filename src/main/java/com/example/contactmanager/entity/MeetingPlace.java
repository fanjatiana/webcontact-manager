package com.example.contactmanager.entity;

import jakarta.persistence.*;

@Entity
@Table
public class MeetingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String meetingPlace;

    public MeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public MeetingPlace() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }
}

package com.example.contactmanager.entity;

import jakarta.persistence.*;

@Table
@Entity
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String relationshipType;

    public Relationship(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public Relationship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }
}

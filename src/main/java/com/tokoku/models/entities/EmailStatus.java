package com.tokoku.models.entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_status_email")
public class EmailStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

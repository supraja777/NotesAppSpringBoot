package com.supraja.NotesApplication.entity;

import com.supraja.NotesApplication.validation.DescriptionCode;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "notes_app")
public class NotesEntity {
    public NotesEntity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "NotesEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotesEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    @DescriptionCode(value= "NOTE", message = "description should start with NOTE")
    private String description;
}

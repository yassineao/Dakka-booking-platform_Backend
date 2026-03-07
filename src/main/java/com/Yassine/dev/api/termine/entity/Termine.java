package com.Yassine.dev.api.termine.entity;

import com.Yassine.dev.api.termine.enums.Occasion;
import com.Yassine.dev.api.termine.enums.Status;
import jakarta.persistence.*;

import java.util.UUID;


import java.time.LocalDateTime;
@Entity
@Table(name = "Termine")
public class Termine {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Ort
    private String region;          // NRW / Anderer Ort
    private String exactLocation;   // genauer Ort

    // Kunde
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hallOrLocation;  // Saal / Location

    // Event Details
    @Enumerated(EnumType.STRING)
    private Occasion occasion;       // Hochzeit etc
    private String packageName;     // Paket
    private String bookingType;     // Meeting / Event etc
    private String duration;        // Dauer



    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Termin Datum
    private LocalDateTime startDate;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    private LocalDateTime endDate;

    // System fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getter & Setter

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getExactLocation() {
        return exactLocation;
    }

    public void setExactLocation(String exactLocation) {
        this.exactLocation = exactLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHallOrLocation() {
        return hallOrLocation;
    }

    public void setHallOrLocation(String hallOrLocation) {
        this.hallOrLocation = hallOrLocation;
    }

    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
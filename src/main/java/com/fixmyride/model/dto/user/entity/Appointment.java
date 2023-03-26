package com.fixmyride.model.dto.user.entity;




import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    @Column(name = "start_time")
    private LocalDateTime startTime;


    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicleId;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", user=" + user +
                ", mechanic=" + mechanic +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", notes='" + notes + '\'' +
                ", vehicleId=" + vehicleId +
                '}';
    }
}

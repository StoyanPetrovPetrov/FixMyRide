package com.fixmyride.model.dto.user.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class CarService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private double cost;



    public CarService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appointment=" + appointment +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}

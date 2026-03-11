package com.klef.fsad.exam;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "services")
public class Service {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "cost")
    private double cost;

    public Service() {}

    public Service(String name, LocalDate date, String status, String description, double cost) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.description = description;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}

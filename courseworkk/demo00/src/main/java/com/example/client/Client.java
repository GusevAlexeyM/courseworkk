package com.example.client;
import jakarta.persistence.*;

@Entity
@Table(name = "client")// позволяет Джава-класс представлять, как объект базы данных. defines that a class can be mapped to a table.
public class Client {
    private Long id;
    private String full_name;
    private String visit_date;
    private String service;
    private String master_name;

    protected Client() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    @Override
    public String toString() {
        return "performance [id=" + id + ", full name=" + full_name + ", visit_date=" + visit_date + ", service=" + service + ", master=" + master_name + "]";
    }
}








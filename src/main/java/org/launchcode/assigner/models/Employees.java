package org.launchcode.assigner.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employees {



    @Id
    @GeneratedValue
    private int id;



    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToOne
    private Departments departments;

    public Employees(String name){
        this.name = name;
    }

    public Employees () {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartment(Departments departments) {
        this.departments = departments;
    }
}

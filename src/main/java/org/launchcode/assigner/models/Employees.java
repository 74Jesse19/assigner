package org.launchcode.assigner.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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



    @OneToMany
    @JoinColumn(name="employees_id")
    private List<FileAssigner> fileAssigner = new ArrayList<>();

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

    public List<FileAssigner> getFiles() {
        return fileAssigner;
    }

    public void setFiles(List<FileAssigner> files) {
        this.fileAssigner = files;
    }
}

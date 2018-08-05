package org.launchcode.assigner.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class FileAssigner {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min=3, max=15)
    private String fileNumber;

    private Date date = new Date();


    @ManyToOne
    private Employees employees;

    public FileAssigner(){}


    public int getId() {
        return id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Date getDate() {
        return date;
    }


}

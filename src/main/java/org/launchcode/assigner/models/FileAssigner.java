package org.launchcode.assigner.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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



    private int itemIndex;

//    @ManyToMany
//    private List<Departments> departments;

    @ManyToOne
//    private List<Employees> employees;
    private Employees employees;

    public FileAssigner(){}

//    public void addItem(Departments item){
//        departments.add(item);
//    }

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

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
}

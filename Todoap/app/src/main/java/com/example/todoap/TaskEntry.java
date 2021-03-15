package com.example.todoap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName="task")
public class TaskEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private int priority;
    private Date updateAt;
    @Ignore
    public  TaskEntry(String description, int priority,Date updateAt){
        this.description=description;
        this.priority=priority;
        this.updateAt=updateAt;
    }
    public  TaskEntry(int getId,String description,int priority,Date updateAt){
        this.id=id;
        this.description=description;
        this.priority=priority;
        this.updateAt=updateAt;

    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

}

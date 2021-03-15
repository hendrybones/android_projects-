package com.example.todoap;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT*FROM task ORDER BY priority")
    List<TaskEntry>loadAllTask();
    @Insert
    void  insertTask(TaskEntry taskEntry);
    @Update(onConflict=onConflictStrategy.REPLACE)
    void updateTask(TaskEntry taskEntry);
    @Delete
    void deleteTask(TaskEntry taskEntry);
}

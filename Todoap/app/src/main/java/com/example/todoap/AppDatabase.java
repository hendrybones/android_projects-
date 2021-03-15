package com.example.todoap;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG=AppDatabase.class.getSimpleName();
    private static final Object LOCK=new Object();
    private static final String=DATABASE_NAME="todo";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                log.d(LOG_TAG,msg:"Creating new database instance");
                sInstance= Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,AppDatabase.DATABASE_NAME)
                        .build();

            }
        }
        log.d(LOG_TAG, msg:"Getting the database instances");
        return sInstance;


    }

}

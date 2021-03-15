package com.example.todoap;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataConverter {
    @TypeConverter
    public static Date todate(long timestamp){
        return  timestamp==null ? : new  Date(timestamp);
    }
    @TypeConverter
    public static  long toTimestamp(Date date){
        return date==null ? null : date.getTime();
    }
}

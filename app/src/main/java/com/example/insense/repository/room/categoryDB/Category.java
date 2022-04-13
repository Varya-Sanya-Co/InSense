package com.example.insense.repository.room.categoryDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "description")
    public String description;
}

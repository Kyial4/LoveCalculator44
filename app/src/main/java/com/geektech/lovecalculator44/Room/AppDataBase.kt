package com.geektech.lovecalculator44.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.lovecalculator44.Model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun historyDao():HistoryDao
}
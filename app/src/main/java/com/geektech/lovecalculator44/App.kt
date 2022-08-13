package com.geektech.lovecalculator44

import android.app.Application
import androidx.room.Room
import com.geektech.lovecalculator44.Room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {
    companion object{
        lateinit var db: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this,AppDataBase::class.java,"love-base").allowMainThreadQueries().build()
    }

}

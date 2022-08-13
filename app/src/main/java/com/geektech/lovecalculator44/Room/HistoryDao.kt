package com.geektech.lovecalculator44.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.lovecalculator44.Model.LoveModel

@Dao
interface HistoryDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_model ORDER BY firstName")
    fun getAll(): LiveData<List<LoveModel>>

}

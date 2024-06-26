package com.example.johnapp.DAO

import Module
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ModuleDao {
    @Insert
    suspend fun insertModule(module: Module)

    @Update
    suspend fun updateModule(module: Module)

    @Delete
    suspend fun deleteModule(module: Module)

    @Query("SELECT * FROM Modules WHERE moduleId = :moduleId")
    suspend fun getModuleById(moduleId: Int): Module?

    @Query("SELECT * FROM Modules")
    suspend fun getAllModules(): List<Module>
}

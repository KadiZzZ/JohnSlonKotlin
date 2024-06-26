package com.example.johnapp.repositories

import Module
import com.example.johnapp.database.AppDatabase

class ModuleRepository(private val db: AppDatabase) {
    private val moduleDao = db.moduleDao()

    suspend fun insertModule(module: Module) {
        moduleDao.insertModule(module)
    }

    suspend fun getModuleById(id: Int): Module? {
        return moduleDao.getModuleById(id)
    }

    suspend fun getAllModules(): List<Module> {
        return moduleDao.getAllModules()
    }

    suspend fun deleteModule(module: Module) {
        moduleDao.deleteModule(module)
    }
}

package com.example.kplist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kplist.data.models.DbModels.PreviewDbModel

@Database(entities = [PreviewDbModel::class], version = 4)
abstract class KpDatabase: RoomDatabase() {

    abstract val PreviewDAO: PreviewDao

    companion object{
        @Volatile
        private var INSTANCE : KpDatabase? = null
        fun getInstance(context: Context):KpDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext, KpDatabase::class.java, "database4"
                    ).build()
                }
                return instance
            }
        }

    }
}
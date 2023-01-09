package com.example.kplist.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kplist.data.models.dbModels.*

@Database(entities = [
    PreviewDbModel::class,
    MovieDbModel::class,
    PersonDbModel::class,
    DetailDbModel::class], version = 7)
abstract class KpDatabase: RoomDatabase() {

    abstract val previewDAO: PreviewDao
    abstract val movieDAO: MovieDao
    abstract val personDAO: PersonDao
    abstract val detailDAO: DetailDao

    companion object{
        @Volatile
        private var INSTANCE : KpDatabase? = null
        fun getInstance(context: Context):KpDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext, KpDatabase::class.java, "database7"
                    ).build()
                }
                return instance
            }
        }

    }
}
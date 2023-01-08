package com.example.kplist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kplist.data.models.DbModels.*

@Database(entities = [
    PreviewDbModel::class,
    DetailDbModel::class,
    PersonDbModel::class,
    TrailerDbModel::class,
    CountryDbModel::class,
    FactDbModel::class], version = 6)
abstract class KpDatabase: RoomDatabase() {

    abstract val PreviewDAO: PreviewDao
    abstract val DetailDAO: DetailDao
    abstract val PersonDAO: PersonDao
    abstract val TrailerDAO: TrailerDao
    abstract val CountryDAO: CountryDao
    abstract val FactDAO: FactDao

    companion object{
        @Volatile
        private var INSTANCE : KpDatabase? = null
        fun getInstance(context: Context):KpDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext, KpDatabase::class.java, "database6"
                    ).build()
                }
                return instance
            }
        }

    }
}
package com.example.kplist.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kplist.data.models.dbModels.*

@Database(
    entities = [
        PreviewDbModel::class,
        PreviewByPersonDbModel::class,
        FavoritesPreviewDbModel::class,
        ReviewDbModel::class,
        MovieDbModel::class,
        PersonDbModel::class,
        DetailDbModel::class], version = 16
)
abstract class KpDatabase : RoomDatabase() {

    abstract val previewDAO: PreviewDao
    abstract val favoritesPreviewDAO: FavoritesPreviewDao
    abstract val previewByPersonDAO: PreviewByPersonDao
    abstract val reviewDAO: ReviewDao
    abstract val movieDAO: MovieDao
    abstract val personDAO: PersonDao
    abstract val detailDAO: DetailDao

    companion object {
        @Volatile
        private var INSTANCE: KpDatabase? = null
        fun getInstance(context: Context): KpDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, KpDatabase::class.java, "database16"
                    ).build()
                }
                return instance
            }
        }
    }
}
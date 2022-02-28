package app.netflixkotlin.bdd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.netflixkotlin.dataObject.Films

/**
 * Représentation de la BDD
 */
@Database(entities = [Films::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase()
{
    /** Dao des films */
    abstract fun filmsDAO(): FilmsDAO


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "film_database_3"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

   // companion object {
   //     private val INSTANCE: AppDataBase? = null
   // }
}
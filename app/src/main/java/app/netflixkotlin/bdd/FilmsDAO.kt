package app.netflixkotlin.bdd

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.netflixkotlin.dataObject.Films
import app.netflixkotlin.dataObject.Pays

/**
 * Dao pour film
 */
@Dao
interface FilmsDAO {
    /**
     * Ajoute un film
     */
    @Insert
    suspend fun insertFilms(Film: Films?)

   // @Insert
    //fun insertPays(Country: Pays?)

    /**
     * Récupère la liste des films recherchés
     */
    @get:Query("select * FROM film")
    val aLLFilms: Cursor?

    /**
     * Récupère la liste des 20 dernier films recherchés
     */
    @Query("SELECT * FROM film ORDER BY id DESC LIMIT 20 ")
    suspend fun getHistorical(): List<Films>

    //@Query("select * FROM Country where nameFilm= :nomFilm ")
    //fun getPays(nomFilm: String?): Pays?

    /**
     * Permet de supprimer tout les films recherchés
     */
    @Query("DELETE FROM film")
    suspend fun deleteAll() : Integer
}
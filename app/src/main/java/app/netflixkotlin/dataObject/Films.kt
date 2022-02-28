package app.netflixkotlin.dataObject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Représentation d'un film
 *
 * @param id du film
 * @param nom du film ou de la recherche
 * @param exist : true si la recherche à abouti, sinon faux
 * @param countries : code pays sous la forme FR|EN|DE...
 */
@Entity(tableName = "film")
class Films(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?, @ColumnInfo(name = "nom") val nom: String,
            @ColumnInfo(name = "exist") val exist: Boolean, @ColumnInfo(name = "countries") val countries: String) {

}
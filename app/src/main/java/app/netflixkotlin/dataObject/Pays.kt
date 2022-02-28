package app.netflixkotlin.dataObject

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Représentation d'un pays
 */
@Entity(tableName = "Country")
class Pays {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var nom: String? = null
    var nameFilm: String? = null
}
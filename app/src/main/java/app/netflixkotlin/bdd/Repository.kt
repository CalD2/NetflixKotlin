package app.netflixkotlin.bdd

import app.netflixkotlin.dataObject.Films

/**
 * Repo pour Films
 * @param dao des films
 */
class Repository (private val dao: FilmsDAO)
{
    /**
     * Ajoute un film dans l'historique
     * @param film à ajouter
     */
    suspend fun addFilm(film : Films)
    {
        dao.insertFilms(film)
    }

    /**
     * Récupère l'historique des films recherchés
     * @return liste de films précédement recherché
     */
    suspend fun getHistorical() : List<Films>
    {
        return dao.getHistorical()
    }

    /**
     * Supprime l'historique
     */
    suspend fun deleteAll()
    {
        dao.deleteAll()
    }
}
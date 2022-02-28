package app.netflixkotlin

/**
 * Représente un objet de réponse à l'API netflix pour savoir si un film est disponible dans un pays
 */
data class ResponseApi(val id : Int, val title : String? = null)
{

}
package app.netflixkotlin

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    /**
     * Permet d'obtenir un film ou une série à l'aide de son titre
     */
    @GET("search?")
    @Headers("x-rapidapi-host: unogsng.p.rapidapi.com", "x-rapidapi-key: edf49b3535msh1364a2bce6b3a5ap17b625jsnb2b087b4f8f0")
    suspend fun getFilm(@Query("query") title : String): Response<MutableList<ResponseApi>>
}
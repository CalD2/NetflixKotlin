package app.netflixkotlin


//import com.example.myapplication.models.Post
//import com.example.myapplication.models.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<MutableList<ResponseApi>>

    @GET("posts/{num}")
    suspend fun getPostById(@Path("num") num : Int): Response<Post>

    @GET("comments")
    suspend fun getCommentsByPost(@Query("postId") postId : Int): Response<MutableList<ResponseApi>>

    @POST("posts")
    suspend fun createPost(@Body post: ResponseApi): Response<ResponseApi>
}
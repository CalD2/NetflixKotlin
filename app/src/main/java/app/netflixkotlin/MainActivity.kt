package app.netflixkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import app.netflixkotlin.bdd.AppDataBase
import app.netflixkotlin.bdd.Repository
import app.netflixkotlin.dataObject.Films
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    /** Pour REST */
    protected val scope = CoroutineScope(Dispatchers.Main)
    /** Bdd */
    protected val database by lazy { AppDataBase.getDatabase(this) }
    /** Repository utiliser par la bdd */
    protected val repository by lazy { Repository(database.filmsDAO()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Bouton pour effectuer une recherche
     */
    fun clickSearch(view: View)
    {
        // Récupération des informations du film à l'aide de l'API
        searchFilm("toto")

        val f1 = Films(null, nom ="test", exist=true, countries ="FR|EN")

        // Ajout du film à l'historique
        addHistorical(f1)
    }

    /**
     * Bouton pour reset l'historique
     */
    fun clickReset(view: View)
    {
        lifecycleScope.launch {
            try {
                repository.deleteAll()
                Toast.makeText(
                    this@MainActivity,
                    "Historique reset !",
                    Toast.LENGTH_SHORT
                ).show()
            }catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    /**
     * Ajoute une entrée dans l'historique en base
     */
    private fun addHistorical(film : Films)
    {
        // Enregistrement du film
        lifecycleScope.launch {
            try {
                repository.addFilm(film)
                val result = repository.getHistorical().size
                Toast.makeText(
                    this@MainActivity,
                    "Success Occurred: ${result.toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    /**
     * Affiche l'historique (20 dernier éléments)
     */
    private fun displayHistorical()
    {
        lifecycleScope.launch {
            val result: List<Films> = repository.getHistorical()
        }
    }

    /**
     * Recherche un film ou une série à l'aide de son titre.
     * @param title du film ou de la série
     */
    private fun searchFilm(title : String)
    {

        scope.launch {
            try {
                // On lance l'appel REST
                val r : Response<MutableList<ResponseApi>> =  Rest.ApiClient.apiService.getFilm(title)

                // On est en succès, traitement
                if(r.isSuccessful)
                {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${r.body()?.get(0)?.title}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else // Erreur
                {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${r.errorBody()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }




    fun getRepo() : Repository
    {
        return repository
    }
}
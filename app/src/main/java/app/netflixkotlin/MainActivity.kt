package app.netflixkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Clic sur un bouton de la vue, en attendant l'ihm
     */
    fun clickButton(view: View)
    {
        executeCall()

    }


    protected val scope = CoroutineScope(Dispatchers.Main)

    /**
     * Appel rest afin de récupérer les pays dans lequel le film est disponible
     */
    private fun executeCall() {
        scope.launch {
            try {
                val response = Rest.ApiClient.apiService.getPostById(1)

                if (response.isSuccessful && response.body() != null) {
                    val content = response.body()

                    // Ici
                    Toast.makeText(
                        this@MainActivity,
                        "Success Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${response.message()}",
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
}
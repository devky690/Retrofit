package edu.towson.cosc435.abrahams.kotlin_requests

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.towson.cosc435.abrahams.kotlin_requests.repository.Repository
import edu.towson.cosc435.abrahams.kotlin_requests.ui.theme.Kotlin_requestsTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Kotlin_requestsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer{
            response ->
            if(response.isSuccessful) {
                //if we get rid of Response<Post> then we would have no
                //Response<Post>!...which would mean no more Post?
                //which retrofit would give, so then we would be left with
                //response.user_id....

                //"!" - platform type (type coming from java, which can most probably be null

                //nullable types are useful for when you want to delay fully
                //defining something but still want it
                Log.d("Response", response.body()?.user_id.toString())
                Log.d("Response", response.body()?.id.toString())
                Log.d("Response", response.body()?.title!!)
                Log.d("Response", response.body()?.body!!)
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


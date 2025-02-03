package atl.leocodingworld.ae2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import atl.leocodingworld.ae2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
	private lateinit var binding : ActivityMainBinding

	private lateinit var adapter : SerieAdapter
	private val mloSeries = mutableListOf<Serie>()

	private fun getRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl("https://peticiones.online/api/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	private fun fetchSeries() {
		CoroutineScope(Dispatchers.IO).launch {
			val call = getRetrofit().create(SerieApiService::class.java).getAllSeries()
			val seriesResult: SerieResponse? = call.body()

			runOnUiThread {
				if (call.isSuccessful) {
					val serieList = seriesResult?: emptyList()
					mloSeries.clear()
					mloSeries.addAll(serieList)
					adapter.notifyDataSetChanged()
				} else {
					showError()
				}
			}
		}
	}

	private fun displaySeries(series: List<Serie>) {
		val adapter = SerieAdapter(series)
		binding.rvSeries.layoutManager = LinearLayoutManager(this)
		binding.rvSeries.adapter = adapter

	}

	private fun showError() {
		Log.i("INFO", "Entré")
		Toast.makeText(this, "Error al cargar películas", Toast.LENGTH_SHORT).show()
	}

	private fun initRecyclerView() {
		this.adapter = SerieAdapter(mloSeries)
		binding.rvSeries.layoutManager = LinearLayoutManager(this)
		binding.rvSeries.adapter = adapter
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()

		binding = ActivityMainBinding.inflate(layoutInflater)

		this.initRecyclerView()
		fetchSeries()

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBar = insets.getInsets((WindowInsetsCompat.Type.systemBars()))
			v.setPadding(systemBar.left, systemBar.top, systemBar.right, systemBar.bottom)
			insets
		}
	}
}



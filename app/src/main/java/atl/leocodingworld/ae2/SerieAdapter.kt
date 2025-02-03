package atl.leocodingworld.ae2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SerieAdapter(private val series: List<Serie>?) : RecyclerView.Adapter<SerieViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		return SerieViewHolder(layoutInflater.inflate(R.layout.item_serie, parent, false))
	}

	override fun getItemCount(): Int = series?.size ?: 0

	override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
		val item = series?.get(position)
		holder.bind(item)
	}
}

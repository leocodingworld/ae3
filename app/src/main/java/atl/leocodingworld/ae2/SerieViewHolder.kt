package atl.leocodingworld.ae2

import android.view.View
import androidx.recyclerview.widget.RecyclerView

import atl.leocodingworld.ae2.databinding.ItemSerieBinding
import com.squareup.picasso.Picasso

class SerieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
	private val binding = ItemSerieBinding.bind(view)

	fun bind(serie: Serie?) {
		Picasso.get().load(serie?.image).into(binding.ivSerieImage)
		binding.ivSerieTitle.text = "Título: ${serie?.title}"
		binding.ivSerieRating.text = "Reseñas : ${serie?.rating}"
	}
}

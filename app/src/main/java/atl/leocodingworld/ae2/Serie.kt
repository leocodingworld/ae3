package atl.leocodingworld.ae2

import com.google.gson.annotations.SerializedName

data class Serie (
	@SerializedName("id") val id : Int,
	@SerializedName("title") val title: String,
	@SerializedName("creator") val creator: String,
	@SerializedName("rating") val rating: Float,
	@SerializedName("dates") val dates: String,
	@SerializedName("image") val image: String,
	@SerializedName("channel") val channel: String
)

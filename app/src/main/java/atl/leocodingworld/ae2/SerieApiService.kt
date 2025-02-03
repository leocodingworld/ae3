package atl.leocodingworld.ae2

import retrofit2.Response
import retrofit2.http.GET

interface SerieApiService {
	@GET("series/")
	suspend fun getAllSeries(): Response<SerieResponse>
}
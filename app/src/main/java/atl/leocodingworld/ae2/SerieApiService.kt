package atl.leocodingworld.ae2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SerieApiService {
	@GET("series/")
	suspend fun getPopularSeries(): Response<SerieResponse>
}
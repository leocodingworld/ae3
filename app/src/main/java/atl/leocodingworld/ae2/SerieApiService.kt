package atl.leocodingworld.ae2

import atl.leocodingworld.ae2.model.SerieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SerieApiService {
	@GET
	suspend fun getAllSeries(@Url url : String): Response<SerieResponse>
}
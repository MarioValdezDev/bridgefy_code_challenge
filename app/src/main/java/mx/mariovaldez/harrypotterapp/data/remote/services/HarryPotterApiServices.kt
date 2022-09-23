package mx.mariovaldez.harrypotterapp.data.remote.services

import mx.mariovaldez.harrypotterapp.home.data.remote.models.response.CharactersResponse
import retrofit2.http.GET

internal interface HarryPotterApiServices {

    @GET("characters")
    suspend fun getCharacters(): List<CharactersResponse>
}

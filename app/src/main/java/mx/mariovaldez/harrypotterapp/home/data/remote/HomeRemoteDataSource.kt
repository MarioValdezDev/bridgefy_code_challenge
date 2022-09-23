package mx.mariovaldez.harrypotterapp.home.data.remote

import dagger.Reusable
import javax.inject.Inject
import mx.mariovaldez.harrypotterapp.data.di.HarryPotterRetrofit
import mx.mariovaldez.harrypotterapp.data.remote.services.HarryPotterApiServices
import mx.mariovaldez.harrypotterapp.home.data.remote.models.response.CharactersResponse

@Reusable
internal class HomeRemoteDataSource @Inject constructor(
    private val harryPotterApiServices: HarryPotterApiServices,
) {

    suspend fun getCharacters(): List<CharactersResponse> = harryPotterApiServices.getCharacters()
}
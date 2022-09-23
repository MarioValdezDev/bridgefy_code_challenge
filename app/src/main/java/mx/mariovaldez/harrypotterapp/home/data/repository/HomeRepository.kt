package mx.mariovaldez.harrypotterapp.home.data.repository

import dagger.Reusable
import javax.inject.Inject
import mx.mariovaldez.harrypotterapp.home.data.remote.HomeRemoteDataSource
import mx.mariovaldez.harrypotterapp.home.data.remote.models.response.CharactersResponse
import mx.mariovaldez.harrypotterapp.home.presentation.mappers.CharacterUIMapper
import mx.mariovaldez.harrypotterapp.home.presentation.models.CharacterUI

@Reusable
internal class HomeRepository @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource,
    private val characterUIMapper: CharacterUIMapper,
) {

    suspend fun getCharacters(): List<CharacterUI> =
        characterUIMapper.map(homeRemoteDataSource.getCharacters())

}
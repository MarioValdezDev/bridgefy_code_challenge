package mx.mariovaldez.harrypotterapp.home.domain.usecases

import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.withContext
import mx.mariovaldez.harrypotterapp.domain.dispatchers.DefaultDispatcherProvider
import mx.mariovaldez.harrypotterapp.home.data.repository.HomeRepository
import mx.mariovaldez.harrypotterapp.home.presentation.models.CharacterUI

@Reusable
internal class GetCharacters @Inject constructor(
    private val dispatcherProvider: DefaultDispatcherProvider,
    private val homeRepository: HomeRepository,
) {

    suspend operator fun invoke(): List<CharacterUI> =
        withContext(dispatcherProvider.default) {
            homeRepository.getCharacters()
        }
}
package mx.mariovaldez.harrypotterapp.home.presentation.mappers

import dagger.Reusable
import javax.inject.Inject
import mx.mariovaldez.harrypotterapp.domain.mapper.Mapper
import mx.mariovaldez.harrypotterapp.home.data.remote.models.response.CharactersResponse
import mx.mariovaldez.harrypotterapp.home.presentation.models.CharacterUI

@Reusable
internal class CharacterUIMapper @Inject constructor() : Mapper<CharactersResponse, CharacterUI> {

    override fun map(value: CharactersResponse): CharacterUI = with(value) {
        CharacterUI(
            name,
            species,
            gender,
            house,
            dateOfBirth,
            wizard,
            eyeColour,
            hairColour,
            wand,
            patronus,
            isHogwartsStudent,
            alive,
            image
        )
    }
}
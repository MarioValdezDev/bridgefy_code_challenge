package mx.mariovaldez.harrypotterapp.home.presentation.models

import mx.mariovaldez.harrypotterapp.home.data.remote.models.response.WandInfo

internal data class CharacterUI(
    val name: String,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val wizard: String,
    val eyeColour: String,
    val hairColour: String,
    val wand: WandInfo,
    val patronus: String,
    val isHogwartsStudent: Boolean,
    val alive: Boolean,
    val image: String,
)

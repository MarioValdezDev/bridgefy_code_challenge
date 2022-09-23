package mx.mariovaldez.harrypotterapp.home.data.remote.models.response

import com.google.gson.annotations.SerializedName

internal data class CharactersResponse(

    @SerializedName("name")
    val name: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("house")
    val house: String,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String,

    @SerializedName("wizard")
    val wizard: String,

    @SerializedName("eyeColour")
    val eyeColour: String,

    @SerializedName("hairColour")
    val hairColour: String,

    @SerializedName("wand")
    val wand: WandInfo,

    @SerializedName("patronus")
    val patronus: String,

    @SerializedName("hogwartsStudent")
    val isHogwartsStudent: Boolean,

    @SerializedName("alive")
    val alive: Boolean,

    @SerializedName("image")
    val image: String,
)
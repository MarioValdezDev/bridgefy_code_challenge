package mx.mariovaldez.harrypotterapp.home.data.remote.models.response

import com.google.gson.annotations.SerializedName

internal data class WandInfo(

    @SerializedName("wood")
    val wood: String,

    @SerializedName("core")
    val core: String,

    @SerializedName("length")
    val length: Int,
)

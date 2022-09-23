package mx.mariovaldez.harrypotterapp.data.remote.models

internal sealed class ClientException(
    override val cause: Throwable? = null,
) : RuntimeException() {

    data class ApiError(
        override val message: String,
        val code: Int,
    ) : ClientException()

    data class UnknownError(override val cause: Throwable) : ClientException()

    object NetworkError : ClientException()
}

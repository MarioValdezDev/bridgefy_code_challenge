package mx.mariovaldez.harrypotterapp.domain.remote

internal interface ServiceFactory {

    fun <T> createApiService(serviceClass: Class<T>): T
}

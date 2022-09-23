package mx.mariovaldez.harrypotterapp.data.remote.api

import javax.inject.Inject
import mx.mariovaldez.harrypotterapp.data.di.HarryPotterRetrofit
import mx.mariovaldez.harrypotterapp.domain.remote.ServiceFactory
import retrofit2.Retrofit

internal class HarryPotterApiServiceFactory @Inject constructor(
    @HarryPotterRetrofit private val retrofit: Retrofit,
) : ServiceFactory {
    override fun <T> createApiService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}
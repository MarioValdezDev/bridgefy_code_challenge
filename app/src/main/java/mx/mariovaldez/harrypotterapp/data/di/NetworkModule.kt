package mx.mariovaldez.harrypotterapp.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import mx.mariovaldez.harrypotterapp.BuildConfig
import mx.mariovaldez.harrypotterapp.data.remote.api.HarryPotterApiServiceFactory
import mx.mariovaldez.harrypotterapp.data.remote.models.HeadersInterceptor
import mx.mariovaldez.harrypotterapp.data.remote.models.ResponseCallAdapterFactory
import mx.mariovaldez.harrypotterapp.data.remote.services.HarryPotterApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    private const val READ_TIMEOUT: Long = 120
    private const val CONNECT_TIMEOUT: Long = 120

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .disableHtmlEscaping()
        .create()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        headersInterceptor: HeadersInterceptor,
    ): OkHttpClient =
        OkHttpClient().newBuilder().apply {
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                addInterceptor(
                    HttpLoggingInterceptor { message ->
                        Timber.i(message)
                    }.apply { level = HttpLoggingInterceptor.Level.BODY }
                )
            }
            addInterceptor(headersInterceptor)
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        responseCallAdapterFactory: ResponseCallAdapterFactory,
        gson: Gson,
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(responseCallAdapterFactory)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideApiServices(
        harryPotterApiServiceFactory: HarryPotterApiServiceFactory,
    ): HarryPotterApiServices = harryPotterApiServiceFactory.createApiService(
        HarryPotterApiServices::class.java,
    )
}
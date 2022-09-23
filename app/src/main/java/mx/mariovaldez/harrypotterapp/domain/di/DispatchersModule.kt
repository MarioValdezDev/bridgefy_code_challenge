package mx.mariovaldez.harrypotterapp.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.mariovaldez.harrypotterapp.domain.dispatchers.DefaultDispatcherProvider
import mx.mariovaldez.harrypotterapp.domain.dispatchers.DispatcherProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DispatchersModule {

    @Singleton
    @Binds
    abstract fun bindDispatcherProvider(
        defaultDispatcherProvider: DefaultDispatcherProvider,
    ): DispatcherProvider
}

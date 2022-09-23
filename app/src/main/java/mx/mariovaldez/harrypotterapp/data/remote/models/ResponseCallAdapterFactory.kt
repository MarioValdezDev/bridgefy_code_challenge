package mx.mariovaldez.harrypotterapp.data.remote.models

import mx.mariovaldez.harrypotterapp.data.remote.mappers.ClientExceptionMapper
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject

internal class ResponseCallAdapterFactory @Inject constructor(
    private val clientExceptionMapper: ClientExceptionMapper,
) : CallAdapter.Factory() {

    @Suppress("UNCHECKED_CAST")
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        if (
            getRawType(returnType) != Call::class.java || returnType !is ParameterizedType ||
            returnType.actualTypeArguments.size != 1
        ) {
            return null
        }

        val delegate = retrofit.nextCallAdapter(this, returnType, annotations)
        return ResponseCallAdapter(
            delegate as CallAdapter<Any, Call<*>>,
            clientExceptionMapper,
        )
    }
}

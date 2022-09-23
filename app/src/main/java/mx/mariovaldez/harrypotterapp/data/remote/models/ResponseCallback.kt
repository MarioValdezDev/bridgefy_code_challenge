package mx.mariovaldez.harrypotterapp.data.remote.models

import mx.mariovaldez.harrypotterapp.data.remote.mappers.ClientExceptionMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

internal class ResponseCallback constructor(
    private val callback: Callback<Any>,
    private val clientExceptionMapper: ClientExceptionMapper,
) : Callback<Any> {

    override fun onResponse(call: Call<Any>, response: Response<Any>) {
        if (response.isSuccessful) {
            callback.onResponse(call, response)
        } else {
            callback.onFailure(call, clientExceptionMapper.map(HttpException(response)))
        }
    }

    override fun onFailure(call: Call<Any>, throwable: Throwable) {
        callback.onFailure(call, clientExceptionMapper.map(throwable))
    }
}

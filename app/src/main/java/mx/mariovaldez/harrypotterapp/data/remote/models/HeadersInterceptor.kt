package mx.mariovaldez.harrypotterapp.data.remote.models

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

internal class HeadersInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = addHeaders(chain.request())
        return chain.proceed(request)
    }

    private fun addHeaders(request: Request): Request = request.newBuilder()
        .addHeader("Accept", "application/json")
        .addHeader("Content-Type", "application/json; charset=utf-8")
        .build()
}

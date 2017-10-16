package test.dev.je.searchimageapp.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by je944 on 2017-10-12.
 */
object Api{
    private val SERVER_CONNTECT_TIME: Long = 10000
    private val API_SERVER_URL = "https://apis.daum.net/"

    val service: ContentService by lazy {
        initRequestService(httpClient(), API_SERVER_URL)
    }

    private fun httpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .readTimeout(SERVER_CONNTECT_TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(SERVER_CONNTECT_TIME, TimeUnit.MILLISECONDS)
                .connectTimeout(SERVER_CONNTECT_TIME, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor).build()
    }

    private fun initRequestService(httpClient: OkHttpClient, apI_SERVER_URL: String): ContentService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(apI_SERVER_URL)
                .client(httpClient)
                .build()
        return retrofit.create(ContentService::class.java)
    }
}
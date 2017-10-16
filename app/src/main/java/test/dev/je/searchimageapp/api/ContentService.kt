package test.dev.je.searchimageapp.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import test.dev.je.searchimageapp.data.model.ChannelContainer

/**
 * Created by je944 on 2017-10-12.
 */
interface ContentService{
    @GET("search/image?apikey=654c061eb76d4fe6767f6942383acfd7&output=json")
    fun searchImages(@Query("q") searchKey: String) : Flowable<ChannelContainer>
}
package test.dev.je.searchimageapp.data

import io.reactivex.Flowable
import test.dev.je.searchimageapp.api.Api
import test.dev.je.searchimageapp.data.model.Item

/**
 * Created by je944 on 2017-10-12.
 */
object ApiRemoteSource : ApiSource {
    override fun searchImages(str: String): Flowable<List<Item>> = Api.service.searchImages(str)
            .flatMap {
                if (it.channel.item.isNotEmpty()) {
                    Flowable.just(it.channel.item)
                } else {
                    Flowable.just(ArrayList())
                }
            }
}
package test.dev.je.searchimageapp.data

import io.reactivex.Flowable
import test.dev.je.searchimageapp.data.model.Item

/**
 * Created by je944 on 2017-10-12.
 */
interface ApiSource {
    fun searchImages(str: String) : Flowable<List<Item>>
}
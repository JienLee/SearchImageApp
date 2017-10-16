package test.dev.je.searchimageapp.ui.searchimage.viewmodel

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import test.dev.je.searchimageapp.data.ApiRepository
import test.dev.je.searchimageapp.data.model.Item

/**
 * Created by je944 on 2017-10-12.
 */
class SearchImageViewModel(val repository: ApiRepository) {
    lateinit var addItem: (List<Item>) -> Unit

    fun searchImages(str: String) {
        repository.searchImages(str)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    addItem(it)
                }, {})
    }
}
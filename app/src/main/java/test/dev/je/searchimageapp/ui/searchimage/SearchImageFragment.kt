package test.dev.je.searchimageapp.ui.searchimage

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_searchimage.*
import test.dev.je.searchimageapp.R
import test.dev.je.searchimageapp.data.ApiRepository
import test.dev.je.searchimageapp.ui.base.BaseActivity
import test.dev.je.searchimageapp.ui.base.BaseFragment
import test.dev.je.searchimageapp.ui.searchimage.viewmodel.SearchImageViewModel
import test.dev.je.searchimageapp.ui.widget.AdapterConstrants
import test.dev.je.searchimageapp.ui.widget.ListAdapter

/**
 * Created by je944 on 2017-10-12.
 */
class SearchImageFragment : BaseFragment() {
    private val STR_INIT_KEYWORD = "카카오프렌즈"
    private lateinit var ACTIVITY: BaseActivity
    private val VIEWMODEL: SearchImageViewModel by lazy {
        SearchImageViewModel(ApiRepository)
    }

    companion object {
        val INSTANCE: SearchImageFragment by lazy { SearchImageFragment() }
        val TAG = "SearchImageFragment"
    }

    private val EDIT_SEARCH_WORD by lazy {
        // android 8.0 : findViewById() 서명 변경
        // https://developer.android.com/about/versions/oreo/android-8.0.html#fvbi-signature
        activity.findViewById<EditText>(R.id.editSearchKeyword)
    }

    private val BTN_SEARCH by lazy {
        activity.findViewById<Button>(R.id.btnSearch)
    }

    private val TEST_ADAPTER by lazy {
        ListAdapter(ACTIVITY.applicationContext).apply {
            DELEGATE_ADAPTERS.put(AdapterConstrants.ITEM, SearchImageAdapter(ACTIVITY, { item ->
                Toast.makeText(ACTIVITY, "click the item ${item.title}" , Toast.LENGTH_LONG).show()
            }))
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_searchimage
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ACTIVITY = context as BaseActivity
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EDIT_SEARCH_WORD.clearFocus()

        VIEWMODEL.addItem = {
            TEST_ADAPTER.addItems(it)
        }

        recyclerImages.apply {
            setHasFixedSize(true)
            val staggerLayout = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            layoutManager = staggerLayout
            adapter = TEST_ADAPTER
        }

        BTN_SEARCH.setOnClickListener {
            searchImage(EDIT_SEARCH_WORD.text.toString())
        }

        searchImage(STR_INIT_KEYWORD)
    }

    fun searchImage(str: String){
        VIEWMODEL.searchImages(str)
    }
}
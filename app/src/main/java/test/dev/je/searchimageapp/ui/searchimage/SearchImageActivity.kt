package test.dev.je.searchimageapp.ui.searchimage

import android.os.Bundle
import android.support.design.widget.Snackbar

import kotlinx.android.synthetic.main.activity_main.*
import test.dev.je.searchimageapp.R
import test.dev.je.searchimageapp.extention.replaceToFragment
import test.dev.je.searchimageapp.ui.base.BaseActivity

class SearchImageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        replaceToFragment(R.id.layFrameRoot, SearchImageFragment.INSTANCE, SearchImageFragment.TAG)
    }
}

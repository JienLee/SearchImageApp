package test.dev.je.searchimageapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import test.dev.je.searchimageapp.R

/**
 * Created by je944 on 2017-10-12.
 */
abstract class BaseActivity : AppCompatActivity() {
    lateinit var ACTIVITY: AppCompatActivity

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ACTIVITY = this
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        toolbar.let {
            toolbar.title = getString(R.string.app_name)
        }
    }
}
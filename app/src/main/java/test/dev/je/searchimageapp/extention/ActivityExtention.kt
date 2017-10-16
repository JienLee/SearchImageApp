package test.dev.je.searchimageapp.extention

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by je944 on 2017-10-12.
 */
fun AppCompatActivity.replaceToFragment(fragId: Int, fragment: Fragment, tag: String){
    val transaction = this.supportFragmentManager.beginTransaction()
    transaction.replace(fragId, fragment, tag)
    transaction.commitAllowingStateLoss()
}
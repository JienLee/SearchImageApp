package test.dev.je.searchimageapp.extention

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by je944 on 2017-10-12.
 */
fun ImageView.loadImage(activity: Activity, url : String){
    Glide.with(activity).load(url).apply(RequestOptions().optionalCenterInside()).into(this)
}
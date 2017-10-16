package test.dev.je.searchimageapp.ui.searchimage

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image.view.*
import test.dev.je.searchimageapp.R
import test.dev.je.searchimageapp.data.model.Item
import test.dev.je.searchimageapp.extention.loadImage
import test.dev.je.searchimageapp.ui.base.BaseActivity
import test.dev.je.searchimageapp.ui.widget.ViewDelegateAdapter
import test.dev.je.searchimageapp.ui.widget.ViewType

/**
 * Created by je944 on 2017-10-12.
 */
class SearchImageAdapter(val activity: BaseActivity, val itemClick:(Item)->Unit) : ViewDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, context: Context): RecyclerView.ViewHolder {
        return ItemViewHolder(parent, context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ItemViewHolder
        holder.onBindView(item as Item)
    }

    inner class ItemViewHolder(parent: ViewGroup, context: Context) : RecyclerView.ViewHolder(LayoutInflater.from
    (context).inflate(R.layout.item_image, parent, false)) {

        fun onBindView(item: Item){
            itemView.run {
                setOnClickListener {
                    itemClick(item)
                }
                // println("item image link : "+item.image)
                imgContent.loadImage(activity, item.image)
                txtContentFrom.text = item.title.replace("&lt;b&gt;", "").replace("&lt;/b&gt;", "")
            }
        }
    }
}
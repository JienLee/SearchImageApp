package test.dev.je.searchimageapp.ui.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by je944 on 2017-10-12.
 */
interface ViewDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup, context: Context) : RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}
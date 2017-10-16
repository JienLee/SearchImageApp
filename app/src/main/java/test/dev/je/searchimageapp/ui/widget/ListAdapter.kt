package test.dev.je.searchimageapp.ui.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by je944 on 2017-10-12.
 */
class ListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private  var itemList = ArrayList<ViewType>()
    var DELEGATE_ADAPTERS = HashMap<Int, ViewDelegateAdapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return (DELEGATE_ADAPTERS.get(viewType))?.onCreateViewHolder(parent, context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder?.let { (DELEGATE_ADAPTERS.get(getItemViewType(position)))?.onBindViewHolder(it, itemList[position]) }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int = itemList[position].getViewType()

    fun addItems(item: List<ViewType>){
        clearDataList()
        this.itemList.addAll(item)
        notifyDataSetChanged()
    }

    fun clearDataList(){
        itemList.clear()
    }
}
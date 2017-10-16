package test.dev.je.searchimageapp.data.model

import android.os.Parcel
import android.os.Parcelable
import test.dev.je.searchimageapp.ui.widget.AdapterConstrants
import test.dev.je.searchimageapp.ui.widget.ViewType

/**
 * Created by je944 on 2017-10-12.
 */
data class Item(val image: String,
                val thumbnail: String,
                val cpname: String,
                val width: Int,
                val link: String,
                val title: String,
                val cp: Int,
                val pubDate: String,
                val height: Int) : ViewType, Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun getViewType(): Int = AdapterConstrants.ITEM

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(image)
        dest?.writeString(thumbnail)
        dest?.writeString(cpname)
        dest?.writeInt(width)
        dest?.writeString(link)
        dest?.writeString(title)
        dest?.writeInt(cp)
        dest?.writeString(pubDate)
        dest?.writeInt(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

}
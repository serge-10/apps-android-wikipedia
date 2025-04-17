package org.wikipedia.homeworks.homework20

import android.os.Parcel
import android.os.Parcelable

class NameHierarchy(val name: String, val parent: NameHierarchy? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(NameHierarchy::class.java.classLoader)
    ) {
    }

    fun withParent(currentElementName: String) = NameHierarchy(currentElementName, this)
    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(parent, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NameHierarchy> {
        override fun createFromParcel(parcel: Parcel): NameHierarchy {
            return NameHierarchy(parcel)
        }

        override fun newArray(size: Int): Array<NameHierarchy?> {
            return arrayOfNulls(size)
        }
    }
}
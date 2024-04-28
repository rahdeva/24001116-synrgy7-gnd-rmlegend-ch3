import android.os.Parcel
import android.os.Parcelable

data class RMLegend(
    val letter: String,
    val legends: Array<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArray() ?: emptyArray()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(letter)
        parcel.writeStringArray(legends)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RMLegend> {
        override fun createFromParcel(parcel: Parcel): RMLegend {
            return RMLegend(parcel)
        }

        override fun newArray(size: Int): Array<RMLegend?> {
            return arrayOfNulls(size)
        }
    }
}

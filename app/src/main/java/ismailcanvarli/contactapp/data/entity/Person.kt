package ismailcanvarli.contactapp.data.entity

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("kisi_id") var personId: Int,
    @SerializedName("kisi_ad") var personName: String,
    @SerializedName("kisi_tel") var personPhoneNumber: String
)
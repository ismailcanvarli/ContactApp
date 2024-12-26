package ismailcanvarli.contactapp.data.entity

import com.google.gson.annotations.SerializedName

data class PersonResponse(
    @SerializedName("kisiler") var persons: List<Person>,
    @SerializedName("success") var success: Int
)
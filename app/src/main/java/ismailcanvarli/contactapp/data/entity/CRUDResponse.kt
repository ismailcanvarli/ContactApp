//Created by canVarli on 12/26/2024

package ismailcanvarli.contactapp.data.entity

import com.google.gson.annotations.SerializedName

data class CRUDResponse(
    @SerializedName("success") val success: Int,
    @SerializedName("message") val message: String
)
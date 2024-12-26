//Created by canVarli on 12/26/2024

package ismailcanvarli.contactapp.retrofit

import ismailcanvarli.contactapp.data.entity.CRUDResponse
import ismailcanvarli.contactapp.data.entity.PersonResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

// Dao: Database Access Object - Veritabanı Erişim Nesnesi
interface PersonDao {
    // http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/ BASE_URL
    // kisiler/tum_kisiler.php -> api URL

    @GET("kisiler/tum_kisiler.php")
    suspend fun allPersons(): PersonResponse

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun savePerson(
        @Field("kisi_ad") personName: String,
        @Field("kisi_tel") personPhone: String
    ): CRUDResponse

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun updatePerson(
        @Field("kisi_id") personId: Int,
        @Field("kisi_ad") personName: String,
        @Field("kisi_tel") personPhone: String
    ): CRUDResponse

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun deletePerson(
        @Field("kisi_id") personId: Int
    ): CRUDResponse

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun searchPerson(
        @Field("kisi_ad") searchWord: String
    ): PersonResponse
}
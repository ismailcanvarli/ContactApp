//Created by canVarli on 12/26/2024

package ismailcanvarli.contactapp.retrofit

class ApiUtils {
    companion object {
        const val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getPersonDao(): PersonDao {
            return RetrofitClient.getRetrofitClient(BASE_URL).create(PersonDao::class.java)
        }
    }
}
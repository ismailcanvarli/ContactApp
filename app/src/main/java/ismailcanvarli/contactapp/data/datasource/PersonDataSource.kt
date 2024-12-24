//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.data.datasource

import android.util.Log
import ismailcanvarli.contactapp.data.entity.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource {
    suspend fun save(personName: String, personPhone: String) {
        Log.e("Person Save", "$personName - $personPhone")
    }

    suspend fun updatePerson(personId: Int, personName: String, personPhone: String) {
        Log.e("Person Update", "$personId - $personName - $personPhone")
    }

    suspend fun delete(personId: Int) {
        Log.e("Person Delete", personId.toString())
    }

    suspend fun uploadPerson(): List<Person> = withContext(Dispatchers.IO) {
        val personList = ArrayList<Person>()
        val p1 = Person(1, "Ahmet", "1111")
        val p2 = Person(2, "Zeynep", "2222")
        val p3 = Person(3, "Beyza", "3333")
        personList.add(p1)
        personList.add(p2)
        personList.add(p3)

        return@withContext personList
    }

    suspend fun searchPerson(searchWord: String): List<Person> = withContext(Dispatchers.IO) {
        val personList = ArrayList<Person>()
        val p1 = Person(1, "Ahmet", "1111")

        personList.add(p1)

        return@withContext personList
    }
}
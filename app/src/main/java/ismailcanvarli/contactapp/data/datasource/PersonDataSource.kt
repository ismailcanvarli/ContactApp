//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.data.datasource

import ismailcanvarli.contactapp.data.entity.Person
import ismailcanvarli.contactapp.retrofit.PersonDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource(var personDao: PersonDao) {
    suspend fun save(personName: String, personPhone: String) {
        personDao.savePerson(personName, personPhone)
    }

    suspend fun updatePerson(personId: Int, personName: String, personPhone: String) {
        personDao.updatePerson(personId, personName, personPhone)
    }

    suspend fun delete(personId: Int) {
        personDao.deletePerson(personId)
    }

    suspend fun uploadPerson(): List<Person> = withContext(Dispatchers.IO) {
        val response = personDao.allPersons()
        // Gelen liste null olabilir; null kontrolü ekleyin
        return@withContext response.persons ?: emptyList()
    }

    suspend fun searchPerson(searchWord: String): List<Person> = withContext(Dispatchers.IO) {
        val response = personDao.searchPerson(searchWord)
        // Gelen liste null olabilir; null kontrolü ekleyin
        return@withContext response.persons ?: emptyList()
    }
}
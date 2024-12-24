//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.data.repo

import ismailcanvarli.contactapp.data.datasource.PersonDataSource
import ismailcanvarli.contactapp.data.entity.Person

class PersonRepository {
    var personDataSource = PersonDataSource()

    suspend fun uploadPerson(): List<Person> = personDataSource.uploadPerson()

    suspend fun save(personName: String, personPhone: String) =
        personDataSource.save(personName, personPhone)

    suspend fun updatePerson(personId: Int, personName: String, personPhone: String) =
        personDataSource.updatePerson(personId, personName, personPhone)

    suspend fun delete(personId: Int) = personDataSource.delete(personId)

    suspend fun searchPerson(searchWord: String): List<Person> =
        personDataSource.searchPerson(searchWord)
}
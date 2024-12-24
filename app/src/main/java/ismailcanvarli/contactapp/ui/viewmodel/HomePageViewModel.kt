//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ismailcanvarli.contactapp.data.entity.Person
import ismailcanvarli.contactapp.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {
    var personRepository = PersonRepository()

    // Arayüze veri göndermek için kullanılır.
    var personList = MutableLiveData<List<Person>>()

    // Bu viewmodel oluşturulduğunda uploadPerson fonksiyonu çalıştırılır.
    init {
        uploadPerson()
    }

    fun delete(personId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            personRepository.delete(personId)
        }
        uploadPerson()
    }

    fun uploadPerson() {
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = personRepository.uploadPerson()
        }
    }

    fun searchPerson(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = personRepository.searchPerson(searchWord)
        }
    }
}
//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import ismailcanvarli.contactapp.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonRegisterPageViewModel : ViewModel() {
    var personRepository = PersonRepository()

    // Kullanıcıdan alınan verileri kaydetmek için kullanılır.
    // Suspended fonksiyonlar ile çalıştığı için CoroutineScope kullanılarak çalıştırılır.
    fun save(personName: String, personPhone: String) {
        CoroutineScope(Dispatchers.Main).launch {
            personRepository.save(personName, personPhone)
        }
    }
}
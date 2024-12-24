//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import ismailcanvarli.contactapp.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDetailViewModel : ViewModel() {
    var personRepository = PersonRepository()

    fun updatePerson(personId: Int, personName: String, personPhone: String) {
        CoroutineScope(Dispatchers.Main).launch {
            personRepository.updatePerson(personId, personName, personPhone)
        }
    }
}
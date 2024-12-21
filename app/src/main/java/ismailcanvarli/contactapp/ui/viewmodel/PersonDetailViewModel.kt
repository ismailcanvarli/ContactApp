//Created by canVarli on 12/21/2024

package ismailcanvarli.contactapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import ismailcanvarli.contactapp.data.repo.PersonRepository

class PersonDetailViewModel : ViewModel() {
    var personRepository = PersonRepository()
}
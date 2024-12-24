//Created by canVarli on 12/18/2024

package ismailcanvarli.contactapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ismailcanvarli.contactapp.data.entity.Person
import ismailcanvarli.contactapp.ui.viewmodel.PersonDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailPage(receivedPerson: Person, personDetailViewModel: PersonDetailViewModel) {
    val personName = remember { mutableStateOf("") }
    val personPhoneNumber = remember { mutableStateOf("") }

    // Başlangıçta kişi bilgileri alınıyor
    LaunchedEffect(key1 = true) {
        personName.value = receivedPerson.personName
        personPhoneNumber.value = receivedPerson.personPhoneNumber
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Person Detail") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = personName.value,
                onValueChange = { personName.value = it },
                label = { Text(text = "Person Name") })
            TextField(value = personPhoneNumber.value,
                onValueChange = { personPhoneNumber.value = it },
                label = { Text(text = "Person Phone") })
            Button(onClick = {
                personDetailViewModel.updatePerson(
                    receivedPerson.personId,
                    personName.value,
                    personPhoneNumber.value
                )
            }) {
                Text(text = "UPDATE")
            }
        }
    }
}
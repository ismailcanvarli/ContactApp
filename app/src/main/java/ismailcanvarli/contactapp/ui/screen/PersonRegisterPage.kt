//Created by canVarli on 12/18/2024

package ismailcanvarli.contactapp.ui.screen

import android.util.Log
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ismailcanvarli.contactapp.ui.viewmodel.PersonRegisterPageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonRegisterPage(personRegisterPageViewModel: PersonRegisterPageViewModel) {
    val personName = remember { mutableStateOf("") }
    val personPhoneNumber = remember { mutableStateOf("") }

    // Kişi bilgileri kaydedildiğinde log ekranına yazdırılacak
    fun save(personName: String, personPhone: String) {
        Log.e("Person Save", "$personName - $personPhone")
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Person Register") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Kişi adı ve telefon numarası girilecek
            TextField(value = personName.value,
                onValueChange = { personName.value = it },
                label = { Text(text = "Person Name") })

            TextField(value = personPhoneNumber.value,
                onValueChange = { personPhoneNumber.value = it },
                label = { Text(text = "Person Phone") })

            // Butona tıklandığında kişi bilgileri kaydedilecek
            Button(onClick = {
                save(personName.value, personPhoneNumber.value)
            }) {
                Text(text = "SAVE")
            }
        }
    }
}
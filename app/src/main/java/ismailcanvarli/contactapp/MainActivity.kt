package ismailcanvarli.contactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import ismailcanvarli.contactapp.navigation.NavGraph
import ismailcanvarli.contactapp.ui.theme.ContactAppTheme
import ismailcanvarli.contactapp.ui.viewmodel.HomePageViewModel
import ismailcanvarli.contactapp.ui.viewmodel.PersonDetailViewModel
import ismailcanvarli.contactapp.ui.viewmodel.PersonRegisterPageViewModel

class MainActivity : ComponentActivity() {
    val homePageViewModel: HomePageViewModel by viewModels()
    val personDetailViewModel: PersonDetailViewModel by viewModels()
    val personRegisterViewModel: PersonRegisterPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactAppTheme {
                NavGraph(homePageViewModel, personDetailViewModel, personRegisterViewModel)
            }
        }
    }
}
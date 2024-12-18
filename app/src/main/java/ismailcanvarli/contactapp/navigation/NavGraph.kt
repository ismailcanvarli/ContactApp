//Created by canVarli on 12/18/2024

package ismailcanvarli.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import ismailcanvarli.contactapp.data.entity.Person
import ismailcanvarli.contactapp.ui.screen.Homepage
import ismailcanvarli.contactapp.ui.screen.PersonDetailPage
import ismailcanvarli.contactapp.ui.screen.PersonRegisterPage

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage") {
        composable("homepage") {
            Homepage(navController = navController)
        }
        composable("personRegisterPage") {
            PersonRegisterPage()
        }
        composable(
            "personDetailPage/{person}",
            arguments = listOf(navArgument("person") { type = NavType.StringType })
        ) {
            val json = it.arguments?.getString("person")
            val personObject = Gson().fromJson(json, Person::class.java)
            PersonDetailPage(receivedPerson = personObject)
        }
    }
}
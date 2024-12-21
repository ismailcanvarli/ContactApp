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
import ismailcanvarli.contactapp.ui.viewmodel.HomePageViewModel
import ismailcanvarli.contactapp.ui.viewmodel.PersonDetailViewModel
import ismailcanvarli.contactapp.ui.viewmodel.PersonRegisterPageViewModel

@Composable
fun NavGraph(
    homePageViewModel: HomePageViewModel,
    personDetailViewModel: PersonDetailViewModel,
    personRegisterViewModel: PersonRegisterPageViewModel
) {
    val navController = rememberNavController()
    // NavHost içerisinde tanımlanan rotaların belirlenmesi ve yönlendirme işlemlerinin yapılması
    NavHost(navController = navController, startDestination = "homepage") {
        composable("homepage") {
            Homepage(navController = navController, homePageViewModel = homePageViewModel)
        }
        composable("personRegisterPage") {
            PersonRegisterPage(personRegisterViewModel)
        }/*
        Bu rota, bir person parametresi alıyor ve bu parametre JSON formatında bir Person nesnesi içeriyor.
         JSON verisi Gson kütüphanesi kullanılarak Person nesnesine dönüştürülüyor
         ve PersonDetailPage composable fonksiyonuna receivedPerson parametresi olarak aktarılıyor.
         */
        composable(
            "personDetailPage/{person}",
            arguments = listOf(navArgument("person") { type = NavType.StringType })
        ) {
            val json = it.arguments?.getString("person")
            val personObject = Gson().fromJson(json, Person::class.java)
            PersonDetailPage(
                receivedPerson = personObject,
                personDetailViewModel = personDetailViewModel
            )
        }
    }
}
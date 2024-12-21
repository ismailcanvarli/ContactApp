//Created by canVarli on 12/18/2024

package ismailcanvarli.contactapp.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import ismailcanvarli.contactapp.R
import ismailcanvarli.contactapp.data.entity.Person
import ismailcanvarli.contactapp.ui.viewmodel.HomePageViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homepage(navController: NavController, homePageViewModel: HomePageViewModel) {
    val isSearching = remember { mutableStateOf(false) }
    val searchQuery = remember { mutableStateOf("") }
    val personList = remember { mutableStateListOf<Person>() }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        val p1 = Person(1, "Ahmet", "1111")
        val p2 = Person(2, "Zeynep", "2222")
        val p3 = Person(3, "Beyza", "3333")
        personList.add(p1)
        personList.add(p2)
        personList.add(p3)
    }

    fun search(query: String) {
        Log.e("Person Search", query)
    }

    fun delete(personId: Int) {
        Log.e("Person Delete", personId.toString())
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            if (isSearching.value) {
                TextField(value = searchQuery.value, onValueChange = {
                    searchQuery.value = it
                    search(it)
                }, label = { Text(text = "Search") }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Black,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                )
                )
            } else {
                Text(text = "Contacts")
            }
        }, actions = {
            if (isSearching.value) {
                IconButton(onClick = {
                    isSearching.value = false
                    searchQuery.value = ""
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.close_icon),
                        contentDescription = ""
                    )
                }
            } else {
                IconButton(onClick = { isSearching.value = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = ""
                    )
                }
            }
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate("personRegisterPage")
        }, content = {
            Icon(
                painter = painterResource(id = R.drawable.add_icon), contentDescription = ""
            )
        })
    }, snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(count = personList.count(), itemContent = {
                val person = personList[it]
                Card(modifier = Modifier.padding(all = 5.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val personJson = Gson().toJson(person)
                                navController.navigate("personDetailPage/$personJson")
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.padding(all = 10.dp)) {
                            Text(text = person.personName, fontSize = 20.sp)
                            Text(text = person.personPhoneNumber)
                        }

                        // Icona tıklandığında kişi silme işlemi yapılacak
                        // CoroutineScope kullanılarak SnackbarHostState ile birlikte Snackbar gösterilecek
                        IconButton(onClick = {
                            scope.launch {
                                val snackBar = snackbarHostState.showSnackbar(
                                    message = "Delete ${person.personName}?", actionLabel = "YES"
                                )
                                if (snackBar == SnackbarResult.ActionPerformed) {
                                    delete(person.personId)
                                }
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.close_icon),
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        }
                    }
                }
            })
        }
    }
}
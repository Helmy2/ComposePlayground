package com.example.playground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.scene.rememberSceneSetupNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.playground.login.banque_misr.BanqueMisr
import com.example.playground.login.banque_misr.BanqueMisrTheme
import kotlinx.serialization.Serializable


sealed class Destination() : NavKey {
    @Serializable
    object Home : Destination()

    @Serializable
    object BanqueMisr : Destination()
}

@Composable
fun App() {
    val backStack = rememberNavBackStack(Destination.Home)

    NavDisplay(
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Destination.Home> {
                Home(
                    onNavigateToBanqueMisr = {
                        backStack.add(
                            Destination.BanqueMisr
                        )
                    })
            }
            entry<Destination.BanqueMisr> {
                BanqueMisrTheme {
                    BanqueMisr()
                }
            }
        },
    )
}

@Composable
fun Home(
    onNavigateToBanqueMisr: () -> Unit = {},
) {
    Scaffold {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onNavigateToBanqueMisr) {
                Text(text = "Go to Banque Misr")
            }
        }
    }
}
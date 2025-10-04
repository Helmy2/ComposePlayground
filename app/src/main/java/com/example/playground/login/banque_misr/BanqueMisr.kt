package com.example.playground.login.banque_misr

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import com.example.playground.R


data class FooterItem(val labelResId: Int, val icon: Int)


val footerItems = listOf(
    FooterItem(R.string.our_products, R.drawable.our_products),
    FooterItem(R.string.exchange_rate, R.drawable.exchange_rate),
    FooterItem(R.string.security_tips, R.drawable.security_tips),
    FooterItem(R.string.nearest_branch_or_atm, R.drawable.nearest_branch_or_atm),
)

@Composable
fun BanqueMisr() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val locale = Locale.current.language

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bm_icon),
                    contentDescription = "Banque Misr Logo"
                )
                Text(
                    text = stringResource(R.string.en),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.clickable {
                        val newLocale = if (locale == "en") "ar" else "en"
                        changeAppLanguage(context, newLocale)
                    }
                )
            }
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(R.string.username),
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(R.string.password),
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (showPassword) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        }, contentDescription = if (showPassword) {
                            "Hide password"
                        } else {
                            "Show password"
                        }, modifier = Modifier.clickable { showPassword = !showPassword })
                },
                singleLine = true,
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
            )

            Text(
                text = stringResource(R.string.forget_username_password),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                ),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .clickable { /* Handle forget username/password action */ }
            )

            Button(
                onClick = { /* Handle login action */ },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = .3f),
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                enabled = userName.isNotBlank() && password.isNotBlank()
            ) {
                Text(text = stringResource(R.string.login))
            }

            Row {
                Text(
                    text = stringResource(R.string.need_help),
                )
                Text(
                    text = stringResource(R.string.contact_us),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.clickable { /* Handle contact us action */ }
                )
            }

            HorizontalDivider(Modifier.padding(vertical = 16.dp))

            Row {
                footerItems.forEach {
                    FooterIcon(it, Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun FooterIcon(item: FooterItem, modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .clickable { /* Handle icon click action */ },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = stringResource(item.labelResId),
        )
        Text(
            text = stringResource(item.labelResId),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}


@Composable
fun BanqueMisrTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFFA23040),
            onPrimary = Color.White,
            background = Color.White
        ),
    ) {
        content()
    }
}

fun changeAppLanguage(context: Context, localeName: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val localeManager = context.getSystemService(LocaleManager::class.java)
        localeManager.applicationLocales = LocaleList.forLanguageTags(localeName)
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(localeName))
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, locale = "ar")
@Composable
private fun BanqueMisrPrev() {
    BanqueMisrTheme {
        BanqueMisr()
    }
}
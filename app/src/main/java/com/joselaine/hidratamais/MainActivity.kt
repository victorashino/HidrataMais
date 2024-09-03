package com.joselaine.hidratamais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joselaine.hidratamais.ui.theme.BluePrimary
import com.joselaine.hidratamais.ui.theme.BlueSecondary
import com.joselaine.hidratamais.ui.theme.HidrataMaisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HidrataMaisTheme {
                HidrataMaisApp {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HidrataMaisApp(onClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.name_app_title),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = BluePrimary
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BlueSecondary)
                    .padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                NotificationContent(onClick)
            }
        }
    )
}

@Composable
fun NotificationContent(onClick: () -> Unit) {
    val intervalState = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_water_drop_24),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)

        )
        Text(
            text = stringResource(R.string.subtitle_home_screen),
            fontSize = 18.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = intervalState.value,
            onValueChange = { intervalState.value = it },
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            onClick = { onClick() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(R.string.button_text))
        }
    }
}

@Preview
@Composable
private fun HidrataMaisAppPreview() {
    HidrataMaisApp({})
}

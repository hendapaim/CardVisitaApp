package com.henda.cardvisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.henda.cardvisita.ui.theme.CardVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardVisitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LogotipoNome()
        DadosContato(Modifier.padding(bottom = 16.dp))
    }
}

@Composable
fun LogotipoNome(modifier: Modifier = Modifier) {
    val imageLogo = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxHeight(0.8f).padding(start = 16.dp, end = 16.dp)
    ) {
        Image(
            painter = imageLogo,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Henda Paim",
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Text(
            text = "Android Kotlin Developer Experiente",
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Composable
fun DadosContato(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
        DadosContatoRow("(+244) 90000000000", Icons.Rounded.Phone)
        DadosContatoRow("@hendapaim", Icons.Rounded.Share)
        DadosContatoRow("hendapaim@gmail.com", Icons.Rounded.Email)
    }
}

@Composable
fun DadosContatoRow(
    dado: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Divider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), color = Color.DarkGray)

    Row(
        modifier = modifier.padding(start = 44.dp, end = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colors.secondary
        )
        Text(text = dado, color = MaterialTheme.colors.onBackground)
    }
}

@Preview
@Composable
fun DadosContatoPreView() {
    CardVisitaTheme {
        DadosContato()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardVisitaTheme {
        MyApp()
    }
}
package com.tecsup.dnilsontec04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.font.FontFamily


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                GreetingCard()
            }
        }
    }
}

@Composable
fun GreetingCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenido!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_tecsup),
            contentDescription = "Course Image",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            //Checkbox
            CheckboxComponent()


        }
    }
}

@Composable
fun CheckboxComponent() {
    var checkedState1 by remember { mutableStateOf(false) }
    var checkedState2 by remember { mutableStateOf(true) }
    var checkedState3 by remember { mutableStateOf(false) }

    Column {
        Text("Curso:", style = MaterialTheme.typography.titleMedium)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState1,
                onCheckedChange = { checkedState1 = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Marketing para empresas", style = MaterialTheme.typography.bodyLarge)
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState2,
                onCheckedChange = { checkedState2 = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Desarrollo de Aplicaciones Moviles", style = MaterialTheme.typography.bodyLarge)
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState3,
                onCheckedChange = { checkedState3 = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Desarrollo de aplicaciones web", style = MaterialTheme.typography.bodyLarge)
        }
        Text("El curso es: ${listOfNotNull(
            if (checkedState1) "MarkEmpr" else null,
            if (checkedState2) "DesAplMov" else null,
            if (checkedState3) "DesAplWeb" else null
        ).joinToString(", ")}")
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewGreetingCard() {
    GreetingCard()
}


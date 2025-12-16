package com.example.unidad2das


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DniScreen()
        }
    }
}


@Preview
@Composable
fun DniScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = stringResource(R.string.app_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjeta principal
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Imagen + título
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.persona),
                        contentDescription = stringResource(R.string.photo_content_description),
                        modifier = Modifier
                            .size(90.dp)
                            .padding(end = 16.dp)
                    )

                    Column {
                        Text(
                            text = stringResource(R.string.country_name),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = stringResource(R.string.document_type),
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botón
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = stringResource(R.string.show_dni_button))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Datos del DNI
                DatoDni(stringResource(R.string.dni_label), stringResource(R.string.dni_value))
                DatoDni(stringResource(R.string.surnames_label), stringResource(R.string.surnames_value))
                DatoDni(stringResource(R.string.name_label), stringResource(R.string.name_value))
                DatoDni(stringResource(R.string.birthdate_label), stringResource(R.string.birthdate_value))
                DatoDni(stringResource(R.string.sex_label), stringResource(R.string.sex_value))
                DatoDni(stringResource(R.string.expiry_date_label), stringResource(R.string.expiry_date_value))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.info_banner_text),
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier
                .background(Color(0xFF5E92F3))
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DatoDni(titulo: String, valor: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = titulo,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = valor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

package com.piper.pcv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PiperBackground = Color(0xFF0D1117)
private val PiperSurface = Color(0xFF161B22)
private val PiperSurfaceLight = Color(0xFF21262D)
private val PiperBlue = Color(0xFF2196F3)
private val PiperBlueDark = Color(0xFF1976D2)
private val PiperWhite = Color(0xFFFFFFFF)
private val PiperGray = Color(0xFF8B949E)
private val PiperGreen = Color(0xFF3FB950)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PiperPCV()
            }
        }
    }
}

@Composable
fun PiperPCV() {

    var code by remember {
        mutableStateOf("")
    }

    var fileName by remember {
        mutableStateOf("Sin título.txt")
    }

    var isListening by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PiperBackground
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                )
        ) {

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Piper",
                        color = PiperWhite,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "PCV",
                        color = PiperBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = "Programando Con Voz",
                    color = PiperGray,
                    fontSize = 13.sp
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Tu voz, tu código. Piper te acompaña.",
                    color = PiperWhite,
                    fontSize = 14.sp
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PiperSurfaceLight,
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    )
                    .padding(
                        horizontal = 14.dp,
                        vertical = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = fileName,
                    color = PiperWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "TXT",
                    color = PiperBlue,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = PiperSurface,
                        shape = RoundedCornerShape(
                            bottomStart = 12.dp,
                            bottomEnd = 12.dp
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = PiperSurfaceLight,
                        shape = RoundedCornerShape(
                            bottomStart = 12.dp,
                            bottomEnd = 12.dp
                        )
                    )
            ) {

                Column(
                    modifier = Modifier
                        .width(42.dp)
                        .fillMaxHeight()
                        .background(PiperSurfaceLight)
                        .padding(top = 10.dp)
                        .verticalScroll(
                            rememberScrollState()
                        ),
                    horizontalAlignment = Alignment.End
                ) {

                    val lineCount = maxOf(
                        1,
                        code.count { it == '\n' } + 1
                    )

                    for (line in 1..lineCount) {

                        Text(
                            text = line.toString(),
                            color = PiperGray,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(
                                end = 8.dp,
                                bottom = 4.dp
                            )
                        )
                    }
                }

                TextField(
                    value = code,
                    onValueChange = {
                        code = it
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    textStyle = TextStyle(
                        color = PiperWhite,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 14.sp
                    ),
                    placeholder = {
                        Text(
                            text = "Empezá a escribir o presioná HABLAR...",
                            color = PiperGray,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = PiperBlue
                    )
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Button(
                    onClick = {
                        isListening = !isListening
                    },
                    modifier = Modifier
                        .width(190.dp)
                        .height(58.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isListening) {
                            PiperBlueDark
                        } else {
                            PiperBlue
                        }
                    )
                ) {

                    Text(
                        text = "🎙",
                        fontSize = 20.sp
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = if (isListening) {
                                "ESCUCHANDO"
                            } else {
                                "HABLAR"
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )

                        Text(
                            text = if (isListening) {
                                "Presioná para detener"
                            } else {
                                "Presioná para empezar"
                            },
                            fontSize = 9.sp
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                PiperActionButton(
                    modifier = Modifier.weight(1f),
                    text = "Nuevo"
                ) {
                    code = ""
                    fileName = "Sin título.txt"
                }

                PiperActionButton(
                    modifier = Modifier.weight(1f),
                    text = "Ajustes"
                ) {
                }

                PiperActionButton(
                    modifier = Modifier.weight(1f),
                    text = "Guardar"
                ) {
                }

                PiperActionButton(
                    modifier = Modifier.weight(1f),
                    text = "Compartir"
                ) {
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Línea 1  •  Columna 1",
                    color = PiperGray,
                    fontSize = 11.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                color = PiperGreen,
                                shape = CircleShape
                            )
                            .width(7.dp)
                            .height(7.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(5.dp)
                    )

                    Text(
                        text = "Modo texto",
                        color = PiperGray,
                        fontSize = 11.sp
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Más ideas, Más código, Más vos",
                modifier = Modifier.fillMaxWidth(),
                color = PiperGray,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun PiperActionButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier.height(46.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PiperSurfaceLight
        ),
        contentPadding = PaddingValues(
            horizontal = 4.dp
        )
    ) {

        Text(
            text = text,
            color = PiperWhite,
            fontSize = 11.sp
        )
    }
}
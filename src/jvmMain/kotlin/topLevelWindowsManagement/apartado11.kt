package topLevelWindowsManagement

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.material.Text
import androidx.compose.runtime.*

/*
    Ventanas transparentes (por ejemplo, permite hacer ventanas de
    forma personalizada)

    Para crear una ventana transparente basta con pasar dos parámetros
    a la función Ventana: transparent=true y undecorate=true(no es posible
    decorar una Ventana transparente). El escenario común es combinar una
    ventana transparente con una superficie de una forma personalizada. A
    continuación se muestra un ejemplo de una ventana con esquinas redondeadas.
 */
fun main() = application {
    var isOpen by remember { mutableStateOf(true) }
    if (isOpen) {
        Window(
            onCloseRequest = { isOpen = false },
            title = "Transparent Window Example",
            transparent = true,
            undecorated = true, //transparent window must be undecorated
        ) {
            Surface(
                modifier = Modifier.fillMaxSize().padding(5.dp).shadow(3.dp, RoundedCornerShape(20.dp)),
                color = Color(55, 55, 55),
                shape = RoundedCornerShape(20.dp) //window has round corners now
            ) {
                Text("Hello World!", color = Color.White)
            }
        }
    }
}
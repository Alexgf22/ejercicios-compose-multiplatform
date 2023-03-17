package contextMenu

import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication


/*
    Menú contextual para un área arbitraria:

    Existe la posibilidad de crear un menú contextual para un área de ventana de aplicación
    arbitraria. Esto se implementa mediante la API ContextMenuArea que es similar a
    ContextMenuDataProvider.

    Al hacer clic con el botón derecho en el cuadrado azul, se mostrará un menú contextual
    con dos elementos
 */
fun main() = singleWindowApplication(title = "Context menu") {
    ContextMenuArea(items = {
        listOf(
            ContextMenuItem("User-defined Action") {/*do something here*/},
            ContextMenuItem("Another user-defined action") {/*do something else*/}
        )
    }) {
        Box(modifier = Modifier.background(Color.Blue).height(100.dp).width(100.dp))
    }
}
package contextMenu

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.singleWindowApplication


/*
    Menú contextual predeterminado:

    Hay soporte de menú contextual listo para usar para TextField y texto seleccionable.

    Para habilitar el menú contextual estándar para un TextField, solo necesita colocarlo
    dentro de DesktopMaterialTheme:
 */
fun main() = singleWindowApplication(title = "Context menu") {
    val text = remember { mutableStateOf("Hello!") }
    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(text = "Input") }
    )
}
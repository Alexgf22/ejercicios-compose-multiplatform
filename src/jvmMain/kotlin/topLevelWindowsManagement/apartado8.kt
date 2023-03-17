package topLevelWindowsManagement

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberDialogState

/*
    Diálogos:

    Hay dos tipos de ventana: modal y regular. A continuación se muestran
    las funciones para crear cada uno:

    Ventana: tipo de ventana normal.
    Diálogo: tipo de ventana modal. Este tipo bloquea su ventana principal
    hasta que el usuario termina de trabajar con ella y cierra la ventana modal.
    Puede ver un ejemplo de ambos tipos de ventana a continuación.
 */
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
    ) {
        var isDialogOpen by remember { mutableStateOf(false) }

        Button(onClick = { isDialogOpen = true }) {
            Text(text = "Open dialog")
        }

        if (isDialogOpen) {
            Dialog(
                onCloseRequest = { isDialogOpen = false },
                state = rememberDialogState(position = WindowPosition(Alignment.Center))
            ) {
                // Dialog's content
            }
        }
    }
}
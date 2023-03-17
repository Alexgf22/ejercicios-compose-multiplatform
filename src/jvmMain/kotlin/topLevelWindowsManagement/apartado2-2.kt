package topLevelWindowsManagement

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/*
    Si la ventana requiere alguna lógica personalizada al cerrar
    (por ejemplo, para mostrar un cuadro de diálogo), puede anular la acción
    de cerrar usando onCloseRequest.

    En lugar del enfoque imperativo para cerrar la ventana ( window.close()),
    usamos un enfoque declarativo: cerrar la ventana en respuesta a un cambio de
    estado ( isOpen = false).
 */
fun main() = application {
    var isOpen by remember { mutableStateOf(true) }
    var isAskingToClose by remember { mutableStateOf(false) }

    if (isOpen) {
        Window(
            onCloseRequest = { isAskingToClose = true }
        ) {
            if (isAskingToClose) {
                Dialog(
                    onCloseRequest = { isAskingToClose = false },
                    title = "Close the document without saving?",
                ) {
                    Button(
                        onClick = { isOpen = false }
                    ) {
                        Text("Yes")
                    }
                }
            }
        }
    }
}
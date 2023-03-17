package contextMenu

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.ui.window.singleWindowApplication


/*
    El menú contextual estándar para TextField contiene los siguientes elementos
    según la selección de texto: Copiar, Cortar, Pegar, Seleccionar 'todo'.

    Habilitar el menú contextual estándar para un componente de texto es similar:
    solo necesita hacerlo seleccionable:

    El menú contextual para el texto contiene solo la acción Copiar:
 */
fun main() = singleWindowApplication(title = "Context menu") {
    SelectionContainer {
        Text("Hello World!")
    }
}
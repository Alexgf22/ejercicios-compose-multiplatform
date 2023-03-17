package keyboardSupport

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

/*
    Eventos relacionados con el enfoque:

    Funciona igual que Compose para Android; para obtener más información,
    consulte Referencia de la API

    El caso de uso más común es definir controladores de teclado para controles
    activos como TextField. Puede usar ambos 'onKeyEvent' y, 'onPreviewKeyEvent' pero el
    último suele ser preferible para definir accesos directos, ya que le garantiza que
    los eventos clave no serán consumidos por los componentes secundarios. Aquí hay un
    ejemplo


    Tenga en cuenta la anotación @OptIn(ExperimentalComposeUiApi::class).
    Algunas API relacionadas con claves siguen siendo una característica experimental
    de Compose, y es posible que se realicen cambios posteriores en la API. Por lo tanto,
    requiere el uso de una anotación especial para enfatizar la naturaleza experimental
    del código.
 */
@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication {
    MaterialTheme {
        var consumedText by remember { mutableStateOf(0) }
        var text by remember { mutableStateOf("") }
        Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
            Text("Consumed text: $consumedText")
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.onPreviewKeyEvent {
                    when {
                        (it.isCtrlPressed && it.key == Key.Minus && it.type == KeyEventType.KeyUp) -> {
                            consumedText -= text.length
                            text = ""
                            true
                        }
                        (it.isCtrlPressed && it.key == Key.Equals && it.type == KeyEventType.KeyUp) -> {
                            consumedText += text.length
                            text = ""
                            true
                        }
                        else -> false
                    }
                }
            )
        }
    }
}
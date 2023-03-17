package mouseEvents

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.input.pointer.isAltPressed
import androidx.compose.ui.input.pointer.isShiftPressed
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

/*
    Nuevos controladores onClick experimentales (solo para la plataforma Desktop-JVM)

    'Modifier.onClick' proporciona devoluciones de llamada independientes para clics,
    clics dobles, clics largos. Maneja los clics originados solo a partir de eventos de
    puntero y click el evento de accesibilidad no se maneja de forma automática.

    Cada 'onClick' se puede configurar para apuntar a eventos de puntero específicos
    (usando matcher: PointerMatcher y keyboardModifiers: PointerKeyboardModifiers.() -> Boolean).
    matcherse puede especificar para elegir qué botón del mouse debe activar un clic.
    keyboardModifiers permite filtrar eventos de puntero que han presionado modificadores de
    teclado especificados.

    'onClick' Se pueden encadenar múltiples modificadores para manejar diferentes clics con
    diferentes condiciones (modificadores de combinación y teclado).
    A diferencia de clickable, 'onClick' no tiene un 'Modifier.indication', 'Modifier.semantics' y
    no activa un evento de clic cuando 'Enter' se presiona. Estos modificadores deben agregarse
    por separado si es necesario.
    Los controladores más genéricos (con la menor cantidad de condiciones) 'onClick' deben
    declararse antes que otros para garantizar la correcta propagación de eventos.
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
fun main() = singleWindowApplication {
    Column {
        var topBoxText by remember { mutableStateOf("Click me\nusing LMB or LMB + Shift") }
        var topBoxCount by remember { mutableStateOf(0) }
        // No indication on interaction
        Box(modifier = Modifier.size(200.dp, 100.dp).background(Color.Blue)
            // the most generic click handler (without extra conditions) should be the first one
            .onClick {
                // it will receive all LMB clicks except when Shift is pressed
                println("Click with primary button")
                topBoxText = "LMB ${topBoxCount++}"
            }.onClick(
                keyboardModifiers = { isShiftPressed } // accept clicks only when Shift pressed
            ) {
                // it will receive all LMB clicks when Shift is pressed
                println("Click with primary button and shift pressed")
                topBoxCount++
                topBoxText = "LMB + Shift ${topBoxCount++}"
            }
        ) {
            AnimatedContent(
                targetState = topBoxText,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = it, textAlign = TextAlign.Center)
            }
        }

        var bottomBoxText by remember { mutableStateOf("Click me\nusing LMB or\nRMB + Alt") }
        var bottomBoxCount by remember { mutableStateOf(0) }
        val interactionSource = remember { MutableInteractionSource() }
        // With indication on interaction
        Box(modifier = Modifier.size(200.dp, 100.dp).background(Color.Yellow)
            .onClick(
                enabled = true,
                interactionSource = interactionSource,
                matcher = PointerMatcher.mouse(PointerButton.Secondary), // Right Mouse Button
                keyboardModifiers = { isAltPressed }, // accept clicks only when Alt pressed
                onLongClick = { // optional
                    bottomBoxText = "RMB Long Click + Alt ${bottomBoxCount++}"
                    println("Long Click with secondary button and Alt pressed")
                },
                onDoubleClick = { // optional
                    bottomBoxText = "RMB Double Click + Alt ${bottomBoxCount++}"
                    println("Double Click with secondary button and Alt pressed")
                },
                onClick = {
                    bottomBoxText = "RMB Click + Alt ${bottomBoxCount++}"
                    println("Click with secondary button and Alt pressed")
                }
            )
            .onClick(interactionSource = interactionSource) { // use default parameters
                bottomBoxText = "LMB Click ${bottomBoxCount++}"
                println("Click with primary button (mouse left button)")
            }
            .indication(interactionSource, LocalIndication.current)
        ) {
            AnimatedContent(
                targetState = bottomBoxText,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = it, textAlign = TextAlign.Center)
            }
        }
    }
}
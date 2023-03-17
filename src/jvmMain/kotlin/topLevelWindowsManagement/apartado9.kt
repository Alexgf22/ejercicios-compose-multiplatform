package topLevelWindowsManagement

import androidx.compose.ui.awt.ComposeWindow
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.SwingUtilities

/*
    interoperabilidad oscilante:

    Debido a que Compose for Desktop usa Swing bajo el capó, es posible
    crear una ventana usando Swing directamente:
 */
fun main() = SwingUtilities.invokeLater {
    ComposeWindow().apply {
        size = Dimension(300, 300)
        defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        setContent {
            // Content
        }
        isVisible = true
    }
}
package menuTrayNotifications

import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.application

/*
    Tenga en cuenta que es posible crear una aplicación de bandeja sin ventana:
 */
fun main() = application {
    Tray(
        icon = TrayIcon,
        menu = {
            Item(
                "Exit",
                onClick = ::exitApplication
            )
        }
    )
}


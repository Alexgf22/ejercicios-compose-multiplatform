/*
package navigation


import androidx.compose.desktop.DesktopTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent


*/
/*
    Inicialización de la aplicación y la raíz:
 *//*

fun main() = singleWindowApplication(
    title = "Navigation tutorial"
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        MaterialTheme {
            DesktopTheme {
                RootUi(root()) // Render the Root and its children
            }
        }
    }
}

@Composable
private fun root(): Root =
    // The rememberRootComponent function provides the root ComponentContext and remembers the instance or Root
    rememberRootComponent { componentContext ->
        Root(
            componentContext = componentContext,
            database = DatabaseImpl() // Supply dependencies
        )
    }
*/

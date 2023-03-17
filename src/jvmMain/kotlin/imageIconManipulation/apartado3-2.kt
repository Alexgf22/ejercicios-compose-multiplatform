package imageIconManipulation

import androidx.compose.material.Text
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.window.singleWindowApplication


// En caso de usar singleWindowApplication , se puede utilizar el siguiente enfoque:
fun main() {
    val icon = BitmapPainter(useResource("sample.png", ::loadImageBitmap))
    singleWindowApplication(icon = icon) {
        Text("Hello World!")
    }
}
package navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class Item(
    val id: Long,
    val text: String
)

interface Database {
    fun getAll(): List<Item>
    fun getById(id: Long): Item
}

@Composable
fun ItemListScreen(items: List<Item>, onItemClick: (id: Long) -> Unit) {
    LazyColumn {
        items(items = items) { item ->
            Text(
                text = item.text,
                modifier = Modifier.clickable { onItemClick(item.id) }
            )
        }
    }
}
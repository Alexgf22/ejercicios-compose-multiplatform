package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf


/*
    Un ejemplo muy básico:

    ItemList niño con IU
 */
class ItemList(
    database: Database, // Accept the Database as dependency
    val onItemSelected: (itemId: Long) -> Unit // Called on item click
) {
    // No concurrency involved just for simplicity. The state can be updated if needed.
    private val _state = mutableStateOf(database.getAll())
    val state: State<List<Item>> = _state
}

@Composable
fun ItemListUi(list: ItemList) {
    ItemListScreen(
        items = list.state.value,
        onItemClick = list.onItemSelected
    )
}
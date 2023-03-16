package navigation

/*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.arkivanov.composenavigatorexample.navigator.rememberRouter
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.pop
import com.arkivanov.decompose.push
import java.lang.module.Configuration


@Composable
fun ItemList(
    database: Database,
    onItemClick: (itemId: Long) -> Unit
) {
    // No concurrency involved just for simplicity. The state can be updated if needed.
    val items = remember { mutableStateOf(database.getAll()) }

    ItemListScreen(
        items = items.value,
        onItemClick = onItemClick
    )
}

@Composable
fun ItemDetails(
    itemId: Long,
    database: Database,
    onBackClick: () -> Unit
) {
    // No concurrency involved just for simplicity. The state can be updated if needed.
    val item = remember { mutableStateOf(database.getById(id = itemId)) }

    ItemDetailsScreen(
        item = item.value,
        onBackClick = onBackClick
    )
}

@Composable
fun Root(database: Database) {
    // Create and remember the Router
    val router =
        rememberRouter<Configuration>(
            initialConfiguration = { Configuration.List } // Start with the List screen
        )

    // Render children
    Children(routerState = router.state) { screen ->
        when (val configuration = screen.configuration) {
            is Configuration.List ->
                ItemList(
                    database = database, // Supply dependencies
                    onItemClick = { router.push(Configuration.Details(itemId = it)) } // Push Details on item click
                )

            is Configuration.Details ->
                ItemDetails(
                    itemId = configuration.itemId, // Safely pass arguments
                    database = database, // Supply dependencies
                    onBackClick = router::pop // Go back to List
                )
        }.let {} // Ensure exhaustiveness
    }
}*/

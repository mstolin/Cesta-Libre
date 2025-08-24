package to.marcel.libre.core.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class Item (val name: String)

class ShoppingListDataStore @Inject constructor (private val dataStore: DataStore<Item>) {
    val items = dataStore.data
    //val items: Flow<Item> = listOf<Item>(Item("Apple"), Item("Banana")).map { it }
}
package to.marcel.libre.core.datastore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShoppingListRepository @Inject constructor(private val localDataStore: ShoppingListDataStore) {

    fun getItems(): Flow<List<String>> {
        return localDataStore.items.map { listOf(it.name) }
    }

}
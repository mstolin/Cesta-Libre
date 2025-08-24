package to.marcel.libre.cesta

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import to.marcel.libre.core.datastore.ShoppingListRepository
import javax.inject.Inject

sealed interface MainActivityUiState {
    object Loading: MainActivityUiState
    data class Success(val items: List<String>): MainActivityUiState
}

@HiltViewModel()
class MainActivityViewModel @Inject constructor(shoppingListRepository: ShoppingListRepository):
    ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = shoppingListRepository.getItems().map { items ->
        MainActivityUiState.Success(items)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000)
    )

}
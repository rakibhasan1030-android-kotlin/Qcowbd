package rakib.hasan.qcowbd.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rakib.hasan.qcowbd.common.Resource
import rakib.hasan.qcowbd.domain.use_case.home_product.GetHomeProductUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeProductUseCase: GetHomeProductUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(HomeProductState())
    val state: State<HomeProductState> = _state

    init {
        getHomeProducts()
    }

    private fun getHomeProducts() {
        homeProductUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = HomeProductState(
                        products = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _state.value = HomeProductState(
                        error = "An unexpected error occurred."
                    )
                }

                is Resource.Loading -> {
                    _state.value = HomeProductState(
                        true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}
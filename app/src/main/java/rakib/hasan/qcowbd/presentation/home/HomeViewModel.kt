package rakib.hasan.qcowbd.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rakib.hasan.qcowbd.common.Resource
import rakib.hasan.qcowbd.domain.model.FeatureService
import rakib.hasan.qcowbd.domain.use_case.category.GetCategoryUseCase
import rakib.hasan.qcowbd.domain.use_case.feature_service.GetFeatureServiceUseCase
import rakib.hasan.qcowbd.domain.use_case.home_product.GetHomeProductUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeProductUseCase: GetHomeProductUseCase,
    private val categoryUseCase: GetCategoryUseCase,
    private val featureServiceUseCase: GetFeatureServiceUseCase
) : ViewModel() {

    private val _productState = mutableStateOf(HomeProductState())
    val productState: State<HomeProductState> = _productState

    private val _categoryState = mutableStateOf(CategoryState())
    val categoryState: State<CategoryState> = _categoryState

    private val _featureServiceState = mutableStateOf(FeatureServiceState())
    val featureServiceState: State<FeatureServiceState> = _featureServiceState

    init {
        getHomeProducts()
        getCategories()
        getFeatureServices()
    }

    private fun getHomeProducts() {
        homeProductUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _productState.value = HomeProductState(
                        products = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _productState.value = HomeProductState(
                        error = "An unexpected error occurred."
                    )
                }

                is Resource.Loading -> {
                    _productState.value = HomeProductState(
                        true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCategories(){
        categoryUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _categoryState.value = CategoryState(
                        categories = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _categoryState.value = CategoryState(
                        error = "An unexpected error occurred."
                    )
                }

                is Resource.Loading -> {
                    _categoryState.value = CategoryState(
                        true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getFeatureServices(){
        featureServiceUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _featureServiceState.value = FeatureServiceState(
                        categories = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _featureServiceState.value = FeatureServiceState(
                        error = "An unexpected error occurred."
                    )
                }

                is Resource.Loading -> {
                    _featureServiceState.value = FeatureServiceState(
                        true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


}


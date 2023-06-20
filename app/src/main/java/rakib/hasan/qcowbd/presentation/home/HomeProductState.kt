package rakib.hasan.qcowbd.presentation.home

import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto
import rakib.hasan.qcowbd.domain.model.HomeProduct
import java.lang.Error

data class HomeProductState(
    val isLoading: Boolean = false,
    val products: List<HomeProduct> = emptyList(),
    val error: String = ""
)
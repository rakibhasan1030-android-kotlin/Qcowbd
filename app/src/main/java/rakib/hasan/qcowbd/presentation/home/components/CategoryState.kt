package rakib.hasan.qcowbd.presentation.home.components

import rakib.hasan.qcowbd.domain.model.Category

data class CategoryState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val error: String = ""
)
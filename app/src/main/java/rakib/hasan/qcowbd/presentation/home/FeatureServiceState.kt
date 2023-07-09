package rakib.hasan.qcowbd.presentation.home

import rakib.hasan.qcowbd.domain.model.FeatureService

data class FeatureServiceState (
    val isLoading: Boolean = false,
    val categories: List<FeatureService> = emptyList(),
    val error: String = ""
)
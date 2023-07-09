package rakib.hasan.qcowbd.data.remote.dto.feature_service


import com.google.gson.annotations.SerializedName

data class FeatureServicesDto(
    val status: Boolean = false,
    val `data`: List<Data> = listOf()
)
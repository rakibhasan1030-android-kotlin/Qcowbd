package rakib.hasan.qcowbd.data.remote.dto.feature_service


import com.google.gson.annotations.SerializedName
import rakib.hasan.qcowbd.domain.model.FeatureService

data class Data(
    val title: String = "",
    val icon: String = ""
)

fun Data.toFeatureService(): FeatureService = FeatureService(
    title = this.title,
    icon = this.icon
)
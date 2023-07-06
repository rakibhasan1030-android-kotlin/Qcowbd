package rakib.hasan.qcowbd.data.remote.dto.category


import com.google.gson.annotations.SerializedName
import rakib.hasan.qcowbd.domain.model.Category

data class Data(
    val id: Int = 0,
    val slug: String = "",
    @SerializedName("name_en") val nameEn: String = "",
    @SerializedName("name_bn") val nameBn: Any? = null,
    val description: Any? = null,
    val image: String = ""
)

fun Data.toCategory(): Category = Category(
    title = this.nameEn,
    image = this.image
)
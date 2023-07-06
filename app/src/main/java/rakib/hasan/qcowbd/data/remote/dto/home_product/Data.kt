package rakib.hasan.qcowbd.data.remote.dto.home_product


import com.google.gson.annotations.SerializedName
import rakib.hasan.qcowbd.domain.model.HomeProduct

data class Data(
    val id: Int = 0,
    val slug: String = "",
    val title: String = "",
    @SerializedName("category_name") val categoryName: String = "",
    @SerializedName("breed_title") val breedTitle: String = "",
    @SerializedName("low_price") val lowPrice: String = "",
    @SerializedName("high_price") val highPrice: String = "",
    val image: String = "",
    @SerializedName("is_booked") val isBooked: String = ""
)

fun Data.toHomeProduct(): HomeProduct = HomeProduct(
    title = title,
    image = image
)
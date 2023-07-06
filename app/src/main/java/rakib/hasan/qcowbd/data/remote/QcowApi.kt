package rakib.hasan.qcowbd.data.remote

import rakib.hasan.qcowbd.data.remote.dto.category.CategoriesDto
import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto
import retrofit2.http.GET

interface QcowApi {

    @GET("api/home/products")
    suspend fun getHomeProducts(): HomeProductsDto

    @GET("api/home/categories")
    suspend fun getCategories(): CategoriesDto

}
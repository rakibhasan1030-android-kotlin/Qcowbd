package rakib.hasan.qcowbd.domain.repository

import rakib.hasan.qcowbd.data.remote.dto.category.CategoriesDto
import rakib.hasan.qcowbd.data.remote.dto.feature_service.FeatureServicesDto
import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto

interface QcowRepository {
    suspend fun getHomeProducts(): HomeProductsDto
    suspend fun getCategories(): CategoriesDto
    suspend fun getFeatureService(): FeatureServicesDto
}
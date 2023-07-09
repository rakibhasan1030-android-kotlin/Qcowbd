package rakib.hasan.qcowbd.domain.repository.repository

import rakib.hasan.qcowbd.data.remote.QcowApi
import rakib.hasan.qcowbd.data.remote.dto.category.CategoriesDto
import rakib.hasan.qcowbd.data.remote.dto.feature_service.FeatureServicesDto
import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto
import rakib.hasan.qcowbd.domain.repository.QcowRepository
import javax.inject.Inject

class QcowRepositoryImpl @Inject constructor(
    private val api: QcowApi
) : QcowRepository {
    override suspend fun getHomeProducts(): HomeProductsDto = api.getHomeProducts()
    override suspend fun getCategories(): CategoriesDto = api.getCategories()
    override suspend fun getFeatureService(): FeatureServicesDto = api.getFeatureService()
}
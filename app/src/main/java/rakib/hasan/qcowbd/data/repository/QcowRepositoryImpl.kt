package rakib.hasan.qcowbd.data.repository

import rakib.hasan.qcowbd.data.remote.QcowApi
import rakib.hasan.qcowbd.data.remote.dto.category.CategoriesDto
import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto
import rakib.hasan.qcowbd.domain.repository.QcowRepository
import javax.inject.Inject

class QcowRepositoryImpl @Inject constructor(
    private val api: QcowApi
) : QcowRepository {
    override suspend fun getHomeProducts(): HomeProductsDto = api.getHomeProducts()
    override suspend fun getCategories(): CategoriesDto = api.getCategories()
}
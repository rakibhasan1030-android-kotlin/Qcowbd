package rakib.hasan.qcowbd.domain.repository

import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto

interface QcowRepository {
    suspend fun getHomeProducts(): HomeProductsDto
}
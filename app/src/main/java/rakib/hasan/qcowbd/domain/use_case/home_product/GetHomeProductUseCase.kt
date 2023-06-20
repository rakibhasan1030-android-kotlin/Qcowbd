package rakib.hasan.qcowbd.domain.use_case.home_product

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import rakib.hasan.qcowbd.common.Resource
import rakib.hasan.qcowbd.data.remote.dto.home_product.Data
import rakib.hasan.qcowbd.data.remote.dto.home_product.HomeProductsDto
import rakib.hasan.qcowbd.data.remote.dto.home_product.toHomeProduct
import rakib.hasan.qcowbd.domain.model.HomeProduct
import rakib.hasan.qcowbd.domain.repository.QcowRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetHomeProductUseCase @Inject constructor(
    private val qcowRepository: QcowRepository
) {
    operator fun invoke() : Flow<Resource<List<HomeProduct>>> = flow {
        try {
            emit(Resource.Loading())
            val products = qcowRepository.getHomeProducts().data.map { it.toHomeProduct() }
            emit(Resource.Success(products))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach to the server. Please, check your internet connection."))
        }
    }
}
package rakib.hasan.qcowbd.domain.use_case.category

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import rakib.hasan.qcowbd.common.Resource
import rakib.hasan.qcowbd.data.remote.dto.category.toCategory
import rakib.hasan.qcowbd.domain.model.Category
import rakib.hasan.qcowbd.domain.repository.QcowRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val qcowRepository: QcowRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = qcowRepository.getCategories().data.map { it.toCategory() }
            emit(Resource.Success(categories))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach to the server. Please, check your internet connection."))
        }
    }
}


















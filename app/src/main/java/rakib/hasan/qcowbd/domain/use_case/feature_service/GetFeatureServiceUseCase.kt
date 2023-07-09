package rakib.hasan.qcowbd.domain.use_case.feature_service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import rakib.hasan.qcowbd.common.Resource
import rakib.hasan.qcowbd.data.remote.dto.feature_service.toFeatureService
import rakib.hasan.qcowbd.domain.model.FeatureService
import rakib.hasan.qcowbd.domain.repository.QcowRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFeatureServiceUseCase @Inject constructor(
    private val qcowRepository: QcowRepository
) {
    operator fun invoke(): Flow<Resource<List<FeatureService>>> = flow {
        try {
            emit(Resource.Loading())
            val featureServices = qcowRepository.getFeatureService().data.map { it.toFeatureService() }
            emit(Resource.Success(featureServices))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach to the server. Please, check your internet connection."))
        }
    }
}
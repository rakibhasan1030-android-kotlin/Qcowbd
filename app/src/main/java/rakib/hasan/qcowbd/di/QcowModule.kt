package rakib.hasan.qcowbd.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import rakib.hasan.qcowbd.common.Constants
import rakib.hasan.qcowbd.data.remote.QcowApi
import rakib.hasan.qcowbd.data.repository.QcowRepositoryImpl
import rakib.hasan.qcowbd.domain.repository.QcowRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QcowModule {

    @Provides
    @Singleton
    fun provideQcowApi(): QcowApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QcowApi::class.java)
    }

    @Provides
    @Singleton
    fun provideQcowRepository(api: QcowApi): QcowRepository{
        return QcowRepositoryImpl(api)
    }

}
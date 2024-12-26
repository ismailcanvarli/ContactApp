//Created by canVarli on 12/24/2024

package ismailcanvarli.contactapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ismailcanvarli.contactapp.data.datasource.PersonDataSource
import ismailcanvarli.contactapp.data.repo.PersonRepository
import ismailcanvarli.contactapp.retrofit.ApiUtils
import ismailcanvarli.contactapp.retrofit.PersonDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonRepository(personDataSource: PersonDataSource): PersonRepository {
        return PersonRepository(personDataSource)
    }

    @Provides
    @Singleton
    fun providePersonDataSource(personDao: PersonDao): PersonDataSource {
        return PersonDataSource(personDao)
    }

    @Provides
    @Singleton
    fun providePersonDao(): PersonDao {
        return ApiUtils.getPersonDao()
    }
}
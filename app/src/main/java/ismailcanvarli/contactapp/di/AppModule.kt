//Created by canVarli on 12/24/2024

package ismailcanvarli.contactapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ismailcanvarli.contactapp.data.datasource.PersonDataSource
import ismailcanvarli.contactapp.data.repo.PersonRepository
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
    fun providePersonDataSource(): PersonDataSource {
        return PersonDataSource()
    }
}
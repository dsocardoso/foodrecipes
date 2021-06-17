package br.com.dsocardoso.foodrecipes.di

import android.content.Context
import androidx.room.Room
import br.com.dsocardoso.foodrecipes.data.database.RecipesDatabase
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RecipesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDAO(database: RecipesDatabase) = database.recipesDao()
}
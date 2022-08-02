package br.com.dsocardoso.foodrecipes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.dsocardoso.foodrecipes.data.database.entities.FavoritiesEntity
import br.com.dsocardoso.foodrecipes.data.database.entities.FoodJokeEntity
import br.com.dsocardoso.foodrecipes.data.database.entities.RecipesEntity

@Database(
    entities = [RecipesEntity::class, FavoritiesEntity::class, FoodJokeEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase : RoomDatabase() {

    abstract fun recipesDao(): RecipesDAO
}

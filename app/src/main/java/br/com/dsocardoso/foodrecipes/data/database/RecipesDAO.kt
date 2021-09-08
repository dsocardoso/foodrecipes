package br.com.dsocardoso.foodrecipes.data.database

import androidx.room.*
import br.com.dsocardoso.foodrecipes.data.database.entities.FavoritiesEntity
import br.com.dsocardoso.foodrecipes.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteRecipe(favoritiesEntity: FavoritiesEntity)

    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Query("SELECT * FROM favorities_recipes_table ORDER BY id ASC")
    fun readFavoriteRecipes(): Flow<List<FavoritiesEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoritiesEntity: FavoritiesEntity)

    @Query("DELETE FROM favorities_recipes_table")
    suspend fun deleteAllFavoriteRecipes()

}
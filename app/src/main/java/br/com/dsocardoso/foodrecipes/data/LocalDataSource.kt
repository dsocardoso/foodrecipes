package br.com.dsocardoso.foodrecipes.data

import br.com.dsocardoso.foodrecipes.data.database.RecipesDAO
import br.com.dsocardoso.foodrecipes.data.database.entities.FavoritiesEntity
import br.com.dsocardoso.foodrecipes.data.database.entities.FoodJokeEntity
import br.com.dsocardoso.foodrecipes.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDAO: RecipesDAO
) {
    fun readRecipes(): Flow<List<RecipesEntity>> {
        return recipesDAO.readRecipes()
    }

    fun readFavoriteRecipes(): Flow<List<FavoritiesEntity>> {
        return recipesDAO.readFavoriteRecipes()
    }

    fun readFoodJoke(): Flow<List<FoodJokeEntity>> {
        return recipesDAO.readFoodJoke()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDAO.insertRecipes(recipesEntity)
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity) {
        recipesDAO.insertFoodJoke(foodJokeEntity)
    }

    suspend fun insertFavoriteRecipes(favoritiesEntity: FavoritiesEntity) {
        recipesDAO.insertFavoriteRecipe(favoritiesEntity)
    }

    suspend fun deleteFavoriteRecipes(favoritiesEntity: FavoritiesEntity) {
        recipesDAO.deleteFavoriteRecipe(favoritiesEntity)
    }

    suspend fun deleteAllFavoriteRecipes() {
        recipesDAO.deleteAllFavoriteRecipes()
    }
}

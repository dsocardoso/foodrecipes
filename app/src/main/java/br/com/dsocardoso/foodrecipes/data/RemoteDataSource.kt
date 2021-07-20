package br.com.dsocardoso.foodrecipes.data

import br.com.dsocardoso.foodrecipes.data.network.FoodRecipesApi
import br.com.dsocardoso.foodrecipes.model.FoodRecipe
import retrofit2.Response
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
       return foodRecipesApi.getRecipes(queries)
    }
}
package br.com.dsocardoso.foodrecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.dsocardoso.foodrecipes.util.Constants
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.QUERY_ADD_RECIPE_INFORMATION
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.QUERY_API_KEY
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.QUERY_DIET
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.QUERY_FILL_INGREDIENTS
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.QUERY_NUMBER
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.QUERY_TYPE

class RecipesViewModel(application: Application): AndroidViewModel(application){

     fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = Constants.API_KEY
        queries[QUERY_TYPE] = "main course"
        queries[QUERY_DIET] = "gluten free"
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }
}
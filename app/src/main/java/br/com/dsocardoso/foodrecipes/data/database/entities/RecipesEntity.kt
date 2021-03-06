package br.com.dsocardoso.foodrecipes.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.dsocardoso.foodrecipes.model.FoodRecipe
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}

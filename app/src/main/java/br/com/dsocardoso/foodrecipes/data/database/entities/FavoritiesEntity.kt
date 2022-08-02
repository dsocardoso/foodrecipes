package br.com.dsocardoso.foodrecipes.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.dsocardoso.foodrecipes.model.Result
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.FAVORITIES_RECIPES_TABLE

@Entity(tableName = FAVORITIES_RECIPES_TABLE)
class FavoritiesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)

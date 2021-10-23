package br.com.dsocardoso.foodrecipes.bindingadapters

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import br.com.dsocardoso.foodrecipes.data.database.entities.FoodJokeEntity
import br.com.dsocardoso.foodrecipes.model.FoodJoke
import br.com.dsocardoso.foodrecipes.util.NetworkResult
import com.google.android.material.card.MaterialCardView

class FoodJokeBinding {

    companion object {
        @BindingAdapter("readApiResponse3", "readDatabase3", requireAll = false)
        @JvmStatic
        fun setCardAndProgressVisibility (
            view: View,
            apiResponse: NetworkResult<FoodJoke>?,
            database: List<FoodJokeEntity>?
        ) {
            when(apiResponse) {
                is NetworkResult.Loading -> {
                    when (view) {
                        is ProgressBar -> {
                            view.visibility = View.VISIBLE
                        }
                        is MaterialCardView -> {
                            view.visibility = View.INVISIBLE
                        }
                    }
                }
                is NetworkResult.Error -> {
                    when(view) {
                        is ProgressBar -> {
                            view.visibility = View.INVISIBLE
                        }
                        is MaterialCardView -> {
                            view.visibility = View.VISIBLE
                            if(database != null) {
                                view.visibility = View.INVISIBLE
                            }
                        }
                    }
                }
                is NetworkResult.Success -> {
                    when(view) {
                        is ProgressBar -> {
                            view.visibility = View.INVISIBLE
                        }
                        is MaterialCardView -> {
                            view.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
}
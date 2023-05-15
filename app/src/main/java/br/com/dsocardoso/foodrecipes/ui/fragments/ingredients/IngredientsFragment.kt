package br.com.dsocardoso.foodrecipes.ui.fragments.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dsocardoso.foodrecipes.R
import br.com.dsocardoso.foodrecipes.adapters.IngredientsAdapter
import br.com.dsocardoso.foodrecipes.databinding.FragmentIngredientsBinding
import br.com.dsocardoso.foodrecipes.delegate.viewBinding
import br.com.dsocardoso.foodrecipes.model.Result
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.RECIPE_RESULT_KEY


class IngredientsFragment : Fragment() {

    private val binding by viewBinding(FragmentIngredientsBinding::bind)
    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ingredients, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        setupRecyclerView(view)
        myBundle?.extendedIngredients?.let { mAdapter.setData(it) }

        return view
    }

    private fun setupRecyclerView(view: View) {
        binding.ingredientsRecyclerView.adapter = mAdapter
        binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
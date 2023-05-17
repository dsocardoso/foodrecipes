package br.com.dsocardoso.foodrecipes.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.com.dsocardoso.foodrecipes.R
import br.com.dsocardoso.foodrecipes.databinding.FragmentOverviewBinding
import br.com.dsocardoso.foodrecipes.delegate.viewBinding
import br.com.dsocardoso.foodrecipes.model.Result
import br.com.dsocardoso.foodrecipes.util.Constants.Companion.RECIPE_RESULT_KEY
import coil.load
import org.jsoup.Jsoup


class OverviewFragment : Fragment() {

    private val binding by viewBinding(FragmentOverviewBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        setFields(view, myBundle)
    }

    private fun setFields(view: View, myBundle: Result?) {
        with(view) {
            binding.mainImageView.load(myBundle?.image)
            binding.titleTextView.text = myBundle?.title
            binding.likesTextView.text = myBundle?.aggregateLikes.toString()
            binding.timeTextView.text = myBundle?.readyInMinutes.toString()

            myBundle?.summary.let {
                val summary = Jsoup.parse(it).text()
                binding.summaryTextView.text = summary
            }

            if (myBundle?.vegetarian == true) {
                binding.vegetarianImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                binding.vegetarianTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle?.vegan == true) {
                binding.veganImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                binding.veganTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle?.cheap == true) {
                binding.cheapImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                binding.cheapTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle?.dairyFree == true) {
                binding.dairyFreeImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                binding.dairyFreeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle?.glutenFree == true) {
                binding.glutenFreeImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                binding.glutenFreeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle?.veryHealthy == true) {
                binding.healthyImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                binding.healthyTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
        }
    }

}
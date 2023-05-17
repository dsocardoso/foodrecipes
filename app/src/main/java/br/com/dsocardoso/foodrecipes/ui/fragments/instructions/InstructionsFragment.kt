package br.com.dsocardoso.foodrecipes.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import br.com.dsocardoso.foodrecipes.R
import br.com.dsocardoso.foodrecipes.databinding.FragmentInstructionsBinding
import br.com.dsocardoso.foodrecipes.delegate.viewBinding
import br.com.dsocardoso.foodrecipes.model.Result
import br.com.dsocardoso.foodrecipes.util.Constants


class InstructionsFragment : Fragment() {

    private val binding by viewBinding(FragmentInstructionsBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_instructions, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)

        binding.instructionsWebView.webViewClient = object : WebViewClient() {}
        val webSiteUrl: String = myBundle!!.sourceUrl
        binding.instructionsWebView.loadUrl(webSiteUrl)
    }

}
package br.com.dsocardoso.foodrecipes.ui.fragments.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import br.com.dsocardoso.foodrecipes.R
import br.com.dsocardoso.foodrecipes.model.Result
import br.com.dsocardoso.foodrecipes.util.Constants
import kotlinx.android.synthetic.main.fragment_instructions.view.*

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instructions, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)

        view.instructions_webView.webViewClient = object : WebViewClient() {}
        val webSiteUrl: String = myBundle!!.sourceUrl
        view.instructions_webView.loadUrl(webSiteUrl)

        return view
    }
}

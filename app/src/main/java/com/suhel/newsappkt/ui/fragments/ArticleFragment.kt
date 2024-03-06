package com.suhel.newsappkt.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.suhel.newsappkt.R
import com.suhel.newsappkt.databinding.FragmentArticleBinding
import com.suhel.newsappkt.ui.NewsActivity
import com.suhel.newsappkt.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var binding: FragmentArticleBinding
    lateinit var newsViewModel: NewsViewModel
    val args:ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentArticleBinding.bind(view)

        newsViewModel=(activity as NewsActivity).newsViewModel
        val article=args.article

        binding.webView.apply {
            webViewClient= WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view,"Added to favourites",Snackbar.LENGTH_SHORT).show()
        }
    }
}
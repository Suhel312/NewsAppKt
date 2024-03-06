package com.suhel.newsappkt.repository

import com.suhel.newsappkt.api.RetrofitInstance
import com.suhel.newsappkt.db.ArticleDatabase
import com.suhel.newsappkt.models.Article

class NewsRepository(val db:ArticleDatabase) {

    suspend fun getHeadlines(countryCode:String,pageNumber:Int)=
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber :Int)=
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article:Article)=db.getArticleDao().upsert(article)

    suspend fun deletearticle(article: Article)=db.getArticleDao().deleteArticle(article)

    fun getFavouriteNews()=db.getArticleDao().getAllArticles()
}
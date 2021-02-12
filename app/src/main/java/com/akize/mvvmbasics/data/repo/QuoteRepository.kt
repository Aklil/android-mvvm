package com.akize.mvvmbasics.data.repo

import android.content.Context
import com.akize.mvvmbasics.data.dao.QuoteDao
import com.akize.mvvmbasics.data.db.AppDatabase
import com.akize.mvvmbasics.data.entity.Quote

//repos: act as a single source of truth, are mediators
// also make it a singleton
class QuoteRepository {

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        // volatile: writes to this are immediately visible to other threads
        @Volatile
        private var instance: QuoteRepository? = null

        private lateinit var quoteDao: QuoteDao

        fun getInstance(context: Context): QuoteRepository {
            return instance
                    ?: synchronized(this) {  // sync and lock threads - enforcing thread safety
                        return instance ?: QuoteRepository().also {
                            instance = it
                            quoteDao = AppDatabase.getInstance(context).quoteDao
                        }// check again after lock just in case: then instantiate and assign it to instance object
                    }
        }
    }
}
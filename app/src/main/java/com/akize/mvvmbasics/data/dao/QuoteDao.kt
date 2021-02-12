package com.akize.mvvmbasics.data.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akize.mvvmbasics.data.entity.Quote

class QuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote){

        // add to list
        quoteList.add(quote)

        //refresh live data
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}
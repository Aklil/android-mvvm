package com.akize.mvvmbasics.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.akize.mvvmbasics.data.entity.Quote
import com.akize.mvvmbasics.data.repo.QuoteRepository

class QuoteViewModel (private val quoteRepository: QuoteRepository): ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}
@file:Suppress("UNCHECKED_CAST")

package com.akize.mvvmbasics.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akize.mvvmbasics.data.repo.QuoteRepository

// creates the QuoteViewModel for DI
class QuoteViewModelFactory (
        private val _context: Context
        )
    : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel(
                QuoteRepository.getInstance(_context)
        ) as T
    }
}
package com.akize.mvvmbasics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.akize.mvvmbasics.data.db.AppDatabase
import com.akize.mvvmbasics.data.entity.Quote
import com.akize.mvvmbasics.data.repo.QuoteRepository
import com.akize.mvvmbasics.databinding.ActivityQuoteBinding
import com.akize.mvvmbasics.ui.viewmodel.QuoteViewModel
import com.akize.mvvmbasics.ui.viewmodel.QuoteViewModelFactory

class QuoteActivity : AppCompatActivity() {

    private lateinit var quoteViewModel: QuoteViewModel

    private lateinit var binding: ActivityQuoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        quoteViewModel = ViewModelProvider(this,
                QuoteViewModelFactory(
                        this.application
                )
        ).get(QuoteViewModel::class.java)

        quoteViewModel.getQuotes().observe(this, Observer{quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote -> stringBuilder.append("$quote\n\n")}

            binding.tvQuoteDisplay.text = stringBuilder.toString()

        })  //observe until thusdestoryed: lifecycle aware

        binding.btnAddQuote.setOnClickListener{
            val quote = Quote(binding.etQuote.text.toString(), binding.etAuthor.text.toString())
            quoteViewModel.addQuote(quote)
        }
    }
}
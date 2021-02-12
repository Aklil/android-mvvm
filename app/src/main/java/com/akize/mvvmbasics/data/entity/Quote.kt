package com.akize.mvvmbasics.data.entity

data class Quote(val quoteText: String,
                 val author: String) {
    override fun toString(): String {
        return "$quoteText - $author"
    }
}
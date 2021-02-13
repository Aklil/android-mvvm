package com.akize.mvvmbasics.data.db

import android.content.Context
import com.akize.mvvmbasics.data.dao.QuoteDao

/**
 * creating a singleton db connector
 *  doing it in java way to pass the app CONTEXT to the constructor
 */
class AppDatabase private constructor(){

    val quoteDao = QuoteDao()

    companion object {
        // volatile: writes to this are immediately visible to other threads
        //The volatile keyword guarantees visibility of changes to variables across threads
        // because it is written to and read from the main memory not cpu cache
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this){  // sync and lock threads - enforcing thread safety
            instance ?: AppDatabase().also { instance = it }  // check again after lock just in case: then instantiate and assign it to instance object
        }
    }
}
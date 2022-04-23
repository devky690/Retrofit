package edu.towson.cosc435.abrahams.kotlin_requests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.towson.cosc435.abrahams.kotlin_requests.repository.Repository

class MainViewModelFactory(private val repository: Repository)
    : ViewModelProvider.Factory {

        override fun <T: ViewModel?> create(modelClass: Class<T>): T{
            return MainViewModel(repository) as T
        }

}
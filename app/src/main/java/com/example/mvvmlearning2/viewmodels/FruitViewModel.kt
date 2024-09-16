package com.example.mvvmlearning2.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmlearning2.models.FruitResponseTypeItem
import com.example.mvvmlearning2.repository.FruitRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(
    private val repositoryImpl: FruitRepositoryImpl
): ViewModel() {

    val detail: StateFlow<FruitResponseTypeItem?>
        get() = repositoryImpl.details
//
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    var query = MutableStateFlow<String?>("")


//    private val _detail = MutableStateFlow<FruitResponseTypeItem?>(null)
//    val detail: StateFlow<FruitResponseTypeItem?> = _detail

//    private val _toastMessage = MutableStateFlow<String>("")
//    val toastMessage: StateFlow<String> = _toastMessage

//    private val _query = MutableStateFlow<String>("")
//    val query: StateFlow<String> = _query

    fun getDetails(){
        viewModelScope.launch {

            if(query.value != "" && query.value != null)
                repositoryImpl.getDetails(query.value!!)
        else{
            setToastMessage()
        }


    }}


    fun setToastMessage(){
        _toastMessage.value = "Enter text first !";
    }

    fun shownToast(){
        _toastMessage.value = ""
    }
}
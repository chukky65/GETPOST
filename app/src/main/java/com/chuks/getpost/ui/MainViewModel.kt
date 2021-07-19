package com.chuks.getpost.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chuks.getpost.Api.RetrofitProvider
import com.chuks.getpost.model.Items
import com.chuks.getpost.model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    val itemsLiveData = MutableLiveData<List<Items>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            itemsLiveData.postValue(RetrofitProvider.placeHolderAPI.getItems())
        }
    }

    fun addStudent(newSet: Student){
        CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RetrofitProvider.placeHolderAPI.addStudents(newSet))
        }
    }

}
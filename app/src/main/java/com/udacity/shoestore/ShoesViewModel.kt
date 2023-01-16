package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var shoe: Shoe


    init {
        shoe = Shoe("", 0.0, "", "")
        _shoeList.value = mutableListOf(
            Shoe(
                "ultraboost", 22.2, "adidas", "description", mutableListOf("")
            ), Shoe(
                "ultraboost", 22.2, "adidas", "description", mutableListOf("")
            )
        )
    }

    fun addNewShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        this.shoe = Shoe("", 0.0, "", "")

    }

}
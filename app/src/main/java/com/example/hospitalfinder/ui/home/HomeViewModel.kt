package com.example.hospitalfinder.ui.home

import androidx.lifecycle.viewModelScope
import com.example.hospitalfinder.base.BaseViewModel
import com.example.hospitalfinder.base.ViewEvent
import com.example.hospitalfinder.network.response.Document
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    fun moveItem(item: Document) = viewModelScope.launch {
        onChangedViewEvent(HomeViewEvent.MoveItem(item))
    }

}

sealed interface HomeViewEvent : ViewEvent{
    data class MoveItem(val item : Document) : HomeViewEvent
}
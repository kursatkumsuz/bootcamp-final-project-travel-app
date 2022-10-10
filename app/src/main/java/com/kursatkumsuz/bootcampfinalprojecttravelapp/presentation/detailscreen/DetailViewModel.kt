package com.kursatkumsuz.bootcampfinalprojecttravelapp.presentation.detailscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.model.TravelModel
import com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.usecase.DetailUseCase
import com.kursatkumsuz.bootcampfinalprojecttravelapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: DetailUseCase
) : ViewModel() {

    private var _updateStatus = MutableLiveData<Resource<TravelModel>>()
    val updateStatus: LiveData<Resource<TravelModel>>
        get() = _updateStatus

    /**
     * Updates value of isBookmark that given id
     * @param [id] for update data
     * @param [isBookmark] for update data
     */
    fun updateData(id: String, isBookmark: Boolean) {
        _updateStatus.value = Resource.loading(null)
        viewModelScope.launch {
            if (id.isNotEmpty()) {
                useCase.updateData(id, isBookmark)
                _updateStatus.value = Resource.success(null)
            }
        }
    }
}
package com.kursatkumsuz.bootcampfinalprojecttravelapp.presentation.addbookmarkscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.model.TravelModel
import com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.usecase.BottomSheetUseCase
import com.kursatkumsuz.bootcampfinalprojecttravelapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AddBookmarkViewModel @Inject constructor(
    private val useCase : BottomSheetUseCase
) : ViewModel() {

    private var _allDataList = MutableLiveData<Resource<List<TravelModel>>>()
    val allDataList: LiveData<Resource<List<TravelModel>>>
        get() = _allDataList

    private var _updateStatus = MutableLiveData<Resource<TravelModel>>()
    val updateStatus: LiveData<Resource<TravelModel>>
        get() = _updateStatus

    init {
        loadAllList()
    }

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

    /**
     * Gets all data
     */
    private fun loadAllList() {
        viewModelScope.launch {
            _allDataList.value = useCase.getAllList()
        }
    }

}
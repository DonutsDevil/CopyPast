package com.swapnil.copypast.repository

import android.util.Log
import com.swapnil.copypast.model.ClipBoardItem
import com.swapnil.copypast.repository.roomDB.utils.ClipBoardItemWrapper
import javax.inject.Inject

class CopyPastRepository @Inject constructor(private val clipBoardItemWrapper: ClipBoardItemWrapper) {
    private val TAG = "CopyPastRepository"
//    private val _clipBoardItemList = MutableLiveData<List<ClipBoardItem>>()
//    val clipBoardItemList: LiveData<List<ClipBoardItem>>
//        get() = _clipBoardItemList

    suspend fun addClipBoardItem(clipBoardItem: ClipBoardItem) {
        Log.d(TAG, "addClipBoardItem: ")
        clipBoardItemWrapper.addClipBoardItem(clipBoardItem)
    }

    suspend fun getClipBoardListToBeShown(): List<ClipBoardItem> {
        val clipBoardItemList = clipBoardItemWrapper.getClipBoardItemListToBeShown()
        Log.d(TAG, "getClipBoardListToBeShown: $clipBoardItemList")
        return clipBoardItemList
    }

}
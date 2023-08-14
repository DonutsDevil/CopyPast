package com.swapnil.copypast.repository

import android.util.Log
import com.swapnil.copypast.model.ClipBoardItem
import javax.inject.Inject

class CopyPastRepository @Inject constructor(private val clipBoardLocalService: ClipBoardLocalService) {
    private val TAG = "CopyPastRepository"

    suspend fun addClipBoardItem(clipBoardItem: ClipBoardItem) {
        Log.d(TAG, "addClipBoardItem: ")
        clipBoardLocalService.addClipBoardItem(clipBoardItem)
    }

    suspend fun getClipBoardListToBeShown(): List<ClipBoardItem> {
        val clipBoardItemList = clipBoardLocalService.getClipBoardItemListToBeShown()
        Log.d(TAG, "getClipBoardListToBeShown: $clipBoardItemList")
        return clipBoardItemList
    }

}
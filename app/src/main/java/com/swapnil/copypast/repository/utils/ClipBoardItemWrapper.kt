package com.swapnil.copypast.repository.roomDB.utils

import android.util.Log
import com.swapnil.copypast.model.ClipBoardItem
import com.swapnil.copypast.repository.roomDB.dao.ClipBoardItemDao
import javax.inject.Inject

class ClipBoardItemWrapper @Inject constructor(private val dao: ClipBoardItemDao) {
    private val TAG = "ClipBoardItemWrapper"
    /**
     * Add clipBoardItem to db if user set value to get previous copied text is less then items saved in our local db
     * else delete the oldest item added in db and then add the new item.
     */
    suspend fun addClipBoardItem(item: ClipBoardItem) {
        val userSetSize = getUserSetListSize()
        Log.d(TAG, "addClipBoardItem: user set size = $userSetSize")
        val savedItemsSize = dao.getItemSavedCount()
        Log.d(TAG, "addClipBoardItem: total value present in db = $savedItemsSize")
        if (savedItemsSize >= userSetSize) {
            dao.deleteOldestClipItem()
        }
        Log.d(TAG, "addClipBoardItem: adding clipBoard Item in the db")
        dao.addClipBoard(item)
        Log.d(TAG, "addClipBoardItem: added clipBoard Item in the db")
    }

    /**
     * We show the newest copied item to the top and oldest at the bottom,
     * That's why we call get id from DB in DESC order, And show the same to user.
     */
    suspend fun getClipBoardItemListToBeShown(): List<ClipBoardItem> {
        return dao.getClipBoardListInDescOrder()
    }


    suspend fun getUserSetListSize(): Int {
        // TODO: Use SP or something to give size that user has set for showing previous copied text.
        // returning default 5
        return 5
    }
}
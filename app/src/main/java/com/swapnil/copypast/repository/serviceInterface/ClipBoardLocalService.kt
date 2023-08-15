package com.swapnil.copypast.repository.serviceInterface

import com.swapnil.copypast.model.ClipBoardItem

interface ClipBoardLocalService {

    suspend fun addClipBoardItem(item: ClipBoardItem)

    suspend fun getClipBoardItemListToBeShown(): List<ClipBoardItem>

    suspend fun getUserSetListSize(): Int
}
package com.swapnil.copypast.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.swapnil.copypast.model.ClipBoardItem
import com.swapnil.copypast.repository.roomDB.dao.ClipBoardItemDao

@Database(entities = [ClipBoardItem::class], version = 1)
abstract class CopyPastDB: RoomDatabase() {

    abstract fun getClipBoardItemDao(): ClipBoardItemDao

}
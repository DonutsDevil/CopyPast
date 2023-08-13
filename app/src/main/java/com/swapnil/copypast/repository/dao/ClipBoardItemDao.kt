package com.swapnil.copypast.repository.roomDB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.swapnil.copypast.model.ClipBoardItem

@Dao
interface ClipBoardItemDao {
    @Insert
    suspend fun addClipBoard(item: ClipBoardItem)

    /**
     * returns total clip board item present in the table
     */
    @Query("SELECT COUNT(*) FROM ClipBoardItem")
    suspend fun getItemSavedCount(): Int

    /**
     * Deletes the row with the lowest int value present in id column of clipBoardItem table
     */
    @Query("DELETE FROM ClipBoardItem WHERE id = (SELECT id FROM ClipBoardItem ORDER BY id LIMIT 1)")
    suspend fun deleteOldestClipItem(): Int

    /**
     * The list to be shown is given in desc order because we show last item added as first item
     */
    @Query("SELECT * FROM ClipBoardItem ORDER BY id DESC")
    suspend fun getClipBoardListInDescOrder(): List<ClipBoardItem>
}
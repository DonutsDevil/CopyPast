package com.swapnil.copypast.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClipBoardItem(@PrimaryKey(autoGenerate = true) val id: Int = 0, val text: String = "default")

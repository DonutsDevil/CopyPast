package com.swapnil.copypast.di.module

import android.content.Context
import androidx.room.Room
import com.swapnil.copypast.di.customAnnotation.ApplicationSingleton
import com.swapnil.copypast.repository.CopyPastDB
import com.swapnil.copypast.repository.roomDB.dao.ClipBoardItemDao
import dagger.Module
import dagger.Provides

@Module
class CopyPastDBModule {

    @ApplicationSingleton
    @Provides
    fun providesCopyPastDB(context: Context): CopyPastDB {
        return Room.databaseBuilder(context.applicationContext, CopyPastDB::class.java, "CopyPastDB").build()
    }

    @Provides
    fun provideClipBoardItemDao(db: CopyPastDB): ClipBoardItemDao {
        return db.getClipBoardItemDao()
    }
}
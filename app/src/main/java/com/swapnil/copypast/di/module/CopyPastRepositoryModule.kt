package com.swapnil.copypast.di.module

import com.swapnil.copypast.repository.serviceInterface.ClipBoardLocalService
import com.swapnil.copypast.repository.dao.ClipBoardItemDao
import com.swapnil.copypast.repository.serviceImplmentations.ClipBoardLocalServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CopyPastRepositoryModule {

    @Provides
    fun providesCopyPastLocalServiceImpl(dao: ClipBoardItemDao): ClipBoardLocalService {
        return ClipBoardLocalServiceImpl(dao)
    }
}
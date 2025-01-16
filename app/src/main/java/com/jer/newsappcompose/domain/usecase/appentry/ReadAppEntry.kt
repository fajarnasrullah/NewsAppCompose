package com.jer.newsappcompose.domain.usecase.appentry

import com.jer.newsappcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {

   operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }

}
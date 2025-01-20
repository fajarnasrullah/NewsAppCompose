package com.jer.newsappcompose.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.jer.newsappcompose.domain.model.Source


@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(string: String): Source {
        return string.split(",").let {
            Source(it[0], it[1])
        }
    }
}
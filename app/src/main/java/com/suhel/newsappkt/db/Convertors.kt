package com.suhel.newsappkt.db

import androidx.room.TypeConverter
import com.suhel.newsappkt.models.Source

class Convertors {

    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}
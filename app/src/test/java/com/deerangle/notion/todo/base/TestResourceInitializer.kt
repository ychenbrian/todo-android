package com.deerangle.notion.todo.base

import android.content.res.Resources
import com.deerangle.notion.todo.R
import org.mockito.Mockito

class TestResourceInitializer(private val resources: Resources) {
    fun initialize() {
        val stringMappings =
            mapOf(
                R.string.no_internet_connection to "No internet connection",
            )

        for ((resId, value) in stringMappings) {
            Mockito.lenient().`when`(resources.getString(resId)).thenReturn(value)
        }
    }
}

package com.deerangle.notion.todo.tests.helper

import com.deerangle.notion.todo.R
import com.deerangle.notion.todo.base.BaseUnitTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResourceProviderTest : BaseUnitTest() {
    @Test
    fun getString_returnsCorrectValue() {
        val resId = R.string.no_internet_connection
        val value = "No internet connection"

        val result = resourceProvider.getString(resId)

        assertEquals(value, result)
    }
}

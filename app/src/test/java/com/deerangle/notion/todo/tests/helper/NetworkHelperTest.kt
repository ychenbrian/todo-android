package com.deerangle.notion.todo.tests.helper

import android.net.NetworkCapabilities
import com.deerangle.notion.todo.base.BaseUnitTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NetworkHelperTest : BaseUnitTest() {
    @Test
    fun testNetworkConnection_whenWifiIsConnected_returnTrue() {
        Mockito.`when`(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)).thenReturn(true)

        assert(networkHelper.isNetworkConnected())
    }
}

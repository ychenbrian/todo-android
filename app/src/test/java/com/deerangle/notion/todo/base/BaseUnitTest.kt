package com.deerangle.notion.todo.base

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import com.deerangle.notion.todo.utils.helper.NetworkHelper
import com.deerangle.notion.todo.utils.helper.ResourceProvider
import com.deerangle.notion.todo.utils.helper.ResourceProviderImpl
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito

abstract class BaseUnitTest {
    protected lateinit var networkHelper: NetworkHelper
    protected lateinit var resourceProvider: ResourceProvider
    protected lateinit var resourceInitializer: TestResourceInitializer

    @Mock
    protected lateinit var context: Context

    @Mock
    protected lateinit var resources: Resources

    @Mock
    protected lateinit var connectivityManager: ConnectivityManager

    @Mock
    protected lateinit var networkCapabilities: NetworkCapabilities

    @Mock
    protected lateinit var network: Network

    @Before
    open fun setup() {
        Mockito.lenient().`when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager)
        Mockito.lenient().`when`(connectivityManager.activeNetwork).thenReturn(network)
        Mockito.lenient().`when`(connectivityManager.getNetworkCapabilities(network)).thenReturn(networkCapabilities)
        networkHelper = NetworkHelper(context)

        Mockito.lenient().`when`(context.resources).thenReturn(resources)
        resourceProvider = ResourceProviderImpl(context)

        resourceInitializer = TestResourceInitializer(resources)
        resourceInitializer.initialize()
    }
}

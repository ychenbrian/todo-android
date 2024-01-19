package com.deerangle.notion.todo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deerangle.notion.todo.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import notion.api.v1.NotionClient
import notion.api.v1.request.search.SearchRequest
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor() : ViewModel() {
        fun main() {
            viewModelScope.launch(Dispatchers.IO) {
                NotionClient(token = BuildConfig.NOTION_BEARER_TOKEN).use { client ->
                    // Find the "Test Database" from the list
                    val database =
                        client
                            .search(
                                query = "Test Database",
                                filter = SearchRequest.SearchFilter("database", property = "object"),
                            )
                            .results
                            .find { it.asDatabase().properties.containsKey("Severity") }
                            ?.asDatabase()
                            ?: error("Create a database named 'Test Database' and invite this app's user!")
                }
            }
        }
    }

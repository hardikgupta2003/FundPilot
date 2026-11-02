package com.hardik.fundpilot.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList

/**
 * Manages multi-stack navigation history for top-level destinations (e.g. Bottom Navigation),
 * based on the official Navigation 3 Common UI architecture pattern.
 */
class TopLevelBackStack<T : Any>(val startKey: T) {

    private val topLevelStacks: LinkedHashMap<T, SnapshotStateList<T>> = linkedMapOf(
        startKey to mutableStateListOf(startKey)
    )

    var topLevelKey: T by mutableStateOf(startKey)
        private set

    val backStack = mutableStateListOf(startKey)

    private fun updateBackStack() {
        backStack.apply {
            clear()
            addAll(topLevelStacks.flatMap { it.value })
        }
    }

    fun addTopLevel(key: T) {
        if (topLevelStacks[key] == null) {
            topLevelStacks[key] = mutableStateListOf(key)
        } else {
            topLevelStacks.apply {
                remove(key)?.let { put(key, it) }
            }
        }
        topLevelKey = key
        updateBackStack()
    }

    fun add(key: T) {
        topLevelStacks[topLevelKey]?.add(key)
        updateBackStack()
    }

    fun removeLast() {
        val currentStack = topLevelStacks[topLevelKey]
        val removedKey = currentStack?.removeLastOrNull()
        if (currentStack.isNullOrEmpty()) {
            topLevelStacks.remove(removedKey)
        }
        topLevelKey = topLevelStacks.keys.lastOrNull() ?: startKey
        updateBackStack()
    }
}

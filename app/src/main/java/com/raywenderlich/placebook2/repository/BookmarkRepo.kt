package com.raywenderlich.placebook2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.raywenderlich.placebook2.db.BookmarkDao
import com.raywenderlich.placebook2.db.PlaceBookDatabase
import com.raywenderlich.placebook2.model.Bookmark

// 1
class BookmarkRepo(context: Context) {
    // 2
    private var db = PlaceBookDatabase.getInstance(context)
    private var bookmarkDao: BookmarkDao = db.bookmarkDao()
    // 3
    fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }
    // 4
    fun createBookmark(): Bookmark {
        return Bookmark()
    }
    // 5
    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }
}
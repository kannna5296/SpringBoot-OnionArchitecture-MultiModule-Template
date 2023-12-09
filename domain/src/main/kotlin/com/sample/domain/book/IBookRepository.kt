package com.sample.domain.book

interface IBookRepository {
    fun insert(book: Book)
    fun findById(bookId: Int): Book?
}

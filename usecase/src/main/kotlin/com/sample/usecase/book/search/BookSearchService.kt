package com.sample.usecase.book.search

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookSearchService(
    private val sampleRepository: IBookQueryRepository
) {

    fun execute(form: BookSearchForm, pageable: Pageable): Page<BookSearchResponse> {

        // usecase層でやるちぇっくとあればいれる
        val resultDtoList = sampleRepository.search(form)

        val result = resultDtoList.first.map { BookSearchResponse(it) }

        return PageImpl(result, pageable, resultDtoList.second.toLong())
    }
}

package com.sample.usecase.book.detail

class CanRentalConverter {

    companion object {

        fun convert(dto: List<BookDetailRentalDto>): Boolean {
            if (dto.isEmpty()) return true
            return dto.all { it.isReturned }
        }
    }
}

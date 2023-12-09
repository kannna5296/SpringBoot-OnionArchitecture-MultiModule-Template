package com.sample.infra.repository.user

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.domain.user.IUserRepository
import com.sample.infra.jpa.entity.QRentalUserJpaEntity
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val queryFactory: JPAQueryFactory
) : IUserRepository {

    private val user = QRentalUserJpaEntity.rentalUserJpaEntity

    override fun findById(userId: Int): Int? {
        return queryFactory.select(user.id).from(user).where(user.id.eq(userId)).fetchOne()
    }
}

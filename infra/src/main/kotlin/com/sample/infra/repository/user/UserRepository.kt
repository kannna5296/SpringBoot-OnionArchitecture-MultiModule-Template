package com.sample.infra.repository.user

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.domain.user.IUserRepository
import com.sample.domain.user.RentalUser
import com.sample.infra.jpa.entity.QRentalUserJpaEntity
import com.sample.infra.jpa.entity.RentalUserJpaEntity
import com.sample.infra.jpa.repository.RentalUserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val userRepository: RentalUserJpaRepository,
    private val queryFactory: JPAQueryFactory
) : IUserRepository {

    private val user = QRentalUserJpaEntity.rentalUserJpaEntity
    override fun insert(rentalUser: RentalUser) {
        userRepository.saveAndFlush(RentalUserJpaEntity(rentalUser))
    }

    override fun findById(userId: Int): Int? {
        return queryFactory.select(user.id).from(user).where(user.id.eq(userId)).fetchOne()
    }
}

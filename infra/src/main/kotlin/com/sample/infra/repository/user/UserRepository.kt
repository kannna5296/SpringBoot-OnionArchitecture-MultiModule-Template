package com.sample.infra.repository.user

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.domain.user.IUserRepository
import com.sample.domain.user.Mail
import com.sample.domain.user.Name
import com.sample.domain.user.Phone
import com.sample.domain.user.RentalUser
import com.sample.infra.jpa.entity.QRentalUserJpaEntity
import com.sample.infra.jpa.entity.RentalUserJpaEntity
import com.sample.infra.jpa.repository.RentalUserJpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Repository
class UserRepository(
    private val userRepository: RentalUserJpaRepository,
    private val queryFactory: JPAQueryFactory
) : IUserRepository {

    private val user = QRentalUserJpaEntity.rentalUserJpaEntity

    override fun insert(rentalUser: RentalUser) {
        userRepository.saveAndFlush(RentalUserJpaEntity(rentalUser))
    }

    // PUT(全体更新)
    @Transactional
    override fun update(rentalUser: RentalUser) {
        queryFactory.update(user)
            .set(user.phone, rentalUser.phone?.value)
            .set(user.mail, rentalUser.mail.value)
            .set(user.updatedAt, OffsetDateTime.now())
            .where(user.id.eq(rentalUser.id))
            .execute()
    }

    override fun findById(userId: Int): RentalUser? {
        val result = queryFactory.select(
            user.id,
            user.name,
            user.phone,
            user.mail
        ).from(user)
            .where(user.id.eq(userId)).fetchOne() ?: return null

        return RentalUser(
            id = result[user.id],
            name = Name(result[user.name]!!),
            phone = Phone(result[user.phone]!!),
            mail = Mail(result[user.mail]!!),
        )
    }
}

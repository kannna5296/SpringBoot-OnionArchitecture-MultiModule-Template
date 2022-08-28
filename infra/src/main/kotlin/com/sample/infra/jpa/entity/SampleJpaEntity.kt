package com.sample.infra.jpa.entity

import com.sample.domain.sampledomain.Name
import com.sample.domain.sampledomain.Sample
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "sample")
class SampleJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    val name: String? = null,
) {
    // DomainEntity -> JpaEntity
    constructor(sample: Sample) :this(
        name = sample.name.value
    )

    // JpaEntity -> DomainEntity
    fun toDomain() :Sample {
        return Sample(
            id = this.id,
            name = Name(name ?: throw Exception())
        )
    }
}

package com.sample.infra.repository

import com.sample.domain.sampledomain.ISampleRepository
import com.sample.domain.sampledomain.Sample
import com.sample.infra.jpa.entity.RentalUserJpaEntity
import org.springframework.stereotype.Repository

@Repository
class SampleRepository(
    private val sampleJpaRepository: SampleJpaRepository
) : ISampleRepository {

    override fun insert(sample: Sample): Sample {
        return sampleJpaRepository.saveAndFlush(RentalUserJpaEntity(sample)).toDomain()
    }
}

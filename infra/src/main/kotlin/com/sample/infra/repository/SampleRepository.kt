package com.sample.infra.repository

import com.sample.domain.sampledomain.ISampleRepository
import com.sample.domain.sampledomain.Sample
import com.sample.infra.jpa.entity.SampleJpaEntity
import com.sample.infra.jpa.repository.SampleJpaRepository
import org.springframework.stereotype.Repository

@Repository
class SampleRepository(
    private val sampleJpaRepository: SampleJpaRepository
) : ISampleRepository {

    override fun insert(sample: Sample): Sample {
        return sampleJpaRepository.saveAndFlush(SampleJpaEntity(sample)).toDomain()
    }
}

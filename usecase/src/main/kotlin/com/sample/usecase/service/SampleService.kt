package com.sample.usecase.service

import com.sample.domain.sampledomain.ISampleRepository
import com.sample.domain.sampledomain.Name
import com.sample.domain.sampledomain.Sample
import com.sample.usecase.request.SampleForm
import com.sample.usecase.response.SampleResponse
import org.springframework.stereotype.Service

@Service
class SampleService(
    private val sampleRepository: ISampleRepository
) {
    //例としてInsertを実装
    fun insert(form: SampleForm): SampleResponse {
        val sample = Sample(
            name = Name(form.name),
        )
        val insertedSample = sampleRepository.insert(sample)
        return SampleResponse(id = insertedSample.id ?: throw Exception())
    }
}

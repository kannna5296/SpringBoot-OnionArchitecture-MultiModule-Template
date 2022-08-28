package com.sample.usecase.service

import com.sample.usecase.request.SampleForm
import com.sample.usecase.response.SampleResponse
import org.springframework.stereotype.Service

@Service
class SampleService {
    fun execute(param: SampleForm): SampleResponse {
        return SampleResponse(id = 1)
    }
}

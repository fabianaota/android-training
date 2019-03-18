package io.redspark.redstest.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import kotlin.collections.ArrayList

@JsonIgnoreProperties(ignoreUnknown = true)
class ExamResponse {

    @JsonProperty("id")
    var examId: String = String()

    @JsonProperty("name")
    var examName: String = String()

    @JsonProperty("date")
    var examDate: String = String()

    @JsonProperty("type")
    var examType: Int = 0

    @JsonProperty("hour")
    var examHour: String = String()

    @JsonProperty("results")
    var examResults: List<ResultResponse> = ArrayList()

}
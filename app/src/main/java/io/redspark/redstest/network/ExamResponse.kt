package io.redspark.redstest.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.redspark.redstest.models.Result
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class ExamResponse {

    @JsonProperty("id")
    var id = 0

    @JsonProperty("name")
    var name = String()

    @JsonProperty("date")
    var date = Date()

    @JsonProperty("type")
    var type = 0

    @JsonProperty("hour")
    var hour = Date()

    @JsonProperty("results")
    var results = ArrayList<ResultResponse>()

}
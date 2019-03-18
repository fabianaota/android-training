package io.redspark.redstest.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ResultResponse {

    @JsonProperty("name")
    var resultName: String = String()

    @JsonProperty("value")
    var resultValue: String = String()

    @JsonProperty("status")
    var resultStatus: Int = 0

}
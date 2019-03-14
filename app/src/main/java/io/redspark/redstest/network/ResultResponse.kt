package io.redspark.redstest.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ResultResponse {

    @JsonProperty("name")
    var name = String()

    @JsonProperty("value")
    var value = String()

    @JsonProperty("status")
    var status = 0

}
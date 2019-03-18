package io.redspark.redstest.models

import io.redspark.redstest.network.response.ResultResponse

class ExamResult(resultResponse: ResultResponse) {
    var title = resultResponse.resultName
    var subtitle = resultResponse.resultValue
    var statusType = resultResponse.resultStatus

}
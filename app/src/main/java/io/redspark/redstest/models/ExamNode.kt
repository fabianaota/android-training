package io.redspark.redstest.models

import io.redspark.redstest.enums.ExamType
import io.redspark.redstest.enums.NodeType
import io.redspark.redstest.enums.StatusType

class ExamNode(val nodeType: NodeType) {

    var title = String()
    var examType = ExamType.NONE
    var subtitle = String()
    var statusType = StatusType.NONE
    var resultList = ArrayList<ExamResult>()

    constructor(date: String) : this(NodeType.DATE) {
        this.title = date
    }

    constructor(examName: String, examType: ExamType, examHour: String) : this(NodeType.PROCEDURE) {
        this.title = examName
        this.examType = examType
        this.subtitle = examHour
    }

    constructor(resultName: String, statusType: StatusType, resultValue: String) : this(NodeType.RESULT) {
        this.title = resultName
        this.statusType = statusType
        this.subtitle = resultValue
    }

}
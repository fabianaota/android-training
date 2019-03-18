package io.redspark.redstest.modules.exam.datamanager;

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.redspark.redstest.config.MainApplication
import io.redspark.redstest.enums.ExamType
import io.redspark.redstest.enums.StatusType
import io.redspark.redstest.models.ExamNode
import io.redspark.redstest.models.ExamResult
import io.redspark.redstest.modules.exam.contracts.ExamContracts
import io.redspark.redstest.network.MockUtils
import io.redspark.redstest.network.response.ExamResponse

class ExamRemoteDataManager : ExamContracts.RemoteDataManager {

    override fun getMockedExamList(): ArrayList<ExamNode> {
        val json = MockUtils.loadJSONFromAsset(MainApplication.applicationContext(), "data.json")
        val examResponseList = jacksonObjectMapper().readValue<List<ExamResponse>>(json)
        val examNodeList = ArrayList<ExamNode>()
        examResponseList.forEach {
            val mapNodeList = mapNodeFromResponse(it)
            examNodeList.addAll(mapNodeList)
        }
        return examNodeList
    }


    private fun mapNodeFromResponse(examResponse: ExamResponse): List<ExamNode> {
        val examList = ArrayList<ExamNode>()
        val dateExamNode = ExamNode(examResponse.examDate)
        examList.add(dateExamNode)
        val procedureExamNode = ExamNode(
            examResponse.examName,
            ExamType.from(examResponse.examType),
            examResponse.examHour
        )
        examList.add(procedureExamNode)
        examResponse.examResults.forEach {
            procedureExamNode.resultList.add(ExamResult(it))
            examList.add(
                ExamNode(
                    it.resultName,
                    StatusType.from(it.resultStatus),
                    it.resultValue
                )
            )
        }
        return examList
    }

}
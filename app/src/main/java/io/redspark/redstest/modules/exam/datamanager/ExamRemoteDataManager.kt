package io.redspark.redstest.modules.exam.datamanager;

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import io.redspark.redstest.MockUtils
import io.redspark.redstest.config.MainApplication
import io.redspark.redstest.models.Exam
import io.redspark.redstest.modules.exam.contracts.ExamContracts

class ExamRemoteDataManager : ExamContracts.RemoteDataManager {

    override fun getMockedExamList(): ArrayList<Exam>{
        val json = MockUtils.loadJSONFromAsset(MainApplication.applicationContext(), "data.json")
        return ObjectMapper().readValue(json, object : TypeReference<List<Exam>>(){})
    }

}
package io.redspark.redstest.modules.exam.interactor

import io.redspark.redstest.models.Exam
import io.redspark.redstest.modules.exam.contracts.ExamContracts
import java.util.*

class ExamInteractor(
    private val remoteDataManager: ExamContracts.RemoteDataManager
) : ExamContracts.Interactor {

    override fun getGroupedExamList(): Map<Date, List<Exam>> {
        return groupExamsByDate(remoteDataManager.getMockedExamList())
    }

    private fun groupExamsByDate(exams: ArrayList<Exam>): Map<Date, List<Exam>> {
        return exams.groupBy { it.date }
    }

}
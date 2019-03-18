package io.redspark.redstest.modules.exam.interactor

import io.redspark.redstest.models.ExamNode
import io.redspark.redstest.modules.exam.contracts.ExamContracts
import java.util.*

class ExamInteractor(
    private val remoteDataManager: ExamContracts.RemoteDataManager
) : ExamContracts.Interactor {

    override fun getRemoteExamList(): ArrayList<ExamNode> {
        return remoteDataManager.getMockedExamList()
    }

}
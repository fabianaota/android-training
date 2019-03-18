package io.redspark.redstest.modules.exam.contracts;

import io.redspark.redstest.models.ExamNode
import io.redspark.redstest.modules.exam.adapters.ExamAdapter
import io.redspark.redstest.network.response.ExamResponse
import java.util.*
import kotlin.collections.ArrayList

interface ExamContracts {

    interface View {
        fun setupRecyclerView(examAdapter: ExamAdapter)
    }

    interface Presenter {
        fun onModuleAssembled()
    }

    interface Router

    interface Interactor {
        fun getRemoteExamList(): ArrayList<ExamNode>
    }

    interface RemoteDataManager {
        fun getMockedExamList(): ArrayList<ExamNode>
    }

}
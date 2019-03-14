package io.redspark.redstest.modules.exam.contracts;

import io.redspark.redstest.models.Exam
import io.redspark.redstest.modules.exam.adapters.ExamParentAdapter
import java.util.*

interface ExamContracts {

    interface View {
        fun setupRecyclerView(examAdapter: ExamParentAdapter)
    }

    interface Presenter {
        fun onModuleAssembled()
    }

    interface Router

    interface Interactor {
        fun getGroupedExamList(): Map<Date, List<Exam>>
    }

    interface RemoteDataManager {
        fun getMockedExamList(): ArrayList<Exam>
    }

}
package io.redspark.redstest.modules.exam.presenter;

import androidx.lifecycle.ViewModel
import io.redspark.redstest.models.Exam
import io.redspark.redstest.modules.exam.adapters.ExamParentAdapter
import io.redspark.redstest.modules.exam.contracts.ExamContracts
import java.util.*

class ExamPresenter(
    private val view: ExamContracts.View,
    private val router: ExamContracts.Router,
    private val interactor: ExamContracts.Interactor
) : ViewModel(), ExamContracts.Presenter {

    private lateinit var examParentAdapter: ExamParentAdapter

    override fun onModuleAssembled() {
        val dateReportList = interactor.getGroupedExamList()
        examParentAdapter = ExamParentAdapter(dateReportList)
        view.setupRecyclerView(examParentAdapter)
        interactor.getGroupedExamList()
    }

}
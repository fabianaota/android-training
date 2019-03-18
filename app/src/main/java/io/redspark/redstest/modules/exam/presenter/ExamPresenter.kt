package io.redspark.redstest.modules.exam.presenter;

import androidx.lifecycle.ViewModel
import io.redspark.redstest.modules.exam.adapters.ExamAdapter
import io.redspark.redstest.modules.exam.contracts.ExamContracts

class ExamPresenter(
    private val view: ExamContracts.View,
    private val router: ExamContracts.Router,
    private val interactor: ExamContracts.Interactor
) : ViewModel(), ExamContracts.Presenter {

    private lateinit var examAdapter: ExamAdapter

    override fun onModuleAssembled() {
        val examList = interactor.getRemoteExamList()
        examAdapter = ExamAdapter(examList)
        view.setupRecyclerView(examAdapter)
    }

}
package io.redspark.redstest.modules.exam.view;

import androidx.recyclerview.widget.LinearLayoutManager
import io.redspark.redstest.R
import io.redspark.redstest.databinding.FragmentExamBinding
import io.redspark.redstest.models.Exam
import io.redspark.redstest.modules.exam.adapters.ExamParentAdapter
import io.redspark.redstest.modules.exam.contracts.ExamContracts
import io.redspark.redstest.modules.exam.router.ExamRouter
import io.redspark.redstest.modules.viper_plugin.utils.BaseFragment
import kotlinx.android.synthetic.main.fragment_exam.*
import java.util.*

class ExamFragment : BaseFragment<ExamContracts.Presenter, FragmentExamBinding>(
    R.layout.fragment_exam,
    ExamRouter.Assembler()
), ExamContracts.View {

    override fun setupRecyclerView(examAdapter: ExamParentAdapter) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = examAdapter

        }
    }

    override fun onModuleAssembled() {
        presenter.onModuleAssembled()
    }

}
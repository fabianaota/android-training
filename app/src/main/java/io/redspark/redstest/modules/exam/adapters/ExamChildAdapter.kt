package io.redspark.redstest.modules.exam.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection
import io.redspark.redstest.R
import io.redspark.redstest.models.Exam
import io.redspark.redstest.models.Result
import kotlinx.android.synthetic.main.cell_exam.view.*
import kotlinx.android.synthetic.main.cell_result.view.*

class ExamChildAdapter internal constructor(
    private var examType: Exam
) : StatelessSection(SectionParameters
    .Builder(R.layout.cell_result)
    .headerResourceId(R.layout.cell_exam)
    .build()) {

    override fun getContentItemsTotal(): Int = examType.results.count()

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
        return ResultViewHolder(view)
    }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val resultViewHolder = holder as ResultViewHolder
        resultViewHolder.bindItemView(examType.results[position])
    }

    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder = ExamViewHolder(view)

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
        val examViewHolder = holder as ExamViewHolder
        examViewHolder.bindHeaderView(examType)
    }

    inner class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindHeaderView(examType: Exam) {
            itemView.textViewExamName.text = examType.name
            itemView.textViewExamHour.text = examType.hour
            when {
                examType.type == 1 -> itemView.imageViewExamType.setImageResource(R.drawable.icon_type_1)
                examType.type == 2 -> itemView.imageViewExamType.setImageResource(R.drawable.icon_type_2)
            }
        }

    }

    inner class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItemView(examResult: Result) {
            itemView.textViewResultName.text = examResult.name
            itemView.textViewResultValue.text = examResult.value
            when {
                examResult.status == 1 -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_1)
                examResult.status == 2 -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_2)
                examResult.status == 3 -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_3)
            }
        }

    }

}
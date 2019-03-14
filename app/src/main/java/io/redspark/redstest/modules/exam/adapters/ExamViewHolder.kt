/**
 * TODO referência nula
 * package io.redspark.redstest.modules.exam.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.redspark.redstest.R
import kotlinx.android.synthetic.main.cell_exam.view.*

class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bindView(examType: ExamType) {
        itemView.textViewExamName.text = examType.name
        itemView.textViewExamHour.text = examType.hour.toString()
        if (examType.type == 1) {
            itemView.imageViewExamType.setImageResource(R.drawable.icon_type_1)
        } else if (examType.type == 2) {
            itemView.imageViewExamType.setImageResource(R.drawable.icon_type_2)
        }
    }

} **/
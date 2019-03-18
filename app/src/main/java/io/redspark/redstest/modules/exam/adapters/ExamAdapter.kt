package io.redspark.redstest.modules.exam.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.redspark.redstest.R
import io.redspark.redstest.enums.ExamType
import io.redspark.redstest.enums.NodeType
import io.redspark.redstest.enums.StatusType
import io.redspark.redstest.models.ExamNode
import kotlinx.android.synthetic.main.cell_date.view.*
import kotlinx.android.synthetic.main.cell_procedure.view.*
import kotlinx.android.synthetic.main.cell_result.view.*

class ExamAdapter(private val nodeList: ArrayList<ExamNode>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NodeType.DATE.viewType -> DateViewHolder(parent)
            NodeType.PROCEDURE.viewType -> ProcedureViewHolder(parent)
            NodeType.RESULT.viewType -> ResultViewHolder(parent)
            else -> throw IllegalArgumentException("Wrong type of node")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return nodeList[position].nodeType.viewType
    }

    override fun getItemCount(): Int {
        return nodeList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val node = nodeList[position]
        (holder as ExamViewHolder).bindItems(node)
    }

    abstract inner class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindItems(node: ExamNode)
    }

    inner class DateViewHolder(parent: ViewGroup) :
        ExamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_date, parent, false)) {
        override fun bindItems(node: ExamNode) {
            itemView.textViewExamDate.text = node.title
        }
    }

    inner class ProcedureViewHolder(parent: ViewGroup) :
        ExamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_procedure, parent, false)) {
        override fun bindItems(node: ExamNode) {
            itemView.textViewExamName.text = node.title
            itemView.textViewExamHour.text = node.subtitle
            when(node.examType) {
                ExamType.IMAGE -> itemView.imageViewExamType.setImageResource(R.drawable.icon_type_1)
                ExamType.LABORATORY -> itemView.imageViewExamType.setImageResource(R.drawable.icon_type_2)
                else -> itemView.imageViewExamType.setImageResource(R.drawable.icon_type_1)
            }
        }
    }

    inner class ResultViewHolder(parent: ViewGroup) :
        ExamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_result, parent, false)) {
        override fun bindItems(node: ExamNode) {
            itemView.textViewResultName.text = node.title
            itemView.textViewResultValue.text = node.subtitle
            when(node.statusType) {
                StatusType.GOOD -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_1)
                StatusType.MEDIUM -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_2)
                StatusType.BAD -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_3)
                else -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_1)
            }
        }
    }

}
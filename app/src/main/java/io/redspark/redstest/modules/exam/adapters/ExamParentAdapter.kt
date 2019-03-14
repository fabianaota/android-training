package io.redspark.redstest.modules.exam.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import io.redspark.redstest.R
import io.redspark.redstest.extensions.stringFormattedDate
import io.redspark.redstest.models.Exam
import kotlinx.android.synthetic.main.cell_date.view.*
import java.util.*

class ExamParentAdapter(
    private var dateReportList: Map<Date, List<Exam>>
) : RecyclerView.Adapter<ExamParentAdapter.DateViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    private val keys: List<Date>
    get() = dateReportList.keys.sorted()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_date, parent, false)
        return DateViewHolder(view)
    }

    override fun getItemCount(): Int = keys.count()

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val key = keys[position]
        val exams = dateReportList[key]

        val examChildAdapter = SectionedRecyclerViewAdapter()

        exams?.map {
            val adapterSectioned = ExamChildAdapter(it)
            examChildAdapter.addSection(adapterSectioned)
        }

        val examLayoutManager = LinearLayoutManager(holder.recyclerViewExamType.context, RecyclerView.VERTICAL, false)
        holder.textViewExamDate.text = key.stringFormattedDate("dd/MM/yyyy")
        holder.recyclerViewExamType.apply {
            layoutManager = examLayoutManager
            adapter = examChildAdapter
            setRecycledViewPool(viewPool)
        }
    }

    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewExamDate: TextView = itemView.textViewExamDate
        val recyclerViewExamType: RecyclerView = itemView.recyclerViewExamType
    }

}
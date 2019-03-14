/** TODO referência nula

package io.redspark.redstest.modules.exam.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.redspark.redstest.R
import kotlinx.android.synthetic.main.cell_result.view.*

class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(examResult: ExamResult) {
        itemView.textViewResultName.text = examResult.name
        itemView.textViewResultValue.text = examResult.value
        when {
            examResult.status == 1 -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_1)
            examResult.status == 2 -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_2)
            examResult.status == 3 -> itemView.imageViewResultStatus.setImageResource(R.drawable.icon_status_3)
        }
    }

} **/
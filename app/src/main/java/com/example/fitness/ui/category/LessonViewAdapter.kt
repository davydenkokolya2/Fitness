package com.example.fitness.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemLessonBinding
import com.example.fitness.domain.LessonCardModel

class LessonViewAdapter(
    data: List<LessonCardModel>,
    private val onClick: (Int, List<LessonCardModel>) -> Unit
) :
    RecyclerView.Adapter<LessonViewAdapter.CardViewHolder>() {
    private var list: List<LessonCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(
        val binding: ItemLessonBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLessonBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvLessonCardTitle.setText(item.title)
        holder.binding.tvLessonCardTime.setText(item.time)
        holder.binding.tvLessonCardWhere.setText(item.where)
        holder.binding.tvLessonCardDescription.setText(item.description)
        holder.binding.ivCardLessonImage.setImageResource(item.image)
        holder.binding.imageView6.setOnClickListener {
            onClick(position, list)
        }
    }
}


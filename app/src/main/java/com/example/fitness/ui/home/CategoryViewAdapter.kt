package com.example.fitness.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemCategoriesBinding
import com.example.fitness.domain.CategoryCardModel

class CategoryViewAdapter(
    data: List<CategoryCardModel>,
    private val onClick: (Int, List<CategoryCardModel>) -> Unit
) :
    RecyclerView.Adapter<CategoryViewAdapter.CardViewHolder>() {
    private var list: List<CategoryCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(
        val binding: ItemCategoriesBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoriesBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvCategoryCardTitle.setText(item.title)
        holder.binding.ivCategoryCard.setImageResource(item.image)
        holder.binding.ivCategoryCard.setOnClickListener {
            onClick(position, list)
        }
    }
}


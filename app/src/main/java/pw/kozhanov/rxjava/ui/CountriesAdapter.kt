package pw.kozhanov.rxjava.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pw.kozhanov.rxjava.data.model.entity.CountryEntity
import pw.kozhanov.rxjava.databinding.CountryItemBinding

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountryHolder>() {
    private val items = mutableListOf<CountryEntity>()

    fun updateList(newItems: List<CountryEntity>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return CountryHolder(
            CountryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    class CountryHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountryEntity) {
            binding.item = item
        }

    }
}
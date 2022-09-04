package kazak.kirill.shoplist1.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kazak.kirill.shoplist1.R
import kazak.kirill.shoplist1.domain.ShopItem

class ShopListAdapter(): RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>(){

    private val list = listOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        return ShopItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shop_item_enabled, parent, false))
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = list[position]
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    override fun getItemCount() = list.size

    class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_item_name)
        val tvCount: TextView = view.findViewById(R.id.tv_item_count)
    }
}
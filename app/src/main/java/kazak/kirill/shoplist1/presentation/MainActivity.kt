package kazak.kirill.shoplist1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kazak.kirill.shoplist1.R
import kazak.kirill.shoplist1.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    private lateinit var llShopItems: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        viewModel.shopList.observe(this) {
            showItem(it)
        }
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        llShopItems = findViewById(R.id.ll_shop_items)
    }

    private fun showItem(shopList: List<ShopItem>) {
        llShopItems.removeAllViews()
        for (shopItem in shopList) {
            val itemLayoutId = if (shopItem.enabled) {
                R.layout.shop_item_enabled
            } else {
                R.layout.shop_item_disabled
            }

            val newItem = LayoutInflater.from(this).inflate(itemLayoutId, llShopItems, false)
            newItem.findViewById<TextView>(R.id.tv_item_name).text = shopItem.name
            newItem.findViewById<TextView>(R.id.tv_item_count).text = shopItem.count.toString()

            newItem.setOnLongClickListener {
                viewModel.changeItemsEnabledState(shopItem)
                true
            }

            llShopItems.addView(newItem)
        }
    }
}
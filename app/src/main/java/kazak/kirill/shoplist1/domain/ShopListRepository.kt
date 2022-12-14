package kazak.kirill.shoplist1.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItemFromId(shopItemId: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
    fun removeShopItem(shopItem: ShopItem)
}
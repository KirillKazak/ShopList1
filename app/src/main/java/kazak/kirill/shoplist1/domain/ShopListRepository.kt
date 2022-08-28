package kazak.kirill.shoplist1.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItemFromId(shopItemId: Int): ShopItem
    fun getShopList(): List<ShopItem>
    fun removeShopItem(shopItem: ShopItem)
}
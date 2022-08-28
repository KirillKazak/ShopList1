package kazak.kirill.shoplist1.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItemFromIdUseCase(shopItemId: Int): ShopItem
    fun getShopList(): List<ShopItem>
    fun removeShopItem(shopItem: ShopItem)
}
package kazak.kirill.shoplist1.data

import kazak.kirill.shoplist1.domain.ShopItem
import kazak.kirill.shoplist1.domain.ShopItem.Companion.UNDEFINED_ID
import kazak.kirill.shoplist1.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItemFromId(shopItem.id)
        removeShopItem(oldShopItem)
        addShopItem(shopItem)
    }

    override fun getShopItemFromId(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Shop item with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }
}
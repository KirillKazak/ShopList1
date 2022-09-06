package kazak.kirill.shoplist1.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kazak.kirill.shoplist1.domain.ShopItem
import kazak.kirill.shoplist1.domain.ShopItem.Companion.UNDEFINED_ID
import kazak.kirill.shoplist1.domain.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })
    private var autoIncrementId = 0

    init {
        for (i in 0 until 1000) {
            addShopItem(ShopItem("Name $i", i, Random.nextBoolean()))
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}
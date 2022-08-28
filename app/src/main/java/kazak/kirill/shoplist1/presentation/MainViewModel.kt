package kazak.kirill.shoplist1.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kazak.kirill.shoplist1.data.ShopListRepositoryImpl
import kazak.kirill.shoplist1.domain.EditShopItemUseCase
import kazak.kirill.shoplist1.domain.GetShopListUseCase
import kazak.kirill.shoplist1.domain.RemoveShopItemUseCase
import kazak.kirill.shoplist1.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        shopList.value = getShopListUseCase.getShopList()
    }

    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeShopItem(shopItem)
        shopList.value = getShopListUseCase.getShopList()
    }

    fun editShopList(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        shopList.value = getShopListUseCase.getShopList()
    }
}
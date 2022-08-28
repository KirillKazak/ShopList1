package kazak.kirill.shoplist1.domain

class GetShopItemFromIdUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemFromIdUseCase(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemFromIdUseCase(shopItemId)
    }
}
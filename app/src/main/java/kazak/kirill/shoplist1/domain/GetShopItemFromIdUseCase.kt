package kazak.kirill.shoplist1.domain

class GetShopItemFromIdUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemFromId(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemFromId(shopItemId)
    }
}
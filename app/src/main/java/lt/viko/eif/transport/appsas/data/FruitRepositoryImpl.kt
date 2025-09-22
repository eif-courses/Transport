package lt.viko.eif.transport.appsas.data

class FruitRepositoryImpl : FruitRepository {

    val fruits = listOf("Orange", "Lemon", "Strawberry")

    override fun create() {
        println("PH: Fruit created")
    }
    override fun listFruits(): List<String> {
      return fruits
    }
}
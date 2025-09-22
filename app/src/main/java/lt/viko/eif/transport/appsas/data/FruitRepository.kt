package lt.viko.eif.transport.appsas.data

interface FruitRepository {
    fun create()
    fun listFruits() : List<String>
}
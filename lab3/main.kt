fun main() {
    val book = PhoneBook()

    val pavel = Contact(
        "Pavel",
        "Leyba",
        mutableListOf(
            Phone("+79604206969", PhoneType.MOBILE),
            Phone("88007002323", PhoneType.WORK)
        )
    )

    val rusakovv = Contact(
        "Артем",
        "Руски",
        mutableListOf(
            Phone("+7901342452", PhoneType.MOBILE),
            Phone("89112442131", PhoneType.HOME)
        )
    )

    book.add(pavel)
    book.add(rusakovv)

    println(book.find("Рус"))
    println(book.find("6"))

    pavel.surname = "Лейба блин"

    println(book)

    book.delete(pavel)

    println(book)

}
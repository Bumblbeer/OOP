package ru.etu.oop.lab3

data class Contact( var name: String, var surname: String,
                    private val phones: MutableList<Phone> = mutableListOf()
) {
    fun includes(string: String): Boolean {
        return name.contains(string) || surname.contains(string) ||
                phones.any { phone -> phone.number.contains(string) }
    }

    override fun toString(): String {
        return "$name $surname $phones"
    }
}
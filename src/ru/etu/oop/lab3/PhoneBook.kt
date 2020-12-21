package ru.etu.oop.lab3

class PhoneBook(private val contacts: MutableList<Contact> = mutableListOf()) {
    fun add(contact: Contact) {
        contacts.add(contact)
    }

    fun delete(contact: Contact) {
        contacts.remove(contact)
    }

    fun find(string: String): List<Contact> {
        val list = mutableListOf<Contact>()
        for (item in contacts) {
            if (item.includes(string)) { list.add(item) }
        }
        return list.toList()
    }

    override fun toString(): String {
        return contacts.joinToString("\n")
    }
}

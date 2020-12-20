enum class PhoneType { MOBILE, HOME, WORK }

class Phone( number: String, var type: PhoneType) {
    var number = number
        set(value) {
            if (!value.replace("-", "").matches("\\+?\\d+".toRegex()))
                throw IllegalArgumentException("Not a phone number")
            field = value.replace("-", "")
            if (type == PhoneType.MOBILE && value[0] != '+')
                field = "+$value"
        }
    override fun toString(): String {
        return number
    }
}

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

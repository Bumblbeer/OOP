package ru.etu.oop.lab3

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
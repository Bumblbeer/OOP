package ru.etu.oop.lab5

import com.google.gson.*
import ru.etu.oop.lab2.Shape
import java.lang.reflect.Type


class InterfaceAdapter<T> : JsonSerializer<T>, JsonDeserializer<T> {

    companion object {
        const val CLASSNAME = "CLASSNAME"
        const val DATA = "DATA"
    }

    // returns class by className
    private fun getObjectClass(className: String?): Class<*>? {
        return try {
            Class.forName(className)
        } catch (e: ClassNotFoundException) {
            throw JsonParseException(e.message)
        }
    }

    // Auxiliary function for serialize()
    private fun <T : Any> getJsonArray(src: T, context: JsonSerializationContext?) : JsonArray {
        val jsonArray = JsonArray()
        (src as MutableList<T>)::forEach {
            jsonArray.add(JsonObject().apply {
                addProperty(CLASSNAME, it::class.qualifiedName)
                add(DATA, context!!.serialize(it))
            })
        }
        return jsonArray
    }

    // Makes JSON Array from MutableList of Shapes
    override fun serialize(src: T, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return getJsonArray((src as MutableList<*>) , context)
    }

    // Makes MutableList of Shapes from JSON Array
    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): T {
        val jsonArray = json.asJsonArray
        val shapes = mutableListOf<Shape>()
        jsonArray.forEach {
            val jsonObject = it.asJsonObject
            val classByName = getObjectClass(jsonObject.get(CLASSNAME).asString)
            val data = jsonObject.get(DATA)
            shapes.add(context.deserialize(data, classByName))
        }

        return (shapes as T)
    }
}
package com.example.demo.backgroundData

class Remover {
    fun remover(originalExpression: String): String {
        var aux = originalExpression
        var cleanExpression: String

        cleanExpression = aux.replace("[()]".toRegex(), "")

        return cleanExpression
    }
}
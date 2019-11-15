package com.example.demo.backgroundData

import tornadofx.*
import java.util.*

class InfToSufix : Controller() {
    fun infToSufix(userInputExpression: String): String {
        var postfix: String = ""

        //Depurar la expresion algebraica
        val expr = depurar(userInputExpression)

        val arrayInfix = expr.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        //Declaración de las pilas
        val inputStack = Stack<String>() //Pila entrada
        val tempStack = Stack<String>() //Pila temporal para operadores
        val outputStack = Stack<String>() //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (i in arrayInfix.indices.reversed()) {
            inputStack.push(arrayInfix[i])
        }

        //Algoritmo Infijo a Postfijo
        try {
            while (!inputStack.isEmpty()) {
                when (hirearchy(inputStack.peek())) {
                    1 -> tempStack.push(inputStack.pop())
                    3, 4 -> {
                        while (hirearchy(tempStack.peek()) >= hirearchy(inputStack.peek())) {
                            outputStack.push(tempStack.pop())
                        }
                        tempStack.push(inputStack.pop())
                    }
                    2 -> {
                        while (tempStack.peek() != "(") {
                            outputStack.push(tempStack.pop())
                        }
                        tempStack.pop()
                        inputStack.pop()
                    }
                    else -> outputStack.push(inputStack.pop())
                }
            }

            //Eliminacion de espacios, parentesis, etc en la expresiones algebraicas
            postfix = outputStack.toString().replace("[]\\[,]".toRegex(), "")
            postfix = postfix.replace(" ".toRegex(), "")
        } catch (ex: Exception) {
            println("Error en la expresión algebraica")
            System.err.println(ex)
        }
        return postfix
    }

    //Depurar expresión algebraica
    private fun depurar(s: String): String {
        var inputString = s
        inputString = inputString.replace("\\s+".toRegex(), "") //Elimina espacios en blanco
        inputString = "($inputString)"
        val simbols = "+-*/()"
        var str = ""

        //Deja espacios entre operadores
        for (i in 0 until inputString.length) {
            if (simbols.contains("" + inputString[i])) {
                str += " " + inputString[i] + " "
            } else
                str += inputString[i]
        }
        return str.replace("\\s+".toRegex(), " ").trim { it <= ' ' }
    }

    //Jerarquia de los operadoLos cuadruplos son: ${eres
    private fun hirearchy(op: String): Int {
        var prf = 0
        if (op == "^") prf = 5
        if (op == "*" || op == "/") prf = 4
        if (op == "+" || op == "-") prf = 3
        if (op == ")") prf = 2
        if (op == "(") prf = 1
        return prf
    }
}

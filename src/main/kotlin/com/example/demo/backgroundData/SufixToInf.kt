package com.example.demo.backgroundData

import tornadofx.*
import java.util.*

class SufixToInf : Controller() {

    fun sufixToInf(sufixExpresion: String): String {
        val infija = Stack<Any>()
        val flippedExpressionStack = Stack<Any>()
        var flippedExpression = StringBuilder()
        val infExpression = StringBuilder()
        val size: Int
        var topElement: Char

        flippedExpression.append(sufixExpresion)
        flippedExpression = flippedExpression.reverse()
        size = flippedExpression.length

        //llenamos la pila
        for (i in 0 until size) {
            flippedExpressionStack.push(flippedExpression[i])
        }

        for (i in 0 until size) {
            topElement = flippedExpressionStack.peek() as Char
            if (topElement == '+' ||
                    topElement == '-' ||
                    topElement == '*' ||
                    topElement == '/' ||
                    topElement == '^') {

                //System.out.println("Element: " + topElement);
                val operando2 = infija.pop() as String
                //System.out.println("Operando 2: " + operando2);
                val operando1 = infija.pop() as String
                //System.out.println("Operando 1: " + operando1);
                val operador = flippedExpressionStack.pop() as Char
                //System.out.println("operador: " + operador);
                val infi = "" + operando1 + "" + operador + "" + operando2
                //System.out.println("Infi:" + infi);
                infija.push(infi)

            } else {
                infija.push(flippedExpressionStack.pop().toString())
            }
        }

        val iterator = infija.iterator()
        while (iterator.hasNext()) {
            infExpression.append(iterator.next())
        }

        return infExpression.toString()
    }
}

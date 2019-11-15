package com.example.demo.backgroundData

import java.util.*


class ToQuadruples {
    fun expressionToQuadruple(expression: String): String {

        val quad = Stack<Any>()
        var counter = 0
        val sufixExpressionChar = expression.toCharArray()
        val finalExpression: StringBuilder = StringBuilder()

        for (i in expression.indices) {
            if (sufixExpressionChar[i] == '+' ||
                    sufixExpressionChar[i] == '-' ||
                    sufixExpressionChar[i] == '*' ||
                    sufixExpressionChar[i] == '/' ||
                    sufixExpressionChar[i] == '^') {

                val argument2: String = quad.pop().toString()
                val argument1: String = quad.pop().toString()
                val operator: String = sufixExpressionChar[i].toString()

                counter++
                val tCounter = "T$counter"
                val quadruple = "\n $operator \t $argument1 \t $argument2 \t $tCounter"
                finalExpression.append(quadruple)
                quad.push(tCounter)

            } else {
                val argument: String = expression[i].toString()
                quad.push(argument)
            }
        }
        return finalExpression.toString()
    }
}
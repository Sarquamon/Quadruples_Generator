package com.example.demo.backgroundData

import tornadofx.*

class ExpressionController : Controller() {
    fun activities(originalExpression: String) {
        val remover = Remover()
        val infToSufix = InfToSufix()
        val sufixToInf = SufixToInf()
        val expressionToQuad = ToQuadruples()

        val cleanExpression = remover.remover(originalExpression)

        val quadruples: String

        //val h = "a-b+c*d/e*f-g+h"

        if (checkExpressionLastChar(cleanExpression)) {

            //RECIBO EXPRESION EN INFIJA
            quadruples = cleanExpression
            println("La expresion original es: $originalExpression")
            println("La expresion infija es: ${sufixToInf.sufixToInf(cleanExpression)}")

        } else {
            //RECIBO EXPRESION EN SUFIJA
            quadruples = infToSufix.infToSufix(originalExpression)
            println("La expresion original es: $originalExpression")
            println("La expresion sufija es: $quadruples")
        }

        println("Los cuadruplos son: ${expressionToQuad.expressionToQuadruple(quadruples)}")

    }

    private fun checkExpressionLastChar(cleanExpression: String): Boolean {

        val cleanExpressionLastChar = cleanExpression.lastIndex

        if (cleanExpression[cleanExpressionLastChar] == '-' ||
                cleanExpression[cleanExpressionLastChar] == '+' ||
                cleanExpression[cleanExpressionLastChar] == '*' ||
                cleanExpression[cleanExpressionLastChar] == '/' ||
                cleanExpression[cleanExpressionLastChar] == '^') {
            return true
        }
        return false
    }

}



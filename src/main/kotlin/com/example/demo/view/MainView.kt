package com.example.demo.view

import com.example.demo.backgroundData.ExpressionController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import tornadofx.*

class MainView : View("Proyecto 3") {
    val model = ViewModel()
    val originalExpression = model.bind { SimpleStringProperty() }
    val expressionController: ExpressionController by inject()

    override val root = form {
        fieldset(labelPosition = Orientation.VERTICAL) {
            fieldset("Expresión") {
                textfield(originalExpression)
            }

        }
        fieldset(labelPosition = Orientation.VERTICAL) {
            button("Iniciar") {
                hboxConstraints {
                    marginLeftRight(20.0)
                    marginBottom = 40.0
                }
                action {
                    runAsyncWithProgress {
                        expressionController.activities(originalExpression.value)
                    }
                }
            }
        }
    }
}
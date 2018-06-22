package com.learning

import javax.swing.Spring

class Rectangle(width:Int, height:Int){
   fun area():Int {
        return getWidth() * getHeight()
   }
}

/* extension function on String */
fun String.greet():String {
    return ("This is my extension function ${toString()}")
}
fun sum(a:Int,b:Int) = a+b

fun whenInExpn(obj:Any):String =  when(obj) {
        is String -> "Hello String"
        is Int -> "I am number"
        is Double -> "I am real"
        else -> "Unknown"
    }

fun usingRange() {
    for(x in 1..10) {
        println(x)
    }

    for(x in 10 downTo 1 step 2) {
        println(x)
    }

}

fun main(args:Array<String>) {
    println("hello".greet())

    val items = listOf(5,"Apple",9.8)
    items.forEach { println(whenInExpn(it)) }

    usingRange()

    val rect = Rectangle(23,45)



}
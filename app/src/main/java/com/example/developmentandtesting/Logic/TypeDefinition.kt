package com.example.developmentandtesting.Logic

fun defineTriangleType(a: Double, b: Double, c: Double): Int {
    // Проверка существования треугольника
    if (a <= 0 || b <= 0 || c <= 0) return -1
    if (a + b <= c || a + c <= b || b + c <= a) return -1

    return when {
        a == b && b == c -> 2 // равносторонний
        a == b || b == c || a == c -> 1 // равнобедренный
        else -> 0 // разносторонний
    }
}
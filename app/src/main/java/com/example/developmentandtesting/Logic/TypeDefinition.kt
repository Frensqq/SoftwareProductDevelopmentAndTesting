package com.example.developmentandtesting.Logic

sealed class TriangleResult {
    data class Success(val type: Int) : TriangleResult()
    data class Error(val title: String, val description: String) : TriangleResult()
}

fun defineTriangle(a: String, b: String, c: String): TriangleResult {

    val aD: Double
    val bD: Double
    val cD: Double

    try {
        aD = a.toDouble()
    } catch (e: Exception) {
        return TriangleResult.Error(
            "Ошибка ввода",
            "Сторона A должна быть числом"
        )
    }

    try {
        bD = b.toDouble()
    } catch (e: Exception) {
        return TriangleResult.Error(
            "Ошибка ввода",
            "Сторона B должна быть числом"
        )
    }

    try {
        cD = c.toDouble()
    } catch (e: Exception) {
        return TriangleResult.Error(
            "Ошибка ввода",
            "Сторона C должна быть числом"
        )
    }

    // ❌ Ноль или отрицательные
    if (aD <= 0 || bD <= 0 || cD <= 0) {
        return TriangleResult.Error(
            "Некорректные значения",
            "Все стороны должны быть больше 0"
        )
    }

    // ❌ Теорема треугольника
    if (aD + bD <= cD || aD + cD <= bD || bD + cD <= aD) {
        return TriangleResult.Error(
            "Треугольник не существует",
            "Сумма любых двух сторон должна быть больше третьей"
        )
    }

    // ✅ Определение типа
    val type = when {
        aD == bD && bD == cD -> 2
        aD == bD || bD == cD || aD == cD -> 1
        else -> 0
    }

    return TriangleResult.Success(type)
}
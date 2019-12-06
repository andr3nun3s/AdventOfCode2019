package aoc

import java.io.File

fun main() {
    val lines = File("resources/dayOne/input.txt").useLines {
        it.toList()
    }

    var part1Solution = 0
    var part2Solution = 0
    for (line in lines) {
        val mass = line.toInt()
        part1Solution += calculateFuelRequirement(mass)
        part2Solution += calculateRecursiveFuelRequirement(mass)
    }
    println("Part one solution: $part1Solution")
    println("Part two solution: $part2Solution")
}

fun calculateFuelRequirement(mass: Int): Int {
    val fuelReq = Math.floorDiv(mass, 3) - 2
    return if (fuelReq <= 0) {
        0
    } else {
        fuelReq
    }
}

fun calculateRecursiveFuelRequirement(mass: Int): Int {
    var sum = 0
    var fuelReq = calculateFuelRequirement(mass)
    do {
        sum += fuelReq
        fuelReq = calculateFuelRequirement(fuelReq)
    } while (fuelReq > 0)
    return sum
}



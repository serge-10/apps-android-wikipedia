package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.MatcherAssert
import org.hamcrest.TypeSafeMatcher
import java.util.List


internal enum class Color {
    RED, BLUE, GREEN, YELLOW, BLACK, WHITE
}

internal class Shape(var sideLength: Float,
                     var sides: Int,
                     var color: Color
)

// Matcher to check side length in a given range
internal class SideLengthInRangeMatcher(private val min: Float,
                                        private val max: Float
) :
    TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength >= min && shape.sideLength <= max
    }

    override fun describeTo(description: Description) {
        description.appendText("side length between $min and $max")
    }
}

// Matcher to check angles count
internal class ValidAnglesMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return if (shape.sides >= 3) {
            shape.sides == shape.sides
        } else {
            shape.sides == 1 || shape.sides == 2
        }
    }

    override fun describeTo(description: Description) {
        description.appendText("valid angles count based on sides")
    }
}

// Matcher to check even sides count
internal class EvenSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides % 2 == 0
    }

    override fun describeTo(description: Description) {
        description.appendText("even number of sides")
    }
}

// Matcher to check color
internal class ColorMatcher(private val expectedColor: Color) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == expectedColor
    }

    override fun describeTo(description: Description) {
        description.appendText("color $expectedColor")
    }
}

// Matcher to check non-negative side length
internal class NonNegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength >= 0
    }

    override fun describeTo(description: Description) {
        description.appendText("non-negative side length")
    }
}

// Matcher to check non-negative sides count
internal class NonNegativeSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides >= 0
    }

    override fun describeTo(description: Description) {
        description.appendText("non-negative sides count")
    }
}

// Test cases
object ShapeMatcherTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val shapes = List.of(
            Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
            Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
            Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
            Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
            Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
            Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
            Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
        )

        for (shape in shapes) {
            MatcherAssert.assertThat<Shape>(
                shape, Matchers.allOf<Shape>(
                    SideLengthInRangeMatcher(0.1f, 100.0f),
                    ValidAnglesMatcher(),
                    EvenSidesMatcher(),
                    NonNegativeSideLengthMatcher(),
                    NonNegativeSidesMatcher()
                )
            )
            println("Shape with sides " + shape.sides + " and length " + shape.sideLength + " passed all checks.")
        }
    }
}
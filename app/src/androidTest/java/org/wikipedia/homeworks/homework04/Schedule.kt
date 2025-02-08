package org.wikipedia.homeworks.homework04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {
    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    private var currentDay: Days? = null

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    operator fun String.rangeTo(other: String): Pair<LocalTime, LocalTime> {
        return LocalTime.parse(this, timeFormatter) to LocalTime.parse(other, timeFormatter)
    }

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
        currentDay?.let {
            addSchedule(it, ScheduleEntity(lesson, first, second))
        } ?: error("Day of the week is not set")
    }

    fun monday(block: () -> Unit) { currentDay = Days.MONDAY; block(); currentDay = null }
    fun tuesday(block: () -> Unit) { currentDay = Days.TUESDAY; block(); currentDay = null }
    fun wednesday(block: () -> Unit) { currentDay = Days.WEDNESDAY; block(); currentDay = null }
    fun thursday(block: () -> Unit) { currentDay = Days.THURSDAY; block(); currentDay = null }
    fun friday(block: () -> Unit) { currentDay = Days.FRIDAY; block(); currentDay = null }
    fun saturday(block: () -> Unit) { currentDay = Days.SATURDAY; block(); currentDay = null }
    fun sunday(block: () -> Unit) { currentDay = Days.SUNDAY; block(); currentDay = null }

    fun schedule(block: Schedule.() -> Unit) {
        this.block()
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(timeFormatter)
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }
}

fun main() {
    val schedule = Schedule()

    schedule.schedule {
        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
            "10:30".."11:10" schedule "Geography"
            "09:00".."09:40" schedule "Chemistry"
            "09:45".."10:25" schedule "English"
        }

        friday {
            "09:45".."10:25" schedule "Literature"
            "11:15".."11:55" schedule "History"
            "09:00".."09:40" schedule "Art"
            "10:30".."11:10" schedule "Mathematics"
        }
    }


            println(schedule)
}
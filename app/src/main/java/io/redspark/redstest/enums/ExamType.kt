package io.redspark.redstest.enums

enum class ExamType(val value: Int) {
    IMAGE(0),
    LABORATORY(1),
    NONE(2);

    companion object {
        fun from(findValue: Int): ExamType = ExamType.values().first {it.value == findValue}
    }

}
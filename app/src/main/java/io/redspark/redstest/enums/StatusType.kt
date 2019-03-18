package io.redspark.redstest.enums

enum class StatusType(val value: Int) {
    GOOD(0),
    MEDIUM(1),
    BAD(2),
    NONE(3);

    companion object {
        fun from(findValue: Int): StatusType = StatusType.values().first {it.value == findValue}
    }

}
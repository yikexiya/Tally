package com.yikexiya.tally.data

import java.util.*

class RecordType(
    val isExpense: Boolean,
    val icon: Int,
    val name: String,
    val id: String = UUID.randomUUID().toString()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecordType

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "RecordType(isExpense=$isExpense, name='$name')"
    }
}
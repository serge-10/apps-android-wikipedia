package org.wikipedia.homeworks.homework20

class NameHierarchy {
    val name: String
    val parent: NameHierarchy?

    constructor(name: String, parent: NameHierarchy? = null) {
        this.name = name
        this.parent = parent
    }

    fun withParent(currentElementName: String) = NameHierarchy(currentElementName, this)
    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }
}
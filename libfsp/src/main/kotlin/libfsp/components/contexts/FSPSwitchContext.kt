package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPSwitchContext<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructContext<Type>() {
    var FSPSwitchContext<Type>.case: FSPComponent<Type, *>
        get() = TODO("current task")
        set(task) {

        }
}
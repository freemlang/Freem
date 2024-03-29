package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class Constructor {
    companion object: FSPTypedComponent<Char, Constructor>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<Constructor> {
            AccessModifier.queue()
            ` `
            "constructor".queue()
            ` ?`
            Factor.queue()
            ` ?`
            CodeBlock.queue()

            return value { Constructor() }
        }
    }
}
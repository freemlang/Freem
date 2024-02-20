package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver
import libfsp.reference.FSPValue

class File private constructor(
    val `package`: Package,
    val imports: List<Package>,
    val functions: List<Function>,
    val classes: List<Class>
) {
    companion object: FSPTypedPattern<Char, File>() {
        override fun FSPPatternInitializeDispatchReceiver<Char>.initialize(): FSPValue<File> {
            `|?`

            next = const("package")
            ` `
            val `package`: FSPValue<Package>
            next = Package.also { `package` = it.fspvalue }

            `|`

            next = const("import")
            ` `
            val imports: FSPValue<List<Package>>
            next = Package.lazyRepeat(0, null).also { imports = it.fspvalue }

            `|`

            val classes = value { mutableListOf<Class>() }
            val functions = value { mutableListOf<Function>() }

            next = group {
                next = switch {
                    case = group {
                        val `class`: FSPValue<Class>
                        next = Class.also { `class` = it.fspvalue }
                        task { classes.value.add(`class`.value) }
                    }
                    case = group {
                        val function: FSPValue<Function>
                        next = Function.also { function = it.fspvalue }
                        task { functions.value.add(function.value) }
                    }
                }
                `|?`
            }

            return value {
                File(
                    `package` = `package`.value,
                    imports = imports.value,
                    functions = functions.value,
                    classes = classes.value
                )
            }
        }
    }
}

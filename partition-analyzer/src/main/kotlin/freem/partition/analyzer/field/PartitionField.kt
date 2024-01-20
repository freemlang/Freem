package freem.partition.analyzer.field

import freem.partition.analyzer.field.value.*
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper

class PartitionField internal constructor(tasks: MutableList<AnyAnalyzeTaskWrapper>) {
    val add = AnalyzeTaskRegistrationObject(tasks)
    val unit = UnitPartitionValue

    fun <Type> newValue(): PartitionValue<Type> = VoidPartitionValue()
    fun <Type> newValue(value: PartitionValueGettableField.() -> Type): PartitionValue<Type> = LambdaPartitionValue(value)

    fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}


package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.Partition
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class PartitionTask<ReturnType>(private val partition: Partition<ReturnType>): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        TODO("Not yet implemented")
    }
}
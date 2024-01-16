package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Factor {
    companion object: Partition<Factor>() {
        override fun PartitionField.initialize(): Future<Factor> {
            add static '('
            add static ')'

            return FutureTask { Factor() }
        }
    }
}
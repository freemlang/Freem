package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.UnitFuture
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

val ` ` = WhiteSpace
val ` ?` = WhiteSpaceAble

object WhiteSpace: Partition<Unit>() {
    override fun PartitionField.initialize(): Future<Unit> {
        add switch {
            add custom Char::isWhitespace repeatMin 1
            add partition Comment
        }

        return UnitFuture
    }
}

object WhiteSpaceAble: Partition<Unit>() {
    override fun PartitionField.initialize(): Future<Unit> {
        add partition WhiteSpace optional true

        return UnitFuture
    }
}
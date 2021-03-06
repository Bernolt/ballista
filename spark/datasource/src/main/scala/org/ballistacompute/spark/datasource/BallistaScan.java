package org.ballistacompute.spark.datasource;

import org.apache.spark.sql.connector.read.Batch;
import org.apache.spark.sql.connector.read.Scan;
import org.apache.spark.sql.connector.read.streaming.ContinuousStream;
import org.apache.spark.sql.connector.read.streaming.MicroBatchStream;
import org.apache.spark.sql.types.StructType;

public class BallistaScan implements Scan {

  TableMeta tableMeta;

  public BallistaScan(TableMeta tableMeta) {
    this.tableMeta = tableMeta;
  }

  @Override
  public StructType readSchema() {
    return tableMeta.schema;
  }

  @Override
  public String description() {
    return tableMeta.tableName;
  }

  @Override
  public Batch toBatch() {
    return new BallistaBatch(tableMeta);
  }

  @Override
  public MicroBatchStream toMicroBatchStream(String checkpointLocation) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ContinuousStream toContinuousStream(String checkpointLocation) {
    throw new UnsupportedOperationException();
  }
}

package com.xjeffrose.chicago;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;
import org.rocksdb.WriteBatch;

public class DefaultChicagoMessage implements ChicagoMessage {
  private final Op _op;
  private final byte[] colFam;
  private final byte[] key;
  private final byte[] val;
  private DecoderResult decoderResult;

  public DefaultChicagoMessage(Op _op, byte[] colFam, byte[] key, byte[] val) {
    this._op = _op;
    this.colFam = colFam;
    this.key = key;
    this.val = val;
  }

  public ByteBuf encode() {
    return Unpooled.directBuffer().writeBytes(new ChicagoObjectEncoder().encode(_op, colFam, key, val));
  }

  @Override
  public DecoderResult decoderResult() {
    return decoderResult;
  }

  @Override
  public void setDecoderResult(DecoderResult decoderResult) {
    this.decoderResult = decoderResult;
  }

  @Override
  public Op getOp() {
    return _op;
  }

  @Override
  public byte[] getKey() {
    return key;
  }

  @Override
  public byte[] getVal() {
    return val;
  }

  @Override
  public boolean getSuccess() {
    return true;
  }

  @Override
  public byte[] getColFam() {
    return colFam;
  }
}

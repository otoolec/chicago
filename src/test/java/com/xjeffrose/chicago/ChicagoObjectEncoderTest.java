package com.xjeffrose.chicago;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChicagoObjectEncoderTest {
  ChicagoObjectEncoder encoder = new ChicagoObjectEncoder();
  ChicagoObjectDecoder decoder = new ChicagoObjectDecoder();

  @Test
  public void encode1() throws Exception {
    byte[] result = encoder.encode(Op.fromInt(0), "foo".getBytes(), "asdfgjlkasdf".getBytes());

    ChicagoMessage message = decoder.decode(result);

    assertEquals(Op.READ, message.getOp());
    assertEquals("foo", new String(message.getKey()));
    assertEquals("asdfgjlkasdf", new String(message.getVal()));
  }


  @Test
  public void encode() throws Exception {
//    encoder.encode(null, );
  }

}
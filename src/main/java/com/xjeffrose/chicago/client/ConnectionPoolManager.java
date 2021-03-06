package com.xjeffrose.chicago.client;

import com.google.common.util.concurrent.ListenableFuture;
import com.xjeffrose.chicago.ChicagoMessage;

public interface ConnectionPoolManager {

  ListenableFuture<Boolean> write(String addr, ChicagoMessage msg);

  void start();
}

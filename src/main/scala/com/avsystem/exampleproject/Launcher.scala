package com.avsystem.exampleproject

import com.avsystem.exampleproject.apiImpl.MainApiImpl
import com.avsystem.exampleproject.server.HttpServer


object Launcher extends App {

  val daosWrapper = DaosWrapper.daosWrapper

  val server = new HttpServer(new MainApiImpl(daosWrapper))
  server.start()
}

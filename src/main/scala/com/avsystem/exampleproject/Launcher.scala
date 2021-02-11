package com.avsystem.exampleproject

import com.avsystem.exampleproject.apiImpl.MainApiImpl
import com.avsystem.exampleproject.db.MongoClientProvider
import com.avsystem.exampleproject.server.HttpServer

object Launcher extends App {

  val mongoClientProvider = new MongoClientProvider
  val daosWrapper = new DaosWrapper(mongoClientProvider)
  val server = new HttpServer(new MainApiImpl(daosWrapper))
  server.start()
}

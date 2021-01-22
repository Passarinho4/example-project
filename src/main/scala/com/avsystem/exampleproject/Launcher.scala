package com.avsystem.exampleproject

import com.avsystem.exampleproject.apiImpl.MainApiImpl
import com.avsystem.exampleproject.backend.token.TokenService
import com.avsystem.exampleproject.backend.utils.DbInitializer
import com.avsystem.exampleproject.server.HttpServer


object Launcher extends App {

  val daosWrapper = DaosWrapper.daosWrapper
  DbInitializer.initializeUser(daosWrapper.userDao)
  val tokenService = new TokenService

  val server = new HttpServer(new MainApiImpl(daosWrapper, tokenService))
  server.start()
}

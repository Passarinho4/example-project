package com.avsystem.exampleproject

import com.avsystem.exampleproject.api.MainApi
import com.avsystem.exampleproject.apiImpl.MainApiImpl
import com.avsystem.exampleproject.backend.token.TokenService
import com.avsystem.exampleproject.backend.utils.DbInitializer
import com.avsystem.exampleproject.cors.CorsRestWrapper
import io.udash.rest.RestServlet
import org.eclipse.jetty.http.HttpVersion
import org.eclipse.jetty.server.handler.HandlerList
import org.eclipse.jetty.server._
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.eclipse.jetty.util.ssl.SslContextFactory


object Launcher extends App {

  val daosWrapper = DaosWrapper.daosWrapper
  DbInitializer.initializeUser(daosWrapper.userDao)
  val tokenService = new TokenService

  val server = new Server()
  val httpConfiguration = new HttpConfiguration()
  httpConfiguration.setSecureScheme("https")
  httpConfiguration.setSecurePort(9090)

  val serverConnector = new ServerConnector(server, new HttpConnectionFactory(httpConfiguration))
  serverConnector.setPort(9090)
  serverConnector.setHost("0.0.0.0")
  server.addConnector(serverConnector)

  val contextFactory = new SslContextFactory.Server()
  contextFactory.setKeyStorePath("mykeystore.jks")
  contextFactory.setKeyStorePassword("123456")
  val httpsConfiguration = new HttpConfiguration(httpConfiguration)
  httpsConfiguration.addCustomizer(new SecureRequestCustomizer())
  val httpsConnector = new ServerConnector(server,
    new SslConnectionFactory(contextFactory, HttpVersion.HTTP_1_1.asString()),
    new HttpConnectionFactory(httpsConfiguration))
  httpsConnector.setPort(9091)
  httpsConnector.setHost("0.0.0.0")
  server.addConnector(httpsConnector)

  val handler = new ServletContextHandler()
  val servlet: RestServlet = RestServlet[MainApi](new MainApiImpl(daosWrapper, tokenService))
  handler.addServlet(new ServletHolder(servlet), "/*")
  val list = new HandlerList(new CorsRestWrapper(), handler)
  server.setHandler(list)
  server.start()
  server.join()


}

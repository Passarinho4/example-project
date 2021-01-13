package com.avsystem.exampleproject.cors

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.handler.AbstractHandler

class CorsRestWrapper extends AbstractHandler {
  override def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse): Unit = {
    response.addHeader("Access-Control-Allow-Origin", "*")
    response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS")
    response.setHeader("Access-Control-Allow-Headers",
      "content-type, Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, Origin, Accept, X-AUTH-TOKEN")
    response.setHeader("Access-Control-Request-Headers",
      "content-type, Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, Origin, Accept, X-AUTH-TOKEN")

    if (request.getMethod == "OPTIONS") {
      response.setStatus(200)
      baseRequest.setHandled(true)
    }
  }
}

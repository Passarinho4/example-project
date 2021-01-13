package com.avsystem.exampleproject.backend.token

import java.util
import java.util.UUID

import com.avsystem.exampleproject.backend.user.User

class TokenService {
  val tokens = new util.HashMap[String, String]()

  def generateTokenFor(m: User): String = {
    val token = UUID.randomUUID().toString
    tokens.put(m.login, token)
    token
  }

  def checkToken(token: String): Boolean = {
    tokens.values().contains(token)
  }

}

package com.avsystem.exampleproject.backend.user

import com.avsystem.exampleproject.backend.token.TokenService
import monix.eval.Task

class UserService(userDao: UserDao, tokenService: TokenService) {

  def generateToken(login: String, password: String): Task[Option[String]] = {
    for { user <- userDao.getByLogin(login) } yield {
      user.filter(_.password == password)
        .map(m => tokenService.generateTokenFor(m))
    }
  }

  def checkToken(token: String): Boolean = {
    tokenService.checkToken(token)
  }

}

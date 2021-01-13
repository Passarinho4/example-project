package com.avsystem.exampleproject.apiImpl.user

import com.avsystem.exampleproject.api.user.{UserApi, UserProtectedApi}
import com.avsystem.exampleproject.backend.user.UserService
import monix.eval.Task

class UserApiImpl(userService: UserService) extends UserApi {

  override def login(login: String, password: String): Task[Option[String]] = {
    userService.generateToken(login, password)
      .map {
        case None => throw new IllegalArgumentException("User does not exists")
        case s => s
      }
  }

  override def protectedApi(token: String): UserProtectedApi = {
    if(userService.checkToken(token)) {
      new UserProtectedApiImpl()
    } else {
      throw new IllegalArgumentException("Wrong token")
    }
  }
}

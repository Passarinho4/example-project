package com.avsystem.exampleproject.apiImpl

import com.avsystem.exampleproject.DaosWrapper
import com.avsystem.exampleproject.api.MainApi
import com.avsystem.exampleproject.api.user.UserApi
import com.avsystem.exampleproject.apiImpl.user.UserApiImpl
import com.avsystem.exampleproject.backend.token.TokenService
import com.avsystem.exampleproject.backend.user.UserService
import monix.eval.Task

class MainApiImpl(daosWrapper: DaosWrapper, tokenService: TokenService) extends MainApi {

  override def healthCheck: Task[String] = Task.now("ok")

  override def userApi: UserApi = new UserApiImpl(
    new UserService(daosWrapper.userDao, tokenService))

}

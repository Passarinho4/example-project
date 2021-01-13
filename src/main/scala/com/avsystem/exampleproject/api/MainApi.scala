package com.avsystem.exampleproject.api

import com.avsystem.exampleproject.api.user.UserApi
import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import monix.eval.Task

trait MainApi {

  def healthCheck: Task[String]

  def userApi: UserApi

}
object MainApi extends MonixRestApiCompanion[MainApi]

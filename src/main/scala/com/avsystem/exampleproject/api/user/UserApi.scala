package com.avsystem.exampleproject.api.user

import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import io.udash.rest.{Body, Header}
import monix.eval.Task

trait UserApi {
  def login(@Body login: String, @Body password: String): Task[Option[String]]
  def protectedApi(@Header("Authorization") token: String): UserProtectedApi
}

object UserApi extends MonixRestApiCompanion[UserApi]

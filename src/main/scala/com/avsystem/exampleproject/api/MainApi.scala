package com.avsystem.exampleproject.api

import com.avsystem.exampleproject.api.user.UserActivityApi
import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import io.udash.rest.{GET, Prefix}
import monix.eval.Task

trait MainApi {

  @GET
  def healthCheck: Task[String]

  @Prefix("activities")
  def userApi: UserActivityApi

}
object MainApi extends MonixRestApiCompanion[MainApi]

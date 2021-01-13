package com.avsystem.exampleproject.api.user

import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import monix.eval.Task

trait UserProtectedApi {

  def test(): Task[String]

}
object UserProtectedApi extends MonixRestApiCompanion[UserProtectedApi]

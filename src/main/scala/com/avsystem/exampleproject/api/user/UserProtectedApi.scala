package com.avsystem.exampleproject.api.device

import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import monix.eval.Task

trait DeviceProtectedApi {

  def test(): Task[String]

}
object DeviceProtectedApi extends MonixRestApiCompanion[DeviceProtectedApi]

package com.avsystem.exampleproject.apiImpl.device

import com.avsystem.exampleproject.api.device.DeviceProtectedApi
import monix.eval.Task

class DeviceProtectedApiImpl() extends DeviceProtectedApi {
  override def test(): Task[String] = Task.now("protected string ")
}

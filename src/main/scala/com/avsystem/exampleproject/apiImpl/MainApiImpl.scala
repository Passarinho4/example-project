package com.avsystem.exampleproject.apiImpl

import com.avsystem.exampleproject.DaosWrapper
import com.avsystem.exampleproject.api.MainApi
import com.avsystem.exampleproject.api.device.DeviceActivityApi
import com.avsystem.exampleproject.apiImpl.device.DeviceActivityApiImpl
import com.avsystem.exampleproject.backend.activity.DeviceActivityService
import monix.eval.Task

class MainApiImpl(daosWrapper: DaosWrapper) extends MainApi {

  override def healthCheck: Task[String] = Task.now("ok")

  override def deviceApi: DeviceActivityApi = new DeviceActivityApiImpl(
    new DeviceActivityService(daosWrapper.deviceActivityDao))

}

package com.avsystem.exampleproject.apiImpl.device

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.device.{DeviceActivityApi, DeviceActivityLogDto}
import com.avsystem.exampleproject.backend.activity.{DeviceActivity, DeviceActivityService}
import monix.eval.Task

class DeviceActivityApiImpl(deviceService: DeviceActivityService) extends DeviceActivityApi {
  override def logActivity(device: String, activity: DeviceActivity, timestamp: Timestamp): Task[Unit] = {
    deviceService.logActivity(device, activity, timestamp)
  }

  override def getDeviceActivities(device: String): Task[List[DeviceActivityLogDto]] = {
    deviceService.getDeviceActivities(device).map(_.map(_.toDto))
  }

  override def purge(): Task[Unit] = deviceService.removeAll()

  // TODO
  override def uniqueActivities(device: String, from: Timestamp, to: Timestamp): Task[Long] = ???
}

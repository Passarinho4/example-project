package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.misc.Timestamp
import monix.eval.Task
import org.bson.types.ObjectId

class DeviceActivityService(deviceActivityDao: DeviceActivityDao) {
  def getDeviceActivities(device: String): Task[List[DeviceActivityLog]] = {
    deviceActivityDao.findBy(device)
  }

  def logActivity(device: String, activity: DeviceActivity, timestamp: Timestamp): Task[Unit] = {
    deviceActivityDao.insert(
      DeviceActivityLog(new ObjectId(), device, activity, timestamp)
    )
  }

  def removeAll(): Task[Unit] = deviceActivityDao.removeAll()
}

package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.misc.Timestamp
import com.avsystem.commons.mongo.typed.{MongoEntity, MongoEntityCompanion}
import com.avsystem.exampleproject.api.device.DeviceActivityLogDto
import org.bson.types.ObjectId

case class DeviceActivityLog(
                            id: ObjectId,
                            device: String,
                            activity: DeviceActivity,
                            time: Timestamp
                          ) extends MongoEntity[ObjectId] {
  def toDto: DeviceActivityLogDto = DeviceActivityLogDto(device, activity, time)
}

object DeviceActivityLog extends MongoEntityCompanion[DeviceActivityLog]

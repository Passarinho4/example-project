package com.avsystem.exampleproject.api.device

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.backend.activity.DeviceActivity
import io.udash.rest.RestDataCompanion

case class DeviceActivityLogDto(device: String, activity: DeviceActivity, time: Timestamp)
object DeviceActivityLogDto extends RestDataCompanion[DeviceActivityLogDto]


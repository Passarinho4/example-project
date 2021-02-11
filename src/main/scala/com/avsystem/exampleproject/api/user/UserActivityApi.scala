package com.avsystem.exampleproject.api.device

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import com.avsystem.exampleproject.backend.activity.DeviceActivity
import io.udash.rest.{GET, POST, Path}
import monix.eval.Task

trait DeviceActivityApi {

  @POST(path = "purge")
  def purge(): Task[Unit]

  @GET(path = "")
  def getDeviceActivities(@Path device: String): Task[List[DeviceActivityLogDto]]

  @POST(path = "")
  def logActivity(device: String, activity: DeviceActivity, timestamp: Timestamp): Task[Unit]

  @POST("uniqueCount")
  def uniqueActivities(device: String, from: Timestamp, to: Timestamp): Task[Long]
}

object DeviceActivityApi extends MonixRestApiCompanion[DeviceActivityApi]

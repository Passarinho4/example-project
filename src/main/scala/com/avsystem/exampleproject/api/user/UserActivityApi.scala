package com.avsystem.exampleproject.api.user

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import com.avsystem.exampleproject.backend.activity.UserActivity
import io.udash.rest.{GET, POST, Path}
import monix.eval.Task

trait UserActivityApi {

  @POST(path = "purge")
  def purge(): Task[Unit]

  @GET(path = "")
  def getUserActivities(@Path user: String): Task[List[UserActivityLogDto]]

  @POST(path = "")
  def logActivity(user: String, activity: UserActivity, timestamp: Timestamp): Task[Unit]

  @POST("uniqueCount")
  def uniqueActivities(user: String, from: Timestamp, to: Timestamp): Task[Long]
}

object UserActivityApi extends MonixRestApiCompanion[UserActivityApi]

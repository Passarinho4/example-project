package com.avsystem.exampleproject.api.user

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.monixUtils.MonixRestApiCompanion
import com.avsystem.exampleproject.backend.activity.UserActivity
import io.udash.rest.POST
import monix.eval.Task

trait UserActivityApi {

  @POST
  def logActivity(user: String, activity: UserActivity, timestamp: Timestamp): Task[Unit]
}

object UserActivityApi extends MonixRestApiCompanion[UserActivityApi]

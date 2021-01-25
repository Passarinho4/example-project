package com.avsystem.exampleproject.apiImpl.user

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.user.UserActivityApi
import com.avsystem.exampleproject.backend.activity.{UserActivity, UserActivityService}
import monix.eval.Task

class UserActivityApiImpl(userService: UserActivityService) extends UserActivityApi {
  override def logActivity(user: String, activity: UserActivity, timestamp: Timestamp): Task[Unit] = {
    userService.logActivity(user, activity, timestamp)
  }
}

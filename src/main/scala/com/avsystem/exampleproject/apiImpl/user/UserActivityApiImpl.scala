package com.avsystem.exampleproject.apiImpl.user

import com.avsystem.commons.misc.Timestamp
import com.avsystem.commons.serialization.json.JsonStringOutput
import com.avsystem.exampleproject.api.user.{UserActivityApi, UserActivityLogDto}
import com.avsystem.exampleproject.backend.activity.{UserActivity, UserActivityLog, UserActivityService}
import monix.eval.Task

class UserActivityApiImpl(userService: UserActivityService) extends UserActivityApi {
  override def logActivity(user: String, activity: UserActivity, timestamp: Timestamp): Task[Unit] = {
    userService.logActivity(user, activity, timestamp)
  }

  override def getUserActivities(user: String): Task[List[UserActivityLogDto]] = {
    userService.getUserActivities(user).map(_.map(_.toDto))
  }

  override def purge(): Task[Unit] = userService.removeAll()

  // TODO
  override def uniqueActivities(user: String, from: Timestamp, to: Timestamp): Task[Long] = ???
}

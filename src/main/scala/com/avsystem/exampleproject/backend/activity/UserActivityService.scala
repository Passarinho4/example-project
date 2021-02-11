package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.misc.Timestamp
import monix.eval.Task
import org.bson.types.ObjectId

class UserActivityService(userActivityDao: UserActivityDao) {
  def getUserActivities(user: String): Task[List[UserActivityLog]] = {
    userActivityDao.findBy(user)
  }

  def logActivity(user: String, activity: UserActivity, timestamp: Timestamp): Task[Unit] = {
    userActivityDao.insert(
      UserActivityLog(new ObjectId(), user, activity, timestamp)
    )
  }

  def removeAll(): Task[Unit] = userActivityDao.removeAll()
}

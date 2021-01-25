package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.misc.Timestamp
import monix.eval.Task
import org.bson.types.ObjectId

class UserActivityService(userACtivityDao: UserActivityDao) {

  def logActivity(user: String, activity: UserActivity, timestamp: Timestamp): Task[Unit] = {
    userACtivityDao.insert(
      UserActivityLog(new ObjectId(), user, activity, timestamp)
    )
  }

}

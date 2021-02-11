package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.misc.Timestamp
import com.avsystem.commons.mongo.typed.{MongoEntity, MongoEntityCompanion}
import com.avsystem.exampleproject.api.user.UserActivityLogDto
import org.bson.types.ObjectId

case class UserActivityLog(
                            id: ObjectId,
                            user: String,
                            activity: UserActivity,
                            time: Timestamp
                          ) extends MongoEntity[ObjectId] {
  def toDto: UserActivityLogDto = UserActivityLogDto(user, activity, time)
}

object UserActivityLog extends MongoEntityCompanion[UserActivityLog]

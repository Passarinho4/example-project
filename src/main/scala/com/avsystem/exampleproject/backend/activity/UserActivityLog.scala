package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.misc.Timestamp
import com.avsystem.commons.mongo.typed.{MongoEntity, MongoEntityCompanion}
import org.bson.types.ObjectId

case class UserActivityLog(
                            id: ObjectId,
                            user: String,
                            activity: UserActivity,
                            time: Timestamp
                          ) extends MongoEntity[ObjectId] {}

object UserActivityLog extends MongoEntityCompanion[UserActivityLog]

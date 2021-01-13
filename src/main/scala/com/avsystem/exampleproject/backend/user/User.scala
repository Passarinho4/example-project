package com.avsystem.exampleproject.backend.user

import com.avsystem.commons.mongo.typed.{MongoEntity, MongoEntityCompanion}
import org.bson.types.ObjectId

case class User(
                  id: ObjectId,
                  login: String,
                  password: String
                  ) extends MongoEntity[ObjectId] {}
object User extends MongoEntityCompanion[User]

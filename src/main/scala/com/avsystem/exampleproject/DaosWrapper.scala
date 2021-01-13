package com.avsystem.exampleproject

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.user.{UserDao, User}
import com.mongodb.reactivestreams.client.MongoClients


case class DaosWrapper(userDao: UserDao)

object DaosWrapper {
  val client = MongoClients.create()

  val daosWrapper = new DaosWrapper(
    new UserDao(new TypedMongoCollection[User](client.getDatabase("example").getCollection("user"))),
  )
}

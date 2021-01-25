package com.avsystem.exampleproject

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.activity.{UserActivityLog, UserActivityDao}
import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}


case class DaosWrapper(userActivityDao: UserActivityDao)

object DaosWrapper {
  val client: MongoClient = MongoClients.create()

  val daosWrapper: DaosWrapper = new DaosWrapper(
    new UserActivityDao(new TypedMongoCollection[UserActivityLog](client.getDatabase("example").getCollection("user"))),
  )
}

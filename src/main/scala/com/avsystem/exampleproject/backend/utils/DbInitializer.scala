package com.avsystem.exampleproject.backend.utils

import com.avsystem.exampleproject.backend.user.{User, UserDao}
import com.typesafe.scalalogging.LazyLogging
import org.bson.types.ObjectId
import monix.execution.Scheduler.Implicits.global


object DbInitializer extends LazyLogging {

  def initializeUser(dao: UserDao): Unit = {
    for {isEmpty <- dao.isEmpty} {
      if (isEmpty) {
        dao.insert(User(ObjectId.get(), "Admin", "Admin123"))
          .foreach(_ => logger.info("Inserted Admin.."))
      }
    }
  }

}

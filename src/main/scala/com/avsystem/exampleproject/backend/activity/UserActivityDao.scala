package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.mongo.typed.{MongoFilter, TypedMongoCollection}
import com.avsystem.exampleproject.backend.utils.DaoUtils
import monix.eval.Task

class UserActivityDao(collection: TypedMongoCollection[UserActivityLog]) extends DaoUtils {

  def insert(user: UserActivityLog): Task[Unit] = collection.insertOne(user).unit()

  def findBy(user: String): Task[List[UserActivityLog]] = collection.find(
    UserActivityLog.ref(_.user) === user
  ).toListL

  def isEmpty: Task[Boolean] = collection.find().isEmptyL

  def removeAll(): Task[Unit] = collection.deleteMany(MongoFilter.Empty()).map(_ => ())

}

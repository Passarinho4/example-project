package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.utils.DaoUtils
import monix.eval.Task

class UserActivityDao(collection: TypedMongoCollection[UserActivityLog]) extends DaoUtils {

  def insert(user: UserActivityLog): Task[Unit] = collection.insertOne(user).unit()

  def isEmpty: Task[Boolean] = collection.find().isEmptyL

}

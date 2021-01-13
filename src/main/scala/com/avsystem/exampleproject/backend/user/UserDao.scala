package com.avsystem.exampleproject.backend.user

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.utils.DaoUtils
import monix.eval.Task

class UserDao(collection: TypedMongoCollection[User]) extends DaoUtils {

  def insert(user: User): Task[Unit] = collection.insertOne(user).unit()

  def isEmpty: Task[Boolean] = collection.find().isEmptyL

  def getByLogin(login: String): Task[Option[User]] = collection.findOne(User.ref(_.login) is login)

}

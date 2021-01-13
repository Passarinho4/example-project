package com.avsystem.exampleproject.apiImpl.user

import com.avsystem.exampleproject.api.user.UserProtectedApi
import monix.eval.Task

class UserProtectedApiImpl() extends UserProtectedApi {
  override def test(): Task[String] = Task.now("protected string ")
}

package com.avsystem.exampleproject.apiImpl

import com.avsystem.exampleproject.DaosWrapper
import com.avsystem.exampleproject.api.MainApi
import com.avsystem.exampleproject.api.user.UserActivityApi
import com.avsystem.exampleproject.apiImpl.user.UserActivityApiImpl
import com.avsystem.exampleproject.backend.activity.UserActivityService
import monix.eval.Task

class MainApiImpl(daosWrapper: DaosWrapper) extends MainApi {

  override def healthCheck: Task[String] = Task.now("ok")

  override def userApi: UserActivityApi = new UserActivityApiImpl(
    new UserActivityService(daosWrapper.userActivityDao))

}

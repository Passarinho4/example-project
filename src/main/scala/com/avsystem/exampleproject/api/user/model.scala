package com.avsystem.exampleproject.api.user

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.backend.activity.UserActivity
import io.udash.rest.RestDataCompanion

case class UserActivityLogDto(user: String, activity: UserActivity, time: Timestamp)
object UserActivityLogDto extends RestDataCompanion[UserActivityLogDto]


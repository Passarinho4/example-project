package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.ISeq
import com.avsystem.commons.misc.{AutoNamedEnum, NamedEnumCompanion}

sealed trait UserActivity extends AutoNamedEnum {
  def name: String
}

object UserActivity extends NamedEnumCompanion[UserActivity] {
  case object Login
  case object Logout

  override val values: ISeq[UserActivity] = caseObjects
}

package com.ing.airquality.ui.measurement

import com.ing.airquality.domain.model.Measurement

sealed class LoadingState

class InitialState : LoadingState()
class Loading : LoadingState()
class Loaded(val value: Measurement) : LoadingState()
class Error(val error: Throwable? = null) : LoadingState()
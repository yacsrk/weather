package com.ing.airquality.domain.interactor

import io.reactivex.Scheduler

interface Schedulers {
    fun io(): Scheduler
    fun ui(): Scheduler
}
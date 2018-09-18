package com.ing.airquality.ui

import com.ing.airquality.domain.interactor.Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers as RxSchedulers

class InteractorSchedulers : Schedulers {
    override fun io(): Scheduler = RxSchedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}
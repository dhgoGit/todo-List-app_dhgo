package com.todolist.modules.task.repo

import com.todolist.modules.task.dto.DeadLineTask
import com.todolist.utils.LogUtil.Companion.log
import io.kotest.core.spec.style.FeatureSpec

class DeadLineEntityTest : FeatureSpec() {
    init {
        feature("엔티티실험"){
            scenario("타입변환 실험"){
                val deadLineTask = DeadLineTask("hello")
                log.info{"deadLineTask : ${deadLineTask.toEntiy()}"}
            }
        }
    }
}
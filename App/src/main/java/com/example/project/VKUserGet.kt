package com.example.project

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

class VKUserGet {
    var name = ""

    fun get(id : Int) {
        val user = VKUsersRequest(intArrayOf(id))

        VK.execute(VKUsersRequest(), object: VKApiCallback<List<VKUser>> {
            override fun success(result: List<VKUser>) {
                name = result[0].firstName
            }
            override fun fail(error: VKApiExecutionException) {
            }
        })
    }

}
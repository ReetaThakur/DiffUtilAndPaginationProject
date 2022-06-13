package com.reeta.diffutilandpaginationproject.pagination.ui

import com.reeta.diffutilandpaginationproject.pagination.apiCall.ResponseDTO

sealed class MainUIModel{

    data class onSuccess(val responseDTO: ResponseDTO):MainUIModel()
    data class onFailure(val error:String):MainUIModel()
}

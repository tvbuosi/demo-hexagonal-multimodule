package com.demo.hexagonal.component

import com.auth0.jwt.JWT
import com.demo.hexagonal.domain.exception.BusinessErrorCode
import com.demo.hexagonal.domain.exception.BusinessException
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class HeaderData {

    class Authorization {
        var traceId: String? = null
        val authorization: Authorization? = null

        fun deserialize(token: String) {

            try {
                val tokenBase64 = token.substring(token.indexOf(" ") + 1)
                val jwt = JWT.decode(tokenBase64)

                this.traceId = jwt.claims[Constants.traceId]?.asString()
                //TODO: authorization this.authorization = jwt.claims[Constants.authorization]?.asString()

            } catch (exception: RuntimeException) {
                throw BusinessException(BusinessErrorCode.FAILED_DESERIALIZE_TOKEN)
            }
        }
    }

    object Constants {
        const val traceId = "trace-id"
        const val authorization = "Authorization"
    }
}
package sk.momosilabs.trucker.server.version.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.RestController
import sk.momosilabs.trucker.api.version.BuildInfoApi
import sk.momosilabs.trucker.api.version.dto.BuildInfoDTO
import java.time.ZoneOffset

@RestController
class BuildInfoController(
    private val buildProperties: BuildProperties,
) : BuildInfoApi {

    override fun get(request: HttpServletRequest): BuildInfoDTO = BuildInfoDTO(
        name = buildProperties.name,
        version = buildProperties.version,
        time = buildProperties.time.atOffset(ZoneOffset.UTC).toZonedDateTime(),
        url = request.requestURL.toString(),
    )

}

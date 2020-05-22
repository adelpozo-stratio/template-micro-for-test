package com.stratio.financial.test.infrastructure.rest.spring.resource;

import org.springframework.web.bind.annotation.RestController;

import com.stratio.financial.test.infrastructure.rest.spring.spec.UserApi;

import io.swagger.annotations.Api;

@RestController
@Api(tags = {"user"})
public class UserApiResource implements UserApi {

}

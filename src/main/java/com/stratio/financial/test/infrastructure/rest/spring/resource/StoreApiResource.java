package com.stratio.financial.test.infrastructure.rest.spring.resource;

import org.springframework.web.bind.annotation.RestController;

import com.stratio.financial.test.infrastructure.rest.spring.spec.StoreApi;

import io.swagger.annotations.Api;

@RestController
@Api(tags = {"store"})
public class StoreApiResource implements StoreApi {

}

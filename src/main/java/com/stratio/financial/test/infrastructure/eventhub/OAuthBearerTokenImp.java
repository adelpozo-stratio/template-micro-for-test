package com.stratio.financial.test.infrastructure.eventhub;

import java.util.Set;

import org.apache.kafka.common.security.oauthbearer.OAuthBearerToken;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OAuthBearerTokenImp implements OAuthBearerToken {

  private final String token;
  private final long lifetimeMs;

  @Override
  public String value() {
    return this.token;
  }

  @Override
  public Set<String> scope() {
    return null;
  }

  @Override
  public long lifetimeMs() {
    return this.lifetimeMs;
  }

  @Override
  public String principalName() {
    return null;
  }

  @Override
  public Long startTimeMs() {
    return null;
  }
}
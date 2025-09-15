package interfaces.api.user.dto.authUserToken;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public record GenerateAuthUserTokenResponse(
  String token,
  String expiresDate,
  String status,
  String result) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public GenerateAuthUserTokenResponse(
    @JsonProperty("token") String token,
    @JsonProperty("expires") String expiresDate,
    @JsonProperty("status") String status,
    @JsonProperty("result") String result) {
    this.token = token;
    this.expiresDate = expiresDate;
    this.status = status;
    this.result = result;
  }
}
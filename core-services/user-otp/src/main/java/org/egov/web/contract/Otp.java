package org.egov.web.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.egov.domain.model.OtpRequestType;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Otp {
    private static final String USER_REGISTRATION = "register";
    private static final String PASSWORD_RESET = "passwordreset";
    private static final String EMPLOYEE_LOGIN = "employeelogin";
    private static final String CITIZEN_LOGIN = "citizenlogin";
    private String mobileNumber;
    private String tenantId;
    private String type;
    private String userType;

    @JsonIgnore
    public OtpRequestType getTypeOrDefault() {
        return isEmpty(type) ? OtpRequestType.REGISTER : mapToDomainType();
    }

    private OtpRequestType mapToDomainType() {
        if (USER_REGISTRATION.equalsIgnoreCase(type)) {
            return OtpRequestType.REGISTER;
        } else if (EMPLOYEE_LOGIN.equalsIgnoreCase(type)) {
            return OtpRequestType.LOGIN_EMPLOYEE;}
        else if (CITIZEN_LOGIN.equalsIgnoreCase(type)) {
            return OtpRequestType.LOGIN_CITIZEN;
        } else if (PASSWORD_RESET.equalsIgnoreCase(type)) {
            return OtpRequestType.PASSWORD_RESET;
        }
        return null;
    }
}


package com.ms.spring.integration.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class PropertiesProvider {

    @Value("${sfdc.login.url}")
    private String sfdcLoginURL;

    @Value("${sfdc.soap.partner.endpoint}")
    private String sfdcSoapPartnerEndpoint;

    @Value("${sfdc.username}")
    private String sfdcUsername;

    @Value("${sfdc.password}")
    private String sfdcPassword;

    @Value("${sfdc.pushtopic.acct}")
    private String sfdcPushTopicAcct;

    @Value("${sfdc.soap.api.version}")
    private String sfdcSoapApiVersion;

    public String getSfdcLoginURL() {
        return sfdcLoginURL;
    }

    public String getSfdcSoapPartnerEndpoint() {
        return sfdcSoapPartnerEndpoint;
    }

    public String getSfdcUsername() {
        return sfdcUsername;
    }

    public String getSfdcPassword() {
        return sfdcPassword;
    }

    public String getSfdcPushTopicAcct() {
        return sfdcPushTopicAcct;
    }

    public String getSfdcSoapApiVersion() {
        return sfdcSoapApiVersion;
    }

}

package com.toob.qautomation.props;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class QaProps {


    @Value("${qa.tooling.web.driver.target.url}")
    private String targetWebUrl;

    @Value("${qa.tooling.web.driver.wait-timeout-seconds}")
    private Integer waitTimeOutSeconds;

}

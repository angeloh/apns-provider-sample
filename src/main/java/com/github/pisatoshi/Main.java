package com.github.pisatoshi;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class Main {
    public static void main(String[] args) {
        ApnsService service =
                APNS.newService()
                .withCert("path/to/sample.p12", "password")
                .withSandboxDestination()
                .build();
        String payload = APNS.newPayload().alertBody("ぷーーーーっしゅぅ！！！").build();
        // set APNS device token here.
        String token = "xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx";
        service.push(token, payload);
    }
}

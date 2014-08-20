package com.github.pisatoshi;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class Main {
    public static void main(String[] args) {
        ApnsService service =
                APNS.newService()
                .withCert("src/main/resources/DEV-APNS-CERT.p12", "sparkover66")
                .withSandboxDestination()
                .build();
        String payload = APNS.newPayload()
                  .badge(2) //offline member's unread msgs
                  .localizedKey("NEW_MESSAGE_PUSH_FORMAT")
                  .actionKey("REPLY").build();

        // set APNS device token here.
        String token = "b0726cce215375c7113067747d89378261bfb5a9f07c248cfa044f5d775017f5";
        service.push(token, payload);
        System.exit(0);
    }
}

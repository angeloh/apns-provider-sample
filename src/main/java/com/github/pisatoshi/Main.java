package com.github.pisatoshi;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class Main {
    public static void main(String[] args) {
        ApnsService service =
                APNS.newService()
                // .withCert("src/main/resources/DEV-APNS-CERT.p12", "sparkover66")
                .withCert(Main.class.getClassLoader().getResourceAsStream("DEV-APNS-CERT.p12"), "sparkover66")
                .withSandboxDestination()
                // .withCert(Main.class.getClassLoader().getResourceAsStream("PROD-APNS-CERT.p12"), "sparkover66")
                // .withProductionDestination()
                .build();
        String payload = APNS.newPayload()
                  .badge(2) //offline member's unread msgs
                  .localizedKey("NEW_MESSAGE_PUSH_FORMAT")
                  .actionKey("REPLY").build();

        // set APNS device token here.
        String token = "7d870829dba81b27a8104bd28c30951b32caaec8c4590af4d1d6864e7ef230fe";
        service.push(token, payload);
        System.exit(0);
    }
}

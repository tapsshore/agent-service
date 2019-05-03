package com.shoshore.agentservice.utils.keygen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyGen {

    private KeyGen() {
        super();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyGen.class);

    public static long getUniqueId() {
        long l = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            builder.append((int) (Math.random() * 10));
        }
        int randomNumber = (int) (Math.random() * 1000);


        String entityId = l + builder.toString() + randomNumber;

        try {
            l = Long.parseLong(entityId);
        } catch (Exception e) {
            LOGGER.error("Error : ", e);
            return l;
        }
        return l;
    }
}

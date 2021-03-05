package org.acme;


import java.time.Duration;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

/**
 * A bean producing random prices every 5 seconds.
 * The prices are written to a in-memeory-stream
 */
@ApplicationScoped
public class PriceGenerator {

    private Random random = new Random();

    @Outgoing("generated-price")                        
    public Multi<Integer> generate() {                  
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .onOverflow().drop()
                .map(tick -> random.nextInt(100));
    }

}

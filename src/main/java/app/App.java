package app;

import Sockets.Server;
import Sockets.pojos.HttpResponse;

import java.io.IOException;

import static Sockets.contract.HttpMethod.GET;
import static Sockets.contract.HttpMethod.POST;

/**
 * Test functional server library.
 */
public class App {
    public static void main(String[] args) throws IOException {
        Server myServer = new Server(8090);
        myServer.addRoute(GET, "/testOne",
                (req) -> new HttpResponse.Builder()
                        .setStatusCode(200)
                        .addHeader("Content-Type", "text/html")
                        .setEntity("<HTML> <P> Hello One... </P> </HTML>")
                        .build());

        myServer.addRoute(POST, "/testTwo",
                (req) -> {
                    return new HttpResponse.Builder()
                            .setStatusCode(200)
                            .addHeader("Content-Type", "text/html")
                            .setEntity("<HTML> <P> Hello Two... </P> </HTML>")
                            .build(); });

        myServer.start();
    }
}

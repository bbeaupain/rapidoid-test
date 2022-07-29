package org.example;

import org.rapidoid.buffer.Buf;
import org.rapidoid.http.AbstractHttpServer;
import org.rapidoid.http.HttpStatus;
import org.rapidoid.http.MediaType;
import org.rapidoid.net.Server;
import org.rapidoid.net.abstracts.Channel;
import org.rapidoid.net.impl.RapidoidHelper;

public class CustomHttpServer extends AbstractHttpServer {
    private static final byte[] HELLO_WORLD = "Hello, world!".getBytes();

    public static void main(String[] args) {
        Server server = new CustomHttpServer().listen(8080);
    }

    @Override
    protected HttpStatus handle(Channel ctx, Buf buf, RapidoidHelper req) {
        return ok(ctx, req.isKeepAlive.value, HELLO_WORLD, MediaType.TEXT_PLAIN);
    }
}

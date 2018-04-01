package com.sample.jetty;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import sun.net.httpserver.AuthFilter;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import java.util.EnumSet;

public class App {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        context.addServlet(HelloServlet.class, "/hello");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context,  });
        server.setHandler(handlers);

        server.start();
        server.join();

    }
}

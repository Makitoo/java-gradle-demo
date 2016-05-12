package com.makitoo.demo;

import spark.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by nicolas on 12/05/16.
 */
public class SparkServer {
    public static void main(String[] args) {

        com.makitoo.MakitooJava.init(
                "https://dashboard.makitoo.com/rest",
                "APPLICATION_ID",   // Application ID
                "TOKEN",            // Application TOKEN
                "0.0.1");

        // return exception in http body
        Spark.exception(Exception.class, (exception, request, response) -> {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            exception.printStackTrace(new PrintStream(out));
            response.body(out.toString());
        });

        Spark.get("/", (request, response) -> "Server is up");

        Spark.get("/npe", (request, response) -> {
            String version = System.getProperty("version");
            return version.toLowerCase();
        });
        Spark.get("/crash", (request, response) -> {
            doSomethingBad();
            response.status(200);
            return "ok";
        });
    }

    public static void doSomethingBad() {
        throw new IllegalStateException("something bad append");
    }

}

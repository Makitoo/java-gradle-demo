# Makitoo java with gradle example

## Introduction
Makitoo is a technology for monitoring Android applications in production. It allows you to :
- Remotely monitor your application. Each exception at runtime is automatically monitored in the Makitoo dashboard.
- Diagnostic all your bugs with automatically collected information.
- Fix some bugs at runtime with hot patching, without recompiling and re-deploing your application.

This repository is an example Android built with gradle. This app has one single screen with two buttons, we inserted on purpose a bug causing a crash in the "back-up notes" button.

## Usage

First, you should create a Makitoo account : <https://dashboard.makitoo.com/>

When you are successfully logged in, you can create an application, it gives you get an ID and TOKEN of your application.

Then, edit file `src/main/java/com/makitoo/demo/SparkServer.java ` to insert your application id and token in main() method as follows.

    com.makitoo.MakitooJava.init(
                "https://dashboard.makitoo.com/rest",
                "APPLICATION_ID",   // Application ID
                "TOKEN",            // Application TOKEN
                "0.0.1");

## Execution

Start your application on localhost with
`$ ./gradlew run

The application is now started and collect execution bugs in your dashboard at <https://dashboard.makitoo.com/>.

## Monitor

You can generate some bug report by visiting <http://localhost:4567/npe> and  <http://localhost:4567/crash>

## Hotfixe

In the Makitoo dashboard, you can create hotpatch for the both failing resources.

When you create an hotpatch, re-visit <http://localhost:4567/npe> and  <http://localhost:4567/crash>, the bug should be fixed !
It could take few seconds to dispatch hotpatch to running service.

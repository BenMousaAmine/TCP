package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandlerHTTP  implements HttpHandler {

        private String process( String body){

            String[] splitted = body.split("&");
            if (splitted.length == 0)
                return "no data";
            String cmd = splitted[0].split(" = ")[0];
            String options = splitted[0].split(" =")[1];
            String user = splitted[1].split(" = ")[1];
            if (cmd.equals("gimmeanswer=please"))
                return "Hello " + user + "\n";

            if (cmd.equals("gimmeanswer"))
                return "You are unpolite, " + user + "\n";

            return "bad request";

        }
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();

            URI uri = exchange.getRequestURI();


            String method = exchange.getRequestMethod();
            String s = read(is);
            System.out.println(s);
            String myanswer= "hello";
            String response = "<!doctype html>\n" +
                    "<html lang=en>\n" +
                    "<head>\n" +
                    "<meta charset=utf-8>\n" +
                    "<title>MyJava Sample</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "</br>The content:"+"hello from me " +
                    "</br>\n" +
                    s +myanswer+
                    "</br>query:" +
                    "</br>\n" +
                    "</body>\n" +
                    "</html>\n";;
            System.out.println(process(s));

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        }
        private String read(InputStream is) {
            BufferedReader br = new BufferedReader( new InputStreamReader(is) );
            System.out.println("\n");
            String received = "";
            while (true) {
                String s = "";
                try {
                    if ((s = br.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(s);
                received += s;
            }
            return received;
        }


    }


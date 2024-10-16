package app;

import static javax.xml.ws.Endpoint.publish;

public class SpamReportPublisher {

    public static void main(String[] args) {

        publish("http://localhost:8080/SpamReportService", new SpamReportServiceImpl());

        System.out.println("Spam Report Service is published at http://localhost:8080/SpamReportService?wsdl");
    }

}

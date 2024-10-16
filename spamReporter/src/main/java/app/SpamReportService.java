package app;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SpamReportService {
    @WebMethod
    boolean reportSpam(String number, String message);

    @WebMethod
    int getReportCount(String number);
}

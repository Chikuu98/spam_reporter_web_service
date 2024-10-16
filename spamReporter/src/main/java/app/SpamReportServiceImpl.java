package app;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "app.SpamReportService")
public class SpamReportServiceImpl implements SpamReportService {

    // Initialize the hash map to store reported numbers and their count.
    private static Map<String, Integer> reportedNumbers = new HashMap<>();

    // Report a spam message from a specific number.
    @Override
    public boolean reportSpam(String number, String message) {
        if (message != null && !message.isEmpty()) {
            Integer count = reportedNumbers.get(number);
            if (count != null) {
                reportedNumbers.put(number, count + 1);
            } else {
                reportedNumbers.put(number, 1);
            }
            return true;  // Report accepted.
        }
        return false;  // Report rejected due to missing or empty message.
    }

    // Check how many reports have been made against a specific number
    @Override
    public int getReportCount(String number) {
        return reportedNumbers.getOrDefault(number, 0);
    }

}

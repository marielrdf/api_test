package test.api.cucumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static String buildEndpoind(Helper helper , String endPoint) {
        String[] endpoindSplit = endPoint.split("/"); // /boards/ ,[board.id]
        for (int i = 0; i < endpoindSplit.length; i++) {
            Pattern pattern = Pattern.compile("(?<=\\[)(.*)(?=])");
            Matcher matcher = pattern.matcher(endpoindSplit[i]);
            if (matcher.find()){
                endpoindSplit[i] = getValueResponse(helper, matcher.group(1));
            }
        }
        return String.join("/", endpoindSplit);

    }

    private static String getValueResponse(Helper helper, String match) {
        // board.id
        String[] element = match.split(".");
        System.out.println(element[0] + "   " + element[1]);
        return helper.response.path(element[1]);
    }
}

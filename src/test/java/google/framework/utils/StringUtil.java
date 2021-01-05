package google.framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final String EMPTY_STRING = "";

    public static List<String> substringsByRegex(String text, String regex) {
        LogUtil.info(String.format("Searching substrings according with regex expression \"%s\".", regex));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> substrings = new ArrayList<String>();
        while (matcher.find()) {
            substrings.add(text.substring(matcher.start(), matcher.end()));
        }
        return substrings;
    }

    public static String substringByRegex(String text, String regex) {
        LogUtil.info(String.format("Searching substring according with regex expression \"%s\".", regex));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return text.substring(matcher.start(), matcher.end());
        } else {
            return null;
        }
    }

    public static String replaceWithRegExpWithEmptyString(String string, String regex){
        LogUtil.info("Remove string characters according to pattern.");
        return replaceWithRegExp(string, regex, EMPTY_STRING);
    }

    public static String replaceWithRegExp(String string, String regex, String replacement) {
        LogUtil.info( "Replace characters according to regex with replacement element.");
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        return m.replaceAll(replacement);
    }
}

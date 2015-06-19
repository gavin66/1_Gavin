package me.isgavin.tools;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		String regex = "\\";
		String str = "JFLK'KSDJFKL'";
		str = str.replace("'", " ");
//		Pattern pat = Pattern.compile(regex);
//		Matcher matcher = pat.matcher(str);
//		while (matcher.find()) {
//			String temp = str.substring(matcher.start(), matcher.end());
//			str = str.replaceAll(temp, "ÕâÊÇÒýºÅ");
//		}
		System.out.println(str);
	}
}

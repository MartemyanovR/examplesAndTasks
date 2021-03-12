package io.fileClass;

import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.io.File;

public class DirList {
	public static FilenameFilter filter (final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
			return pattern.matcher(name).matches();
			}
		};
	}
	
	public static void main(String[] args) {
		File path = new File("C://eclipse-workspace//");
		String[] list;
		if(args.length == 0) 
			list = path.list();
		else
			list = path.list(filter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem: list)
			System.out.println(dirItem);	
	}
}

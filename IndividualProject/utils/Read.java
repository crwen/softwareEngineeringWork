package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 文件读写的工具类
 * @author crwen
 *
 */
public class Read {
	
	private static List<String> fileList = new ArrayList<>();
	
	/**
	 * 读取文件
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String path) throws IOException  {

		FileInputStream fip = new FileInputStream(path);
		InputStreamReader reader = new InputStreamReader(fip, "gbk");
		StringBuffer sb = new StringBuffer();
		while (reader.ready()) {
			sb.append((char) reader.read());
		}
//	    System.out.println(sb.toString());
		reader.close();
		fip.close();
		
		//返回文件内容
		return sb.toString();
	}
	
	public static List<String> readDirection(String path) throws IOException {
		
		File file = new File(path);
		File[] files = file.listFiles();
		
		for (int i = 0; i < files.length; ++i) {
			if (files[i].isDirectory()) {
				continue;
			} else {
				fileList.add( readFile(files[i].getAbsolutePath()) );
//				System.out.println(files[i]);
			}
			
		}
		System.out.println();
		
		return fileList;
	}
	
	public static List<String> readDirectionRec(String path) throws IOException {
		
		File file = new File(path);
		File[] files = file.listFiles();
		
		for (int i = 0; i < files.length; ++i) {
			if (files[i].isDirectory()) {
				readDirection(files[i].getAbsolutePath());
			} else {
				fileList.add( readFile(files[i].getAbsolutePath()) );
//				System.out.println(files[i]);
			}
			
		}
		
		return fileList;
	}
	
	/**
	 * 从停用表（stopwords.txt）中获取停用词，并返回
	 * @throws IOException 
	 */
	public static Set<String> getStopWords(String stop) throws IOException {
		String content = readFile(stop);
		String[] words = content.split("[^A-z0-9]");
		
		Set<String> set = new HashSet<>();
		for (String s : words ) {
			set.add(s);
		}
		
		return set;
	}

}

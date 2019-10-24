import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 字母类
 * @author crwen
 *
 */


public class WF {

	private final static String STR = "abcdefghijklmnopqrstuvwxyz";

	private static int num;	
	
	public static void main(String[] args) throws IOException {

		if (args.length > 1) {
			String op = args[0];
			if (op.equals("-c")) {
				//获取文件路径
				String path = getPath(args);
				//获取文件内容
				String content = read(path);
				convert(content.toLowerCase());
			} else if (op.equals("-f")) {
				//获取文件路径
				String path = getPath(args);
				//获取文件内容
				String content = read(path);
				words(content);
			}
		}
	}

	/**
	 * 获取文件路径
	 * @param args
	 * @return
	 */
	private static String getPath(String[] args) {
		String path = "";
		for (int i = 1; i < args.length; ++i) {
			path += args[i] + " ";
		}
		
		return path;
	}
	
	/**
	 * 读取文件
	 * @return
	 * @throws IOException
	 */
	private static String read(String path) throws IOException  {

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

	
	/**
	 * 记录文件内容中各字母和出现的次数
	 * @param content
	 * @return
	 */
	private static void convert(String content) {
		DecimalFormat df = new DecimalFormat("######0.00%"); 
		Alph[] arr = new Alph[26];
		for (int i = 0; i < STR.length(); ++i) {
			arr[i] = new Alph(STR.charAt(i));
		}

		for (int i = 0; i < content.length(); ++i) {
			int index = content.charAt(i) - 'a';
			if (index >= 0) {
				num++;
				arr[index].setCnt(arr[index].getCnt() + 1);
			}
		}
		
	
		Arrays.sort(arr);
		
		System.out.println("字母\t出现次数\t频率");
		for (int i = 0; i < STR.length(); ++i) {
			System.out.println(arr[i].getCh() + "\t" + arr[i].getCnt() + "\t" + df.format((double)arr[i].getCnt() / num));
		}
		
	}
	
	
	public static void words(String content) {
		DecimalFormat df = new DecimalFormat("######0.00%"); 
		String strs[] = content.split(" ");
		Set<Alph> set = new HashSet<Alph>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].matches("[A-z]+[A-z0-9]")) {
				num++;
				if (map.get(strs[i]) == null) {
					map.put(strs[i], 1);
				} else {
					map.put(strs[i], map.get(strs[i]) + 1);
				}
			}
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			set.add(new Alph(entry.getKey(), entry.getValue()));
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}

		Alph[] arr =  new Alph[set.size()];
		set.toArray(arr);
		Arrays.sort(arr);
		
		System.out.println("单词   \t\t   频率");
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i].getWord() + "\t\t" +  df.format((double)arr[i].getCnt() / num));
			
		}
	}



}
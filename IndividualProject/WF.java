import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

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
		String strs[] = content.split(" ");
		Set<String> set = new HashSet<String>();
		SortedMap<String, Integer> map = new TreeMap<String, Integer>();

		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].matches("[A-z]+[A-z0-9]")) {
				if (map.get(strs[i]) == null) {
					map.put(strs[i], 1);
				} else {
					map.put(strs[i], map.get(strs[i]) + 1);
				}
				
//				set.add(strs[i]);
			}
		}
		
		System.out.println(map);
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
	}



}

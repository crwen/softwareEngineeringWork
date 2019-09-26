import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.Path;
import utils.Read;

/**
 * 字母类
 * @author crwen
 *
 */


public class WF {

	private final static String STR = "abcdefghijklmnopqrstuvwxyz";

	private static int num;	
	
	public static void main(String[] args) throws IOException {
		//获取文件路径
		String path = Path.getPath(args, 1);
		if (args.length > 1) {
			String op = args[0];
			String content = "";
			
			switch (op) {
			case "-c":
				//获取文件内容
//				String content = read(path);
				content = Read.readFile(path);
				convert(content.toLowerCase());
				break;
			case "-f":
				content = Read.readFile(path);
				words(content);
				break;
			case "-d":
				List<String> contents = null;
				if (args[1].equals("-s")) {
					path = Path.getPath(args, 2);
					contents = Read.readDirectionRec(path);
				} else {
					contents = Read.readDirection(path);
				}

				for (String c : contents) {
					words(c);
				}
				break;
			case "-n":
				path = Path.getPath(args, 2);
				content = Read.readFile(path);
				words(content, Integer.parseInt(args[1]));
				break;

			default:
				break;
			}
			
		}
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
	
	/**
	 * 记录文件内容中各单词出现的次数和频次
	 * @param content
	 */
	public static void words(String content) {
		
		DecimalFormat df = new DecimalFormat("######0.00%"); 
		Alph[] arr = findWords(content);
		
		System.out.println("单词   \t\t   频率");
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i].getWord() + "\t\t" +  df.format((double)arr[i].getCnt() / num));
			
		}
	}
	
	public static void words(String content, int n) {
		
		DecimalFormat df = new DecimalFormat("######0.00%"); 
		Alph[] arr = findWords(content);
		
		System.out.println("单词   \t\t   频率");
		for (int i = 0; i < n; ++i) {
			if (i >= arr.length)	break;
			System.out.println(arr[i].getWord() + "\t\t" +  df.format((double)arr[i].getCnt() / num));
			
		}
	}

	/**
	 * 找出不重复的单词与频次，并返回
	 * @param content
	 * @return
	 */
	private static Alph[] findWords(String content) {
		String strs[] = content.split(" ");
		Set<Alph> set = new HashSet<Alph>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		num = 0;
		
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
		}

		Alph[] arr =  new Alph[set.size()];
		set.toArray(arr);
		Arrays.sort(arr);
		return arr;
	}



}
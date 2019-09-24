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
import java.util.Map;

/**
 * 字母类
 * @author crwen
 *
 */


public class WF {

	private final static String STR = "abcdefghijklmnopqrstuvwxyz";

	private final static String PATH = "D:\\a.txt";	//文件路径
	
	private static int num;	//记录字母的总个数
	
	public static void main(String[] args) throws IOException {

		DecimalFormat df = new DecimalFormat("######0.00%"); // 格式化

		//获取文件内容并转化为小写
		String content = read().toLowerCase();
		
		Alph[] arr = convert(content);
		
		System.out.println("字母\t出现次数\t频率");
		for (int i = 0; i < STR.length(); ++i) {
			System.out.println(arr[i].getCh() + "\t" + arr[i].getCnt() + "\t" + df.format((double)arr[i].getCnt() / num));
		}

	}

	/**
	 * 读取文件
	 * @return
	 * @throws IOException
	 */
	private static String read() throws IOException  {

		FileInputStream fip = new FileInputStream(PATH);
		InputStreamReader reader = new InputStreamReader(fip, "utf-8");
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
	private static Alph[] convert(String content) {
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
		
		//对字母数组按照频率从大到小排序
		Arrays.sort(arr);
		return arr;
	}


}

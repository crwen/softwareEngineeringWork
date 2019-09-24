
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


class Alph implements Comparable<Alph> {
	private Character ch;		//字母
	private Integer cnt;	//频数
	
	public Alph(char ch) {this.ch = ch; this.cnt = 0;}
	
	public void setCnt(int cnt) { this.cnt = cnt; }
	
	public void setCh(char ch) { this.ch = ch; }
	
	public int getCnt() {return this.cnt; }
	
	public char getCh() {return this.ch; }


	@Override
	public int compareTo(Alph o) {
		if (o.cnt != this.cnt) {
			return o.cnt.compareTo(this.cnt);
		} else {
			return this.ch.compareTo(o.ch);
		}
	}

}

public class WFStep1 {

	private final static String STR = "abcdefghijklmnopqrstuvwxyz";

	private final static String PATH = "D:\\a.txt";	
	
	private static int num;	
	
	public static void main(String[] args) throws IOException {

		

		//获取文件内容并转化为小写
		String content = read();
		
//		convert(content.toLowerCase());

		
		words(content);

	}

	/**
	 * 读取文件
	 * @return
	 * @throws IOException
	 */
	private static String read() throws IOException  {

		FileInputStream fip = new FileInputStream(PATH);
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
		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].matches("[A-z]+[A-z0-9]")) {
				set.add(strs[i]);
			}
		}
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

package utils;

public class Path {
	/**
	 * 获取文件路径
	 * @param args
	 * @return
	 */
	public static String getPath(String[] args, int begin) {
		String path = "";
		for (int i = begin; i < args.length; ++i) {
			path += args[i] + " ";
		}
		
		return path.trim();
	}
	
	public static String getPath(String[] args, int begin, int end) {
		String path = "";
		for (int i = begin; i < end; ++i) {
			path += args[i] + " ";
		}
		
		return path.trim();
	}
	
}

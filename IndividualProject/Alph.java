public class Alph implements Comparable<Alph> {
	private Character ch;		//字母
	private Integer cnt;	//频数
	
	public Alph(char ch) {this.ch = ch; this.cnt = 0;}
	
	public void setCnt(int cnt) { this.cnt = cnt; }
	
	public void setCh(char ch) { this.ch = ch; }
	
	public int getCnt() {return this.cnt; }
	
	public char getCh() {return this.ch; }

	/**
	 * 重写compare方法，使之按照频率从大到小排列
	 * 如果频数一样，就按字典序排列
	 */
	@Override
	public int compareTo(Alph o) {
		if (o.cnt != this.cnt) {
			return o.cnt.compareTo(this.cnt);
		} else {
			return this.ch.compareTo(o.ch);
		}
	}

}
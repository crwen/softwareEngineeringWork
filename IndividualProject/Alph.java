public class Alph implements Comparable<Alph> {
	private Character ch;		//字母
	private Integer cnt;	//频数
	private String word;	//单词
	
	public Alph(char ch) {this.ch = ch; this.cnt = 0;}
	
	public Alph(String word, int cnt) {this.word = word; this.cnt = cnt;}
	
	public void setCnt(int cnt) { this.cnt = cnt; }
	
	public void setCh(char ch) { this.ch = ch; }
	
	public void setWord(String word) { this.word = word; }
	
	public int getCnt() {return this.cnt; }
	
	public char getCh() {return this.ch; }
	
	public String getWord() { return this.word;}


	@Override
	public int compareTo(Alph o) {
		
		if (o.cnt != this.cnt) {
			return o.cnt.compareTo(this.cnt);
		} else if (this.word != null || this.word.length() != 0) {
			return this.word.compareTo(o.word);
		} else {
			return this.ch.compareTo(o.ch);
		}
		
	}

	@Override
	public String toString() {
		return "Alph [ch=" + ch + ", cnt=" + cnt + ", word=" + word + "]";
	}
	
	

}
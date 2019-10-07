public class Alph implements Comparable<Alph> {
	private Character ch;		//字母
	private Integer cnt;	//频数
	private String word;	//单词
	private String phrase;	//短语
	private Integer num;	//多少个词
	
	public Alph(char ch) {this.ch = ch; this.cnt = 0;}
	
	public Alph(String word, int cnt) {this.word = word; this.cnt = cnt;}
	
	public Alph(String phrase, int num, int cnt) {this.phrase = phrase; this.num = num; this.cnt = cnt;}
	
	public void setCnt(int cnt) { this.cnt = cnt; }
	
	public void setCh(char ch) { this.ch = ch; }
	
	public void setWord(String word) { this.word = word; }
	
	public void setPhrase(String phrase) { this.phrase = phrase; }
	
	public void setNum(int num) { this.num = num; }
	
	public int getCnt() {return this.cnt; }
	
	public char getCh() {return this.ch; }
	
	public String getWord() { return this.word;}
	
	public String getPhrase() { return this.phrase;}
	
	public int getNum() {return this.num; }


	@Override
	public int compareTo(Alph o) {
		
		if (o.cnt != this.cnt) {
			return o.cnt.compareTo(this.cnt);
		} else if (this.phrase != null) {
			return this.phrase.compareTo(o.phrase);
		} else if (this.word != null || this.word.length() != 0) {
			return this.word.compareTo(o.word);
		} else {
			return this.ch.compareTo(o.ch);
		}
		
	}

	@Override
	public String toString() {
		return "Alph [ch=" + ch + ", cnt=" + cnt + ", word=" + word + ", phrase=" + phrase + ", num=" + num + "]";
	}

	
	
}
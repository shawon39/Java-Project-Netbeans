package dictionaryDemo;

public class Word {
	private String phrase;
	private String meaning;
	private String type;
	private Antonym ant[];
	private Synonym syn[];
	public Word(String phrase, String meaning, String type, int nant, int nsyn){
		this.phrase=phrase;
		this.meaning=meaning;
		this.type=type;
		this.ant=new Antonym[nant];
		this.syn=new Synonym[nsyn];
	}
	public void showDetail(){
		System.out.println("Phrase: "+phrase+"\nMeaning: "+meaning+"\nType: "+type);
		System.out.println("Antonym:");
		for(int i=0; i<ant.length; i++) ant[i].display();
		System.out.println("Synonym:");
		for(int i=0; i<syn.length; i++) syn[i].display();
	}
	public void addAnt(String phrase, int i){
		this.ant[i]=new Antonym(phrase);
	}
	public void addSyn(String phrase, int i){
		this.syn[i]=new Synonym(phrase);
	}
}

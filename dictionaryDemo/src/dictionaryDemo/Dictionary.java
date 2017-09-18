package dictionaryDemo;

import java.util.Scanner;

public class Dictionary
{
    private String name;
    private int noWord;
    private Word wrd[];
    public Dictionary(String name, int noWord)
    {
        this.name=name;
        this.noWord=noWord;
        this.wrd=new Word[noWord];
    }
    public void addWord(String phrase, String meaning, String type, int nant, int nsyn, int no)
    {
        this.wrd[no]=new Word(phrase, meaning, type, nant, nsyn);
        System.out.println("Insert "+nant+" antonyms");
        String tmp;
        Scanner sc= new Scanner(System.in);
        for(int i=0; i<nant; i++)
        {
            tmp=sc.nextLine();
            wrd[no].addAnt(tmp, i);
        }
        System.out.println("Insert "+nsyn+" Synonyms");
        for(int i=0; i<nsyn; i++)
        {
            tmp=sc.nextLine();
            wrd[no].addSyn(tmp, i);
        }
    }
    public void display()
    {
        System.out.println(name);
        for(int i=0; i<noWord; i++)
        {
            wrd[i].showDetail();
        }

    }
    public static void main(String[] args)
    {
        Dictionary d=new Dictionary("Abeer's Dictionary", 1	);
        d.addWord("Work", "Doing", "Verb", 1, 1, 0);
        //d.addWord("Angry", "Mad", "Adjective", 2, 2, 1);
        d.display();
    }

}

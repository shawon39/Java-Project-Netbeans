package SnakeLadder;
import java.util.Random;
import java.util.*;



public class Game {
	Random rand = new Random();
	Board board = new Board();
	
	
	int rolldice(int player){
	    int dice = rand.nextInt(6) + 1;
	    System.out.printf("\nDICE GAVE YOU: %d", dice);
	    return player + dice;
	}
	
	int boardposition(int player){
	    Globals.shapKatse = false;
	    Globals.chongeUtsi = false;
	    int index = 0;
	    //board e loop chalaya cell er index ber kore
	    for(int i = 0; i < Globals.n ; i++){
	        if(player == board.board[i]){
	            index = i;
	        }
	    }

	    //cell er index e shap ase ki na check kore..
	    if(board.snake[index] < 0){
	        System.out.printf("%d te Shape katse\n", board.board[index]);
	        System.out.printf("Tore %d ghor theika %d ghore namai diche\n\n",board.board[index], board.board[(-1)*board.snake[index]]);
	        Globals.shapKatse = true;
	        //shap thakle shap kaitta je ghore pathaise se ghorer index hobe notun index
	        index = (-1)*board.snake[index];
	    }

	    //cell er index e ladder ase ki na chek kore..
	    if(board.ladder[index] > 0){
	    	System.out.printf("%d te laf dichos\n", board.board[index]);
	    	System.out.printf("Tore %d ghor theika %d ghore uthai diche\n\n",board.board[index], board.board[(1)*board.ladder[index]]);
	    	Globals.chongeUtsi = true;
	        //ladder thakle shap udaya je ghore pathaise se ghorer index hobe notun index
	        index = (1)*board.ladder[index];
	    }
	    return index;
	}
	
	void displayboard(ArrayList<Integer> player, ArrayList<String> name){
		System.out.printf("               ");
	    //ei loop prottekta cell number print korte jabe. but prottekta cell print korar age arekta loop chalabe
	    //arek ta loop cholbe player vector er upor. jeta dekhbe ekhon ami je cell print korchi sei cell e kono player ase ki na
	    //or in other words oi cell number er sathe player vector er kono player er number match khay ki na.
	    //jodi match khay tahole sei player er name oi cell number er bodole print korbe.

	    for(int i = 0; i < 100; i++){
	        int temp = board.board[i]; //je cell print korte jabo seta rakhlam
	        int flag = 0; //
	        for(int j = 0; j < name.size(); j++){
	        	//System.out.printf("Size: %d, J = %d \n", player.size(), j);
	            if(temp == player.get(j)){
	            	System.out.print(name.get(j) + " ");
	                flag = 1;
	                break;
	            }
	        }

	        if(flag == 0) System.out.printf("%02d ", board.board[i]);
	        if((i+1)%10 == 0) System.out.printf("\n               ");
	    }
	    System.out.printf("\n");
	}
}

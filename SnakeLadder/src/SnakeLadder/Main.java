package SnakeLadder;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Game game = new Game();
		Board board = new Board();
		Scanner sc = new Scanner(System.in);

		//////////////starting message and showing the board////////////
		System.out.printf("Starting from postion 1, \n Beware! It's a hostile land\n  there are snakes! hu ha ha ha ha\n\n\n");
		System.out.printf("                              ");
		for(int i = 0; i < Globals.n; i++){
			System.out.printf("%02d ", board.board[i]);
		  if((i+1)%10 == 0) System.out.printf ("\n                              ");
		}
		////////////////////////////////////////////////////////////////////////
		ArrayList<Integer> player = new ArrayList<Integer>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Boolean> start = new ArrayList<Boolean>();
	    int p;
	    System.out.printf("How many players? \n");
	    p = Integer.parseInt(sc.nextLine());
	    for(int i = 0; i < p; i++) player.add(0);
	    for(int i = 0; i < p; i++) start.add(false);
	    
	    int decision;
	    System.out.printf("Do you want to give names? press \n1. Yes\n2. No\n");
	    decision = Integer.parseInt(sc.nextLine());
	    if(decision == 1){
	    	System.out.printf("Please enter the names\n");
	        for(int i = 0; i < p; i++){
	            String temp;
	            temp = sc.nextLine();
	            name.add(temp);
	        }
	    }
	    else{
	        for(int i = 0; i < p; i++){
	            String temp = "p" + (i+1);;
	            name.add(temp);
	        }
	    }

	    int boardpositionarrayindex = 0; //board index, for mapping purpose;
	    int chal = 0; //for counting the number of dice rolls;
		
	    //Game starts
	    while(true){
	        int pause;
	        System.out.printf("enter any key to roll the dice: \n");
	        pause = Integer.parseInt(sc.nextLine());

	        //rolling the dice;
	        player.add(0, game.rolldice(player.get(0)));

//	        //kana checker
//	        if(player.get(0) == 1){
//	            System.out.println(name.get(0) +" Entered the game");
//	            start.add(0, true);
//	        }else if(start.get(0) == false){
//	        	player.add(0, 0);
//	        	player.add(player.get(0));
//	            player.remove(0);
//	            name.add(name.get(0));
//	            name.remove(0);
//	            System.out.println("Kana uthe nai");
//	            System.out.println(name.get(0) + " - player er chal");
//	            continue;
//	        }


	        if(start.get(0) == false){
	            //Won checker + message;
	            if(player.get(0) >= 100){
	                System.out.println(name.get(0) + " game jitsos");
	                System.out.printf(":D won won. \n%d chal e jitsos. JOSS!\n", chal);
	                player.add(0, 100);
	                game.displayboard(player, name);
	                break;
	            }

	            boardpositionarrayindex = game.boardposition(player.get(0));

	            game.displayboard(player, name);

	            if(Globals.shapKatse == true) player.add(0, board.board[boardpositionarrayindex]);
	            if(Globals.chongeUtsi == true) player.add(0, board.board[boardpositionarrayindex]);

	            //player and name swaping;
	            player.add(player.get(0));
	            player.remove(0);
	            name.add(name.get(0));
	            name.remove(name.get(0));
	            System.out.println(name.get(0) + " - player er chal");
	            chal++;
	        }
	    }
	
	}

}

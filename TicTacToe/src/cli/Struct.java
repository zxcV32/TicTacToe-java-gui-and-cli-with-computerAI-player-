 package cli;

import java.util.Scanner;

class move{
	int row=0,col=0;
}

 public class Struct {
	 static char player;
	 static char opponent;
	 
	public static void main(String[] args) throws InterruptedException {
		char board[][] =
			{
				{ '_', '_', '_' },
				{ '_', '_', '_' },
				{ '_', '_', '_' }
			};
		int combos[][]= {{1, 2, 3},{4, 5, 6},{7, 8, 9},
			      {1, 4, 7},{2, 5, 8},{3, 6, 9},
			      {1, 5, 9},{3, 5, 7}};
				
		int i=0,j = 0,k,l,sum=0;
		boolean carryon=false;
		int chance=1;
		int i1,j1;
		Scanner sc=new Scanner(System.in);
		move bestMove;
		boolean gameover=false;
		System.out.println("select mode\n1) Player 1 VS Player 2\n2) Player VS Computer");
		int mode = sc.nextInt();
		
		while(true) {
			player =(chance==1)?'x':'o';
			opponent =(chance!=1)?'x':'o';
			System.out.println("it's "+ player +" turn");		

		
		if(player=='x' || mode == 1) {
			i1=sc.nextInt();
			j1=sc.nextInt();
		}else {
			bestMove = findBestMove(board);
			Thread.sleep(500);
			i1=bestMove.row;
			j1=bestMove.col;	
		}
		
		//	System.out.println("ROW:" + bestMove.row +"col:"+bestMove.col );
		
		board[i1][j1]=(chance==1)?'x':'o';
		chance = 1-chance;
		display(board);
		for(i=0;i<8;++i) {
			sum=0;
			for(j=0;j<3;++j) {
				k=(combos[i][j]-1)/3;
				l=(combos[i][j]-1)%3;
				if(board[k][l]!='_')
					sum+=(board[k][l]=='x')?10:-10;
			}
			if(sum==30) {
				System.out.println("x won");
				gameover=true;
				break;
			}
			else if(sum==-30) {
				System.out.println("o won");			
				gameover=true;
				break;
			}
		}
		if(gameover==true)
			break;
		
		carryon=false;
		for(k=0;k<3;++k) {
			for(l=0;l<3;++l) {
				if(board[k][l]=='_')
					carryon=true;
			}
		}
		if(carryon==false)
			break;
		}
		
		if(i==8 && j==3)
			System.out.println("Draw");
	}
	 static boolean isMovesLeft(char board[][]){
	 	for (int i = 0; i<3; i++)
	 		for (int j = 0; j<3; j++)
	 			if (board[i][j]=='_')
	 				return true;
	 	return false;
	 }
	 
	 static int evaluate(char b[][]){
	 	for (int row = 0; row<3; row++){
	 		if (b[row][0]==b[row][1] && b[row][1]==b[row][2]){
	 			if (b[row][0]==player)
	 				return +10;
	 			else if (b[row][0]==opponent)
	 				return -10;
	 		}
	 	}
	 	for (int col = 0; col<3; col++){
	 		if (b[0][col]==b[1][col] && b[1][col]==b[2][col]){
	 			if (b[0][col]==player)
	 				return +10;

	 			else if (b[0][col]==opponent)
	 				return -10;
	 		}
	 	}
	 	if (b[0][0]==b[1][1] && b[1][1]==b[2][2]){
	 		if (b[0][0]==player)
	 			return +10;
	 		else if (b[0][0]==opponent)
	 			return -10;
	 	}

	 	if (b[0][2]==b[1][1] && b[1][1]==b[2][0]){
	 		if (b[0][2]==player)
	 			return +10;
	 		else if (b[0][2]==opponent)
	 			return -10;
	 	}
	 	return 0;
	 }
	 
	 static int minimax(char board[][], int depth, boolean isMax){
	 	int score = evaluate(board);
	 	if (score == 10)
	 		return score;
	 	if (score == -10)
	 		return score;
	 	if (isMovesLeft(board)==false)
	 		return 0;
	 	if (isMax){
	 		int best = -1000;
	 		for (int i = 0; i<3; i++){
	 			for (int j = 0; j<3; j++){
	 				if (board[i][j]=='_'){
	 					board[i][j] = player;
	 					best = Math.max( best,minimax(board, depth+1, !isMax) );
	 					board[i][j] = '_';
	 				}
	 			}
	 		}
	 		return best;
	 	}
	 	else{
	 		int best = 1000;
	 		for (int i = 0; i<3; i++){
	 			for (int j = 0; j<3; j++){
	 				if (board[i][j]=='_'){
	 					board[i][j] = opponent;
	 					best = Math.min(best,minimax(board, depth+1, !isMax));
	 					board[i][j] = '_';
	 				}
	 			}
	 		}
	 		return best;
	 	}
	 }
	 static move findBestMove(char board[][]){
	 	int bestVal = -1000;
	 	move bestMove = new move();
	 	bestMove.row = -1;
	 	bestMove.col = -1;
	 	for (int i = 0; i<3; i++){
	 		for (int j = 0; j<3; j++){
	 			if (board[i][j]=='_'){
	 				board[i][j] = player;
	 				int moveVal = minimax(board, 0, false);
	 				board[i][j] = '_';
	 				if (moveVal > bestVal){
	 					bestMove.row = i;
	 					bestMove.col = j;
	 					bestVal = moveVal;
	 				}
	 			}
	 		}
	 	}
	 	return bestMove;
	 }
	private static void display(char[][] board) {
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j)
				System.out.print(board[i][j]+" ");
		System.out.println();
		}
		
	}

}

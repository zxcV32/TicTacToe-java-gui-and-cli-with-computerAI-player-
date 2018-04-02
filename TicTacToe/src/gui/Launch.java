package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class move{
	int row=0,col=0;
}
public class Launch extends JFrame {
	 static char player;
	 static char opponent;
	 static char board[][] =
			{
				{ '_', '_', '_' },
				{ '_', '_', '_' },
				{ '_', '_', '_' }
			};
	 static JButton button_8=new JButton(),button_7=new JButton(),button_6=new JButton(),button_5=new JButton(),button_4=new JButton(),button_3=new JButton(),button_2=new JButton(),button_1=new JButton(),button=new JButton();
	 
	 static JButton butt[][]= {{button_8,button_7,button_6},
	 							{button_3,button_4,button_5},
	 							{button_2,button_1,button},
			 
	 		};
	 static int chance=1;
	 static int i2=-1,j2=-1;
	 static int mode=-1;
	 static int combos[][]= {{1, 2, 3},{4, 5, 6},{7, 8, 9},
		      {1, 4, 7},{2, 5, 8},{3, 6, 9},
		      {1, 5, 9},{3, 5, 7}};
			
	static int i=0,j = 0,k,l;
	static int sum=0;
	static boolean carryon=false;
	static int i1,j1;
	Scanner sc=new Scanner(System.in);
	static move bestMove;
	static boolean gameover=false;
	 private JPanel contentPane;
	 static JLabel lblStatusLabel=new JLabel();
	 static JButton btnPlayerVsPlayer;
	 static JButton btnPlayerVsComputer;
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launch frame = new Launch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true)
			play();
	}

	private static void reset() {
		chance=1;
		i2=-1;j2=-1;
		i=0;j = 0;
		sum=0;
		carryon=false;
		gameover=false;
		button.setEnabled(false);
		button_1.setEnabled(false);
		button_2.setEnabled(false);
		button_3.setEnabled(false);
		button_4.setEnabled(false);
		button_5.setEnabled(false);
		button_6.setEnabled(false);
		button_7.setEnabled(false);
		button_8.setEnabled(false);
		button.setIcon(null); 
		button_1.setIcon(null); 
		button_2.setIcon(null); 
		button_3.setIcon(null); 
		button_4.setIcon(null); 
		button_5.setIcon(null); 
		button_6.setIcon(null); 
		button_7.setIcon(null); 
		button_8.setIcon(null); 
		  for(i=0;i<3;++i)
			  for(j=0;j<3;++j)
				  board[i][j]='_';
	}

	/**
	 * Create the frame.
	 */
	public Launch() {
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 471);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewGame = new JMenu("New Game");
		menuBar.add(mnNewGame);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		button.setEnabled(false);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button.getIcon()==null) {
				button.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=2;
				j2=2;
				}
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(228, 278, 110, 110);
		contentPane.add(button);
		button_1.setEnabled(false);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_1.getIcon()==null) {
				button_1.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=2;
				j2=1;
				}
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(119, 278, 110, 110);
		contentPane.add(button_1);
		button_2.setEnabled(false);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_2.getIcon()==null) {
				button_2.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=2;
				j2=0;
				}
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(10, 278, 110, 110);
		contentPane.add(button_2);
		button_3.setEnabled(false);
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_3.getIcon()==null) {
				button_3.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=1;
				j2=0;
				}
			}
		});
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(10, 169, 110, 110);
		contentPane.add(button_3);
		button_4.setEnabled(false);
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_4.getIcon()==null) {
					button_4.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
					i2=1;
					j2=1;
				}
			}
		});
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(119, 169, 110, 110);
		contentPane.add(button_4);
		button_5.setEnabled(false);
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_5.getIcon()==null) {
				button_5.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=1;
				j2=2;
				}
			}
		});
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(228, 169, 110, 110);
		contentPane.add(button_5);
		button_6.setEnabled(false);
		
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_6.getIcon()==null) {
					button_6.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
					i2=0;
					j2=2;
				}
			}
		});
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(228, 60, 110, 110);
		contentPane.add(button_6);
		button_7.setEnabled(false);
		
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_7.getIcon()==null) {
				button_7.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=0;
				j2=1;
				}
			}
		});
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(119, 60, 110, 110);
		contentPane.add(button_7);
		button_8.setEnabled(false);
		
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 92));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(button_8.getIcon()==null) {
				button_8.setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
				i2=0;
				j2=0;
				}
			}
		});
		button_8.setForeground(Color.BLACK);
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(10, 60, 110, 110);
		contentPane.add(button_8);
		
		lblStatusLabel.setText("Select Game Mode First!");
		lblStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusLabel.setBounds(10, 10, 600, 44);
		contentPane.add(lblStatusLabel);
		
		JLabel lblPlayer = new JLabel("Player: ");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer.setBounds(348, 60, 126, 28);
		contentPane.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player:");
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer_1.setBounds(348, 98, 126, 28);
		contentPane.add(lblPlayer_1);
		
		JLabel lblTie = new JLabel("Tie:");
		lblTie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTie.setBounds(348, 136, 126, 28);
		contentPane.add(lblTie);
		
		JLabel lblTotalGames = new JLabel("Total Games :");
		lblTotalGames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalGames.setBounds(348, 174, 126, 28);
		contentPane.add(lblTotalGames);
		
		JLabel lblChooseGameMode = new JLabel("Choose Game Mode");
		lblChooseGameMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseGameMode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChooseGameMode.setBounds(348, 212, 262, 28);
		contentPane.add(lblChooseGameMode);
		
		btnPlayerVsPlayer = new JButton("Player1 Vs Player2");
		btnPlayerVsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			reset();
			mode=1;
			button.setEnabled(true);
			button_1.setEnabled(true);
			button_2.setEnabled(true);
			button_3.setEnabled(true);
			button_4.setEnabled(true);
			button_5.setEnabled(true);
			button_6.setEnabled(true);
			button_7.setEnabled(true);
			button_8.setEnabled(true);
			}
		});
		btnPlayerVsPlayer.setBounds(402, 250, 150, 21);
		contentPane.add(btnPlayerVsPlayer);
		
		btnPlayerVsComputer = new JButton("Player Vs Computer");
		btnPlayerVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			reset();
			mode=2;
			button.setEnabled(true);
			button_1.setEnabled(true);
			button_2.setEnabled(true);
			button_3.setEnabled(true);
			button_4.setEnabled(true);
			button_5.setEnabled(true);
			button_6.setEnabled(true);
			button_7.setEnabled(true);
			button_8.setEnabled(true);
			}
		});
		btnPlayerVsComputer.setBounds(402, 281, 150, 21);
		contentPane.add(btnPlayerVsComputer);
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

	 	// Checking for Columns for X or O victory.
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

	 					// Call minimax recursively and choose
	 					// the minimum value
	 					best = Math.min(best,minimax(board, depth+1, !isMax));

	 					// Undo the move
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
	 private static void play() throws InterruptedException {
			while(mode==-1)
				lblStatusLabel.setText(lblStatusLabel.getText());
			
			while(true) {	
				player =(chance==1)?'x':'o';
				opponent =(chance!=1)?'x':'o';
				
				while((i2==-1 && j2==-1 && mode==1) || (mode==2 && player=='x' && i2==-1 && j2==-1)) {
					lblStatusLabel.setText("it's "+ player +" turn");
				}
							
			
			System.out.println("gui input "+i2+"\t"+j2);
			
				if((mode == 2 && player=='x') || mode==1) {
					i1=i2;
					j1=j2;
					board[i1][j1]=(chance==1)?'x':'o';
					i2=-1;
					j2=-1;
				}else {
					bestMove = findBestMove(board);
					System.out.println("computer chooses "+bestMove.row+"\t"+bestMove.col);
					Thread.sleep(500);
					i1=bestMove.row;
					j1=bestMove.col;	
					butt[i1][j1].setIcon(new ImageIcon((chance==1)?"x.png":"o.png")); 
					board[i1][j1]=(chance==1)?'x':'o';
				}	
				
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
					btnPlayerVsPlayer.setEnabled(false);
					btnPlayerVsComputer.setEnabled(false);
					button.setEnabled(false);
					button_1.setEnabled(false);
					button_2.setEnabled(false);
					button_3.setEnabled(false);
					button_4.setEnabled(false);
					button_5.setEnabled(false);
					button_6.setEnabled(false);
					button_7.setEnabled(false);
					button_8.setEnabled(false);
					System.out.println("x won");
					for(k=0;k<3;++k) {
						lblStatusLabel.setText("X won!");
						Thread.sleep(250);
						lblStatusLabel.setText("");
						Thread.sleep(100);
					}
					lblStatusLabel.setText("X won!");
					gameover=true;
					break;
				}
				else if(sum==-30) {
					btnPlayerVsComputer.setEnabled(false);
					btnPlayerVsPlayer.setEnabled(false);
					button.setEnabled(false);
					button_1.setEnabled(false);
					button_2.setEnabled(false);
					button_3.setEnabled(false);
					button_4.setEnabled(false);
					button_5.setEnabled(false);
					button_6.setEnabled(false);
					button_7.setEnabled(false);
					button_8.setEnabled(false);
					System.out.println("o won");
					for(k=0;k<3;++k) {
						lblStatusLabel.setText("O won!");
						Thread.sleep(250);
						lblStatusLabel.setText("");
						Thread.sleep(100);
					}
					lblStatusLabel.setText("O won!");
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
			
			if(i==8 && j==3) {
				btnPlayerVsComputer.setEnabled(false);
				btnPlayerVsPlayer.setEnabled(false);
				System.out.println("Draw");
				for(k=0;k<3;++k) {
					lblStatusLabel.setText("It's a draw!");
					Thread.sleep(500);
					lblStatusLabel.setText("");
					Thread.sleep(250);
				}
				lblStatusLabel.setText("It's a draw!");
			}
			
			btnPlayerVsComputer.setEnabled(true);
			btnPlayerVsPlayer.setEnabled(true);
			mode=-1;
			while(mode==-1)
				lblStatusLabel.setText(lblStatusLabel.getText());
			reset();
	 }
	private static void display(char[][] board) {
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j)
				System.out.print(board[i][j]+" ");
		System.out.println();
		}
	}
}

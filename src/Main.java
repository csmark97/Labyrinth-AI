
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {	    
		Scanner sc = new Scanner(System.in);
		
		Maze maze = new Maze();
		int itemCount = 0;
		
		while(sc.hasNextLine()) {			
			String line[] = sc.nextLine().split(" ");
			
			if (line.length == 1) {
				itemCount = Integer.parseInt(line[0]);
				break;
			}
			
			ArrayList<Integer> values = new ArrayList<Integer>();
			for (int i = 0; i < line.length ; i++) {
				values.add(Integer.parseInt(line[i]));
			}			
			maze.setValues(values);			
			maze.addRow();			
		}
		
		maze.setItems(itemCount);
		sc.close();				
		
		maze.updateMazeFields();

		Player playerOne = new Player();
		playerOne.setMaze(maze);		
		playerOne.FindAll();
	}
}


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Player {
	private Maze maze = new Maze();
	private LinkedList<Field> steps;
	private int allItems;
	
	public void setMaze(Maze maze) {
		this.maze = maze;
		allItems = maze.getItems();
	}	

    public Field BFS(Field s) {
	    List<Field> order = new ArrayList<>();
	    order.add(s);
        s.setCameFrom(null);
        maze.forgetVisits();
        LinkedList<Field> queue = new LinkedList<Field>(); 
        s.setVisited(true);
        queue.add(s); 
  
        while (queue.size() != 0) {  
            s = queue.poll();
            List<Field> neighbours = s.getNeighbours();
            for (Field f : neighbours) {
                if (!f.isVisited()) { 
                	f.setCameFrom(s);
                    f.setVisited(true);
                    queue.add(f);
	                order.add(f);
	                if (f.isItem() || (allItems == 0 && f.equals(maze.getFields().get(maze.getRowCount() - 1).get(maze.getColumnCount() - 1)))) {
						allItems--;
						for (Field fi = f; fi != null; fi = fi.getCameFrom()) {
							steps.add(fi);
						}						
						Collections.reverse(steps);
						return f;
					}                    
                }                
            }
        }

        for (Field f : order){
	        System.out.println(f.getCoordinate().getX() + " " + f.getCoordinate().getY());
        }
	    throw new RuntimeException("Lehetetlen labirintus");
    }
    
    public void FindAll() {
    	Field actual = maze.getFields().get(0).get(0);
    	int originalItems = allItems;
		for (int i = 0; i <= originalItems; i++) {
    		 steps = new LinkedList<Field>();
    		 actual = BFS(actual);
    		 if (!steps.isEmpty()) {
    			 steps.removeFirst();
    		 }
    		 
    		 for (Field f : steps) {
    				System.out.println(f.getCoordinate().toString());
    				if(f.isItem()) {
    					System.out.println("felvesz");
    					f.setItem(false);
    				}
				}
		}
    }
}

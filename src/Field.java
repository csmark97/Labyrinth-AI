import java.util.ArrayList;
import java.util.List;

public class Field {
	private Coordinate coordinate = new Coordinate();
	private int value;

	private Field north;
	private Field east;
	private Field south;
	private Field west;
	private boolean isItem = false;
	private boolean isVisited = false;
	private Field cameFrom;

	public List<Field> getNeighbours() {
		List<Field> neighbours = new ArrayList<Field>();
		if (north != null) {
			neighbours.add(north);
		}
		if (east != null) {
			neighbours.add(east);
		}
		if (south != null) {
			neighbours.add(south);
		}
		if (west != null) {
			neighbours.add(west);
		}
		return neighbours;
	}
	
	public void setNeighbours(Maze maze) {
		int value = this.value;
		/*
		 * |A|B|C| 
		 * |D|E|F| 
		 * |G|H|I|
		 * --------------------------------------------------------->M�trix esetei bet�jelekkel:
		 */

		if (coordinate.getX() == 0 && coordinate.getY() == 0) { // A
			north = null;
			east = maze.getFields().get(coordinate.getX()).get(coordinate.getY() + 1);
			south = maze.getFields().get(coordinate.getX() + 1).get(coordinate.getY());
			west = null;
		} else if (coordinate.getX() == 0 && coordinate.getY() == maze.getColumnCount() - 1) { // C
			north = null;
			east = null;
			south = maze.getFields().get(coordinate.getX() + 1).get(coordinate.getY());
			west = maze.getFields().get(coordinate.getX()).get(coordinate.getY() - 1);
		} else if (coordinate.getX() == maze.getRowCount() - 1 && coordinate.getY() == 0) { // G
			north = maze.getFields().get(coordinate.getX() - 1).get(coordinate.getY());
			east = maze.getFields().get(coordinate.getX()).get(coordinate.getY() + 1);
			south = null;
			west = null;
		} else if (coordinate.getX() == maze.getRowCount() - 1 && coordinate.getY() == maze.getColumnCount() - 1) { // I
			north = maze.getFields().get(coordinate.getX() - 1).get(coordinate.getY());
			east = null;
			south = null;
			west = maze.getFields().get(coordinate.getX()).get(coordinate.getY() - 1);
		} else if (coordinate.getX() == 0) { // B
			north = null;
			east = maze.getFields().get(coordinate.getX()).get(coordinate.getY() + 1);
			south = maze.getFields().get(coordinate.getX() + 1).get(coordinate.getY());
			west = maze.getFields().get(coordinate.getX()).get(coordinate.getY() - 1);
		} else if (coordinate.getY() == 0) { // D
			north = maze.getFields().get(coordinate.getX() - 1).get(coordinate.getY());
			east = maze.getFields().get(coordinate.getX()).get(coordinate.getY() + 1);
			south = maze.getFields().get(coordinate.getX() + 1).get(coordinate.getY());
			west = null;
		} else if (coordinate.getX() == maze.getRowCount() - 1) { // H
			north = maze.getFields().get(coordinate.getX() - 1).get(coordinate.getY());
			east = maze.getFields().get(coordinate.getX()).get(coordinate.getY() + 1);
			south = null;
			west = maze.getFields().get(coordinate.getX()).get(coordinate.getY() - 1);
		} else if (coordinate.getY() == maze.getColumnCount() - 1) { // F
			north = maze.getFields().get(coordinate.getX() - 1).get(coordinate.getY());
			east = null;
			south = maze.getFields().get(coordinate.getX() + 1).get(coordinate.getY());
			west = maze.getFields().get(coordinate.getX()).get(coordinate.getY() - 1);
		} else { // E
			north = maze.getFields().get(coordinate.getX() - 1).get(coordinate.getY());
			east = maze.getFields().get(coordinate.getX()).get(coordinate.getY() + 1);
			south = maze.getFields().get(coordinate.getX() + 1).get(coordinate.getY());
			west = maze.getFields().get(coordinate.getX()).get(coordinate.getY() - 1);
		}

		if (value >= 16) {
			isItem = true;
			value = value - 16;
		}

		if (value >= 8) {
			west = null;
			value = value - 8;
		}

		if (value >= 4) {
			south = null;
			value = value - 4;
		}

		if (value >= 2) {
			east = null;
			value = value - 2;
		}

		if (value >= 1) {
			north = null;
			value = value - 1;
		}
	}

	public Field(Coordinate coordinate, int value) {
		super();
		this.coordinate = coordinate;
		this.value = value;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Field getNorth() {
		return north;
	}

	public Field getEast() {
		return east;
	}

	public Field getSouth() {
		return south;
	}

	public Field getWest() {
		return west;
	}
	
	public Field getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(Field cameFrom) {
		this.cameFrom = cameFrom;
	}

	public boolean isItem() {
		return isItem;
	}

	public void setItem(boolean isItem) {
		this.isItem = isItem;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}

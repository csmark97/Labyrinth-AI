import java.util.ArrayList;

public class Maze {
	private ArrayList<ArrayList<Field>> fields = new ArrayList<ArrayList<Field>>();	
    private ArrayList<Integer> values = new ArrayList<Integer>();
    private int columnCount = 0;
    private int rowCount = 0;
    private int items;
    
	public ArrayList<Integer> getValues() {
		return values;
	}
	
	public void setValues(ArrayList<Integer> values) {
		this.values = values;
		columnCount = values.size();
	}
	
	public void addRow() {
		ArrayList<Field> f = new ArrayList<Field>();
		for(int i = 0; i < columnCount; i++) {
			Coordinate c = new Coordinate(rowCount, i);
			Field field = new Field(c, values.get(i));
			f.add(field);
		}
		fields.add(f);
		rowCount++;
		this.values = new ArrayList<Integer>();
	}
	
	public void updateMazeFields() {
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				fields.get(i).get(j).setNeighbours(this);
			}
		}
	}
	
	public void forgetVisits() {
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				fields.get(i).get(j).setVisited(false);
				fields.get(i).get(j).setCameFrom(null);
			}
		}
	}
	
	public int getColumnCount() {
		return columnCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public ArrayList<ArrayList<Field>> getFields() {
		return fields;
	}
	
	//Only fo test
	
	public void getMaze() {		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				System.out.print(fields.get(i).get(j).getValue() + " ");
			}
			System.out.println();
		}
	}
	
	public void getMazeWithCoords() {		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				System.out.print("(" + fields.get(i).get(j).getCoordinate().getX() + ";" + fields.get(i).get(j).getCoordinate().getY() + ")");
			}
			System.out.println();
		}
	}
	
	public void getNeighbours() {
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				System.out.println("--------------------------");
				System.out.println("(" + fields.get(i).get(j).getCoordinate().getX() + ";" + fields.get(i).get(j).getCoordinate().getY() + ") mez� szomsz�dai:");
				
				if (fields.get(i).get(j).getNorth() != null) {
					System.out.println("�szak: (" + fields.get(i).get(j).getNorth().getCoordinate().getX() + ";" + fields.get(i).get(j).getNorth().getCoordinate().getY() + ")");
				} else {
					System.out.println("�szak: nincs");
				}
				if (fields.get(i).get(j).getEast() != null) {
					System.out.println("Kelet: (" + fields.get(i).get(j).getEast().getCoordinate().getX() + ";" + fields.get(i).get(j).getEast().getCoordinate().getY()+ ")");
				} else {
					System.out.println("Kelet: nincs");
				}
				if (fields.get(i).get(j).getSouth() != null) {
					System.out.println("D�l: (" + fields.get(i).get(j).getSouth().getCoordinate().getX() + ";" + fields.get(i).get(j).getSouth().getCoordinate().getY() + ")");
				} else {
					System.out.println("D�l: nincs");
				}
				if (fields.get(i).get(j).getWest() != null) {
					System.out.println("Nyugat: (" + fields.get(i).get(j).getWest().getCoordinate().getX() + ";" + fields.get(i).get(j).getWest().getCoordinate().getY() + ")");
				} else {
					System.out.println("Nyugat: nincs");
				}
				if (fields.get(i).get(j).isItem()) {
					System.out.println("T�rgy!");
				}
				System.out.println("--------------------------");
			}
		}
	}
}

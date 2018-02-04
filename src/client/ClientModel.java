package client;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

public class ClientModel extends AbstractTableModel{

	private String[] columnNames = { "Item Name", "Owner", "Category",
	        "Status", "Borrower", "Borrowed Date", "Returned Date" };
	/*private Object[][] data = {
	        { "Gremlins", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Diehard", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Christmas Carol", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Braveheart", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Signs", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "The Village", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        };*/
	
	private Object[][] data = new Object [100][7];
	private int i=0;
	private BorrowMyStuffClient client;
	
	public ClientModel(BorrowMyStuffClient client) {
		this.client = client;
		/*data[i][0]= "Gremins";
		data[i][1]= "Gremins";
		data[i][2]= "Gremins";
		data[i][3]= "Gremins";
		data[i][4]= "Gremins";
		data[i][5]= "Gremins";
		data[i][6]= "Gremins";
		i++;*/
		/*data[1][0]= "Gremins2";
		data[1][1]= "Gremins2";
		data[1][2]= "Gremins2";
		data[1][3]= "Gremins2";
		data[1][4]= "Gremins2";
		data[1][5]= "Gremins2";
		data[1][6]= "Gremins2";*/
	
	}

	public void addItem(String itemName, String owner, String category, String status){
		data[i][0]= itemName;
		data[i][1]= owner;
		data[i][2]= category;
		data[i][3]= status;
		data[i][4]= "";
		data[i][5]= "";
		data[i][6]= "";	
		Item item = new Item(itemName,category);
		client.send(item);
		i++;
	}
	

	public Item getItem() {
		// TODO Auto-generated method stub
		return null;
	}


	public void removeItem(int i) {
		Item item = new Item((String)data[i][0], (String)data[i][2]);
		data[i][0]= "";
		data[i][1]= "";
		data[i][2]= "";
		data[i][3]= "";
		data[i][4]= "";
		data[i][5]= "";
		data[i][6]= "";	
		
		
		client.send(item);
		i--;

	}


	public Object getValueAt(int row, int column) {
		return data[row][column];
		//return data2.get(row).get(column);
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getRowCount() {
		return data.length;
		//return data2.size();
	}


	public int getColumnCount() {
		return columnNames.length;
	}
	
	public void borrowItem(int i, String borrower, String borrowDate) {
		data[i][3]= "Unavailable";
		data[i][4]= borrower;
		data[i][5]= borrowDate;
		data[i][6]= "";
	}
	
	public void returnItem(int i, String returnDate) {
		data[i][3]= "Available";
		data[i][6]= returnDate;
	}

}

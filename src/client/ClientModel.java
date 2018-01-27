package client;

import javax.swing.table.AbstractTableModel;

public class ClientModel extends AbstractTableModel implements ModelInterface {

	/*private int numberOfRows;
	private ResultSet resultSet;
	private ResultSet resultSetRetrieve;
	private ResultSetMetaData metaData;
	private ArrayList<Item> itemList = new ArrayList();*/
	private String[] columnNames = { "Item Name", "Owner", "Category",
	        "Status", "Borrower", "Borrowed Date", "Returned Date" };
	private Object[][] data = {
	        { "Gremlins", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Diehard", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Christmas Carol", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Braveheart", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "Signs", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        { "The Village", "Kevin", "Movie", "Available", "Lua", "Today", "Tomorrow"},
	        };


	@Override
	public Item getItem() {
		// TODO Auto-generated method stub

		return null;

	}

	@Override
	public void removeItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValueAt(int row, int column) {
		return data[row][column];
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

}

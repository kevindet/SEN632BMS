package client;


public interface ModelInterface {
	public Item getItem();

    public void removeItem();

    public Object getValueAt(int row, int column);
    
    public void addItem(String itemName, String owner, String category, String status);
    
    public void fireTableDataChanged();
    
    public void borrowItem(int row,String borrower, String borrowDate);
    
    public void returnItem(int row,String returnDate);

}

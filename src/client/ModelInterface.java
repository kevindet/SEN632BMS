package client;


public interface ModelInterface {
	public Item getItem();

    public void removeItem();

    public Object getValueAt(int row, int column);
    
    public void addItem(String itemName, String owner, String category, String status);
    
    public void fireTableDataChanged();

}

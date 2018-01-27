package client;


public interface ModelInterface {
	public Item getItem();

    public void removeItem();

    public Object getValueAt(int row, int column);
    
    public void addItem();
    
    public void fireTableDataChanged();

}

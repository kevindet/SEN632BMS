package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;



public class BorrowMyStuffView extends JFrame {

	private BorrowMyStuffClient client;
	private ModelInterface model;
	private JPanel contentPanel = new JPanel();
	private Item item;
	private JMenuItem addMenuItem;
    private JMenuItem searchMenuItem;
    private JMenuItem editMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    private JTable itemTable;
    private JScrollPane listScrollPane;
    private JPopupMenu popupMenu;
    private JToolBar toolBar;
    private JButton addItemButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JRadioButton bookRadioButton;
    private JRadioButton cdRadioButton;
    private JRadioButton dvdRadioButton;
    private ButtonGroup radioButtonGroup;
    private JPanel radioButtonPanel;
    //private TableColumnModel column = {"Name","Category","Status"};         

	public BorrowMyStuffView(BorrowMyStuffClient client, ModelInterface model) {
		super("Borrow My Stuff");
		
		this.client = client;
		this.model = model;
		this.add(contentPanel);
		JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        
        addMenuItem = fileMenu.add(new addAction("Add Item"));
        addMenuItem.setMnemonic('I');
       
        fileMenu.addSeparator();

        searchMenuItem = fileMenu.add(new searchAction("Search"));
        searchMenuItem.setMnemonic('S');
        fileMenu.addSeparator();
        exitMenuItem = fileMenu.add(new exitAction("Exit"));
        exitMenuItem.setMnemonic('E');
        editMenuItem = editMenu.add(new editAction("Edit"));
        editMenuItem.setMnemonic('E');
        deleteMenuItem = editMenu.add(new deleteAction("Delete"));
        deleteMenuItem.setMnemonic('D');
        aboutMenuItem = helpMenu.add(new aboutAction("About"));
        aboutMenuItem.setMnemonic('A');
        
        
        setJMenuBar(menuBar);
        
        
        
        
        
        toolBar = new JToolBar();

        Icon itemIcon = null;
        Icon editIcon = null;
        Icon searchIcon = null;
        Icon deleteIcon = null;

        try {
            itemIcon = new ImageIcon(getClass().getResource("/images/book.jpg"));
            editIcon = new ImageIcon(getClass().getResource("/images/edit.jpg"));
            searchIcon = new ImageIcon(getClass().getResource(
                    "/images/search.jpg"));
            deleteIcon = new ImageIcon(getClass().getResource(
                    "/images/delete.jpg"));
        } catch (Exception e) {
            System.out.println("Error could not load image icons");
        }

        
        JButton addButton = new JButton(itemIcon);
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				itemTable.getValueAt(itemTable.getSelectedRow(), 0);
				//itemTable.getValueAt(itemTable.getSelectedRow(), 1);
				itemTable.getValueAt(itemTable.getSelectedRow(), 2);
				/*itemTable.getValueAt(itemTable.getSelectedRow(), 3);
				itemTable.getValueAt(itemTable.getSelectedRow(), 4);
				itemTable.getValueAt(itemTable.getSelectedRow(), 5);*/
				item = new Item((String)itemTable.getValueAt(itemTable.getSelectedRow(), 0), (String)itemTable.getValueAt(itemTable.getSelectedRow(), 2));
				//item = new Item("Planet of the Apes", Category.MOVIE);
				item.toString();
				client.send(item);
			}
		});
        
        
        
        
        addItemButton = new JButton(itemIcon);
        toolBar.add(addItemButton);
        addItemButton
                .setToolTipText("Click this button to add a new book into inventory.");
        addItemButton.addActionListener(new addAction("Add Item"));


        toolBar.addSeparator();

        searchButton = new JButton(searchIcon);
        toolBar.add(searchButton);
        searchButton
                .setToolTipText("Click this button to search for an item from inventory.");
        searchButton.addActionListener(new searchAction("Search"));

        toolBar.addSeparator();

        editButton = new JButton(editIcon);
        toolBar.add(editButton);
        editButton
                .setToolTipText("Click this button to edit an item from inventory.");
        editButton.addActionListener(new editAction("Edit"));

        toolBar.addSeparator();

        deleteButton = new JButton(deleteIcon);
        toolBar.add(deleteButton);
        deleteButton
                .setToolTipText("Click this button to delete an item from inventory.");
        deleteButton.addActionListener(new deleteAction("Delete"));

        add(toolBar, BorderLayout.NORTH);

        contentPanel = new JPanel(new BorderLayout());

        add(contentPanel);
        radioButtonPanel = new JPanel();

        /*bookRadioButton = new JRadioButton(new radioButtonAction("BOOK"));
        bookRadioButton.setSelected(true);
        cdRadioButton = new JRadioButton(new radioButtonAction("CD"));
        dvdRadioButton = new JRadioButton(new radioButtonAction("DVD"));
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(bookRadioButton);
        radioButtonGroup.add(cdRadioButton);
        radioButtonGroup.add(dvdRadioButton);
        radioButtonPanel.add(bookRadioButton);
        radioButtonPanel.add(cdRadioButton);
        radioButtonPanel.add(dvdRadioButton);
        contentPanel.add(radioButtonPanel, BorderLayout.NORTH);*/
        
        
        
        
        
        
        
        

		
		//contentPanel.add(addButton);
		
		
		
		listScrollPane = new JScrollPane();
        itemTable = new JTable((TableModel) model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        
        
        
        itemTable.setAutoCreateRowSorter(true);
        itemTable.setComponentPopupMenu(popupMenu);
        enableComponents(false);
        itemTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        if (itemTable.getSelectedRow() != -1) {
                            enableComponents(true);
                        } else {
                            enableComponents(false);
                        }
                    }
                });
        itemTable.setFillsViewportHeight(true);
        listScrollPane.setViewportView(itemTable);

        contentPanel.add(listScrollPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(getWidth(), getHeight()));
        pack();

        contentPanel.add(listScrollPane, BorderLayout.CENTER);
		
		
		
		
		
		
	}
	
	
	
	public void enableComponents(boolean b) {
       /*editButton.setEnabled(b);
        editMenuItem.setEnabled(b);
        editPopUp.setEnabled(b);
        deleteButton.setEnabled(b);
        deleteMenuItem.setEnabled(b);
        deletePopUp.setEnabled(b);*/
    }
	
	private class addAction extends AbstractAction {
        public addAction(String name) {
            super(name);
        }

        public void actionPerformed(ActionEvent e) {
        	itemTable.getValueAt(itemTable.getSelectedRow(), 0);
			//itemTable.getValueAt(itemTable.getSelectedRow(), 1);
			itemTable.getValueAt(itemTable.getSelectedRow(), 2);
			/*itemTable.getValueAt(itemTable.getSelectedRow(), 3);
			itemTable.getValueAt(itemTable.getSelectedRow(), 4);
			itemTable.getValueAt(itemTable.getSelectedRow(), 5);*/
			item = new Item((String)itemTable.getValueAt(itemTable.getSelectedRow(), 0), (String)itemTable.getValueAt(itemTable.getSelectedRow(), 2));
			//item = new Item("Planet of the Apes", Category.MOVIE);
			item.toString();
			client.send(item);
        }
    }
	
	
	
	 private class editAction extends AbstractAction {
	        public editAction(String name) {
	            super(name);
	        }

	        public void actionPerformed(ActionEvent e) {
	          
	        }
	    }

	   

	    private class searchAction extends AbstractAction {
	        public searchAction(String name) {
	            super(name);
	        }

	        public void actionPerformed(ActionEvent e) {
	           
	        }
	    }

	    private class deleteAction extends AbstractAction {
	        public deleteAction(String name) {
	            super(name);
	        }

	        public void actionPerformed(ActionEvent e) {
	            
	        }
	    }

	    private class exitAction extends AbstractAction {
	        public exitAction(String name) {
	            super(name);
	        }

	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	        }
	    }
	    
	    private class aboutAction extends AbstractAction {
	        public aboutAction(String name) {
	            super(name);
	        }

	        public void actionPerformed(ActionEvent e) {
	            int option = JOptionPane
	                    .showConfirmDialog(
	                            BorrowMyStuffView.this,
	                            "Borrow My Stuff \n Version 1.0 \n Created by Kevin Detweiler and Kalei Lua \n SEN632 \n Jan 2018",
	                            "About", JOptionPane.CLOSED_OPTION,
	                            JOptionPane.INFORMATION_MESSAGE);
	        }
	    }

}

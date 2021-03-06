/**
 * ---------------------------------------------------------------------------
 * File name: AddressBookDriver.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 20, 2017
 * ---------------------------------------------------------------------------
 */

package addressBook;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import arrayOperations.ArrayOperations;
import util.Utility;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 20, 2017
 * <hr>
 * @author Justin Adams
 */
public class AddressBookDriver extends javax.swing.JFrame
{
	public AddressBook addressBook;					//Address of contacts
	String [ ] data = null;							//Tempery Holder for contact data
	final int IMPORT = 0;							//Constant for import data from file
	final int EXPORT = 1;							//Constant for export data to file
	Utility help = new Utility ( );					//Utility methods
	ArrayOperations sort = new ArrayOperations();
	/**
     * Creates new form Size
     */
    public AddressBookDriver()
    {
    	addressBook = new AddressBook ( );
    	help.loadAddressBook(addressBook);
    	help.sort(addressBook);
    	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        LetterListScrollPanel = new javax.swing.JPanel();
        letterListScrollPane = new javax.swing.JScrollPane();
        letterList = new javax.swing.JList<>();
        AddressBookScrollPanel = new javax.swing.JPanel();
        addressBookScrollPane = new javax.swing.JScrollPane();
        addressBookTable = new javax.swing.JTable();
        NewContactPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox<>();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        zipCodeLabel = new javax.swing.JLabel();
        zipCodeTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        typeLabel = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        LetterListScrollPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        letterList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        letterList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "All", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        letterList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        letterList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                letterListMouseClicked(evt);
            }
        });
        letterListScrollPane.setViewportView(letterList);

        javax.swing.GroupLayout LetterListScrollPanelLayout = new javax.swing.GroupLayout(LetterListScrollPanel);
        LetterListScrollPanel.setLayout(LetterListScrollPanelLayout);
        LetterListScrollPanelLayout.setHorizontalGroup(
            LetterListScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LetterListScrollPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(letterListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        LetterListScrollPanelLayout.setVerticalGroup(
            LetterListScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LetterListScrollPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(letterListScrollPane)
                .addGap(25, 25, 25))
        );

        AddressBookScrollPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AddressBookScrollPanel.setAutoscrolls(true);
        AddressBookScrollPanel.setOpaque(false);

        addressBookScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addressBookScrollPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressBookScrollPane.setOpaque(false);
        addressBookScrollPane.setPreferredSize(new java.awt.Dimension(452, 352));

        addressBookTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressBookTable.setModel(new javax.swing.table.DefaultTableModel(help.createModelData (addressBook), help.getNAMES ( ))
        {
            Class[] types = new Class []
            {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }
        });
        addressBookTable.setOpaque(false);
        addressBookTable.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                addressBookTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                addressBookTableFocusLost(evt);
            }
        });
        addressBookScrollPane.setViewportView(addressBookTable);

        javax.swing.GroupLayout AddressBookScrollPanelLayout = new javax.swing.GroupLayout(AddressBookScrollPanel);
        AddressBookScrollPanel.setLayout(AddressBookScrollPanelLayout);
        AddressBookScrollPanelLayout.setHorizontalGroup(
            AddressBookScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddressBookScrollPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(addressBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        AddressBookScrollPanelLayout.setVerticalGroup(
            AddressBookScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddressBookScrollPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(addressBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        NewContactPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        NewContactPanel.setOpaque(false);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(240, 240, 240));
        nameLabel.setText("Name:");

        addressLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(240, 240, 240));
        addressLabel.setText("Address:");

        cityLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cityLabel.setForeground(new java.awt.Color(240, 240, 240));
        cityLabel.setText("City:");

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cityTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        addressTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        stateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stateLabel.setForeground(new java.awt.Color(255, 255, 255));
        stateLabel.setText("State:");

        stateComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] 
        				{"AK", "AL", "AR","AZ", "CA",
						"CO", "CT", "DE", "FL", "GA",
						"HI", "IA", "ID", "IL", "IN",
						"KS", "KY", "LA","MA", "MD",
						"ME", "MI", "MN", "MO", "MS",
						"MT", "NC", "ND", "NE", "NH",
						"NJ", "NM","NV", "NY", "OH",
						"OK", "OR", "PA", "RI", "SC",
						"SD", "TN", "TX", "UT", "VA", 
						"VT", "WA","WI","WV", "WY"}));

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(240, 240, 240));
        emailLabel.setText("Email:");

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        zipCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zipCodeLabel.setForeground(new java.awt.Color(240, 240, 240));
        zipCodeLabel.setText("Zip Code:");

        zipCodeTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(240, 240, 240));
        phoneLabel.setText("Phone:");

        photoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        photoLabel.setForeground(new java.awt.Color(240, 240, 240));
        photoLabel.setText("No Photo");
        photoLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        photoLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                photoLabelMouseClicked(evt);
            }
        });

        typeComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OWNER", "FAMILY", "CHRUCH", "FRIEND", "BUSINESSCOLLEAGUE", "SERVICEPERSON", "CUSTOMER", "OTHER" }));

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(240, 240, 240));
        typeLabel.setText("Contact Type:");

        javax.swing.GroupLayout NewContactPanelLayout = new javax.swing.GroupLayout(NewContactPanel);
        NewContactPanel.setLayout(NewContactPanelLayout);
        NewContactPanelLayout.setHorizontalGroup(
            NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewContactPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(NewContactPanelLayout.createSequentialGroup()
                        .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cityLabel)
                            .addComponent(addressLabel)
                            .addComponent(emailLabel))
                        .addGap(15, 15, 15)
                        .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressTextField)
                            .addComponent(emailTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewContactPanelLayout.createSequentialGroup()
                                .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(stateLabel)
                                .addGap(15, 15, 15)
                                .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(NewContactPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(nameLabel)
                        .addGap(15, 15, 15)
                        .addComponent(nameTextField)))
                .addGap(15, 15, 15)
                .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(typeLabel)
                    .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NewContactPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(phoneLabel))
                        .addComponent(zipCodeLabel)))
                .addGap(15, 15, 15)
                .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zipCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(phoneTextField)
                    .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        NewContactPanelLayout.setVerticalGroup(
            NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewContactPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewContactPanelLayout.createSequentialGroup()
                        .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeLabel))
                        .addGap(15, 15, 15)
                        .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stateLabel)
                                .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(zipCodeLabel))
                            .addComponent(cityLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NewContactPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLabel)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(NewContactPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(NewContactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneLabel)))))
                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        ButtonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ButtonPanel.setOpaque(false);

        addButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.setPreferredSize(new java.awt.Dimension(77, 25));
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateButton.setText("Update");
        updateButton.setPreferredSize(new java.awt.Dimension(77, 25));
        updateButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                updateButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        ButtonPanelLayout.setVerticalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(addButton)
                .addGap(10, 10, 10)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(exitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LetterListScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewContactPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddressBookScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LetterListScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewContactPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(AddressBookScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>                                                                         

    protected void updateButtonActionPerformed (ActionEvent evt)
	{
 
    	nameTextField.setText ("");
        addressTextField.setText ("");
        cityTextField.setText ("");
        stateComboBox.setSelectedIndex (0);
        zipCodeTextField.setText ("");
        phoneTextField.setText ("");
        emailTextField.setText ("");
        photoLabel.setText ("No Photo");
	}

	private void exitButtonActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
        System.exit(0);
    }                                          

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt)                                          
    {                                              
        DefaultTableModel model = (DefaultTableModel) addressBookTable.getModel ( );
        ImageIcon icon = (ImageIcon)photoLabel.getIcon();
        String path = icon.getDescription();
    	//Add new Contact to ArrayList
    	 addressBook.add (new Contact
									((String)typeComboBox.getSelectedItem ( ),
									nameTextField.getText ( ),
									addressTextField.getText ( ),
									cityTextField.getText ( ),
									(String)stateComboBox.getSelectedItem ( ),
									zipCodeTextField.getText ( ),
									phoneTextField.getText ( ),
									emailTextField.getText ( ),
									path));
    	 help.sort(addressBook);
    	 initComponents();
    }                                         

    private void letterListMouseClicked(java.awt.event.MouseEvent evt)                                        
    {                                            
    	String holder = letterList.getSelectedValue ( );
    	if (holder != "ALL")
		{
			
		}
		
    	//Change addressBookList to letter selected
    	/*
    	 * 
    	 */
    }                                       

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)                                           
    {                                               
    	String[] strTemp =  new String[addressBook.size ( )+1];
    	//Holder for users contacts to convert to string
    	for (int i = 0 ; i < addressBook.size ( )+1 ; i++)
    	{
    		if (i == 0)
    		{
    			strTemp[0] = help.loadString(addressBook.getOwner ( ));
    			continue;
    		}
    		strTemp[i] = help.loadString (new Contact(addressBook.get (i-1)));
    	}
    	for (String element : strTemp)
    	{
    		System.out.println (element);
    	}
    	try
    	{
    		help.importExportData(strTemp,EXPORT);
    	}
    	catch (NullPointerException e)
    	{
    		System.out.println ("Error file was not saved");
    	}

    }                                          

    private void addressBookTableFocusGained(java.awt.event.FocusEvent evt)                                             
    {                                                 
        int row = addressBookTable.getSelectedRow ( );
        
        nameTextField.setText (addressBook.get (row).getName ( ));
        addressTextField.setText (addressBook.get (row).getStreetAddress ( ));
        cityTextField.setText (addressBook.get (row).getCity ( ));
        stateComboBox.setSelectedIndex (sort.binarySearch (addressBook.get (row).getState ( )));
        zipCodeTextField.setText (addressBook.get (row).getZipCode ( ));
        phoneTextField.setText (addressBook.get (row).getPhone ( ));
        emailTextField.setText (addressBook.get (row).getEmail ( ));
        photoLabel.setText ("");
        
        BufferedImage dimg = help.grabImage(addressBook.get (row).getPhoto ( ));
        Image Nimg = dimg.getScaledInstance
                        (photoLabel.getWidth(),
                        photoLabel.getHeight(),
                        Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(Nimg,addressBook.get (row).getPhoto ( ));
        photoLabel.setIcon(img);
        photoLabel.setText("");
        photoLabel.repaint();
    }                                            

    private void addressBookTableFocusLost(java.awt.event.FocusEvent evt)                                           
    {                                               
    	/*//Write method to check for changes
    	nameTextField.setText ("");
        addressTextField.setText ("");
        cityTextField.setText ("");
        stateComboBox.setSelectedIndex (0);
        zipCodeTextField.setText ("");
        phoneTextField.setText ("");
        emailTextField.setText ("");*/
    }                                          

    private void photoLabelMouseClicked(java.awt.event.MouseEvent evt)                                        
    {                                            
    	BufferedImage img;
    	JFileChooser pic = new JFileChooser (".\\docs\\photos");
    	File file;
    	pic.showDialog (null, "Import Photo");
    	if (pic.APPROVE_OPTION == 0)
    	{
    		try
    		{
    			file = pic.getSelectedFile ( );
    			img=ImageIO.read(file);
    			photoLabel.setText("");
    			photoLabel.setIcon(new ImageIcon(img,file.getAbsolutePath ( )));
    			photoLabel.setText("");
    			photoLabel.repaint();
    		}
    		catch (IOException e)
    		{
    			e.printStackTrace ( );
    		}

    	}
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AddressBookDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AddressBookDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AddressBookDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AddressBookDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AddressBookDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel AddressBookScrollPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel LetterListScrollPanel;
    private javax.swing.JPanel NewContactPanel;
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane addressBookScrollPane;
    private javax.swing.JTable addressBookTable;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JList<String> letterList;
    private javax.swing.JScrollPane letterListScrollPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> stateComboBox;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel zipCodeLabel;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration                   
}

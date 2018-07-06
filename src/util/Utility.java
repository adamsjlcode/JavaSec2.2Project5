/**
 * ---------------------------------------------------------------------------
 * File name: Utility.java
 * Project name: Project5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 21, 2017
 * ---------------------------------------------------------------------------
 */

package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import addressBook.AddressBook;
import addressBook.AddressBookDriver;
import addressBook.Contact;
import addressBook.ContactType;
import arrayOperations.ArrayOperations;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 21, 2017
 * <hr>
 * @author Justin Adams
 */
public class Utility
{
	File file;
	String [ ] data = null;							//Tempery Holder for contact data
	final int IMPORT = 0;							//Constant for import data from file
	final String[] NAMES = {"Type", "Name", "Address", "City", "State", "Zip Code", "Phone", "Email"};
													//Constant for asking data for contact												
	


	
	boolean blnOwner = false;						//Flag for owner
	/**
	 * Constructor
	 * 
	 * <hr>
	 * Date created: Mar 21, 2017.
	 */
	public Utility ( )
	{

	}// End Utility ( )
	
	public void loadAddressBook(AddressBook addressBook)
	{
		data = importExportData (data, IMPORT);
		for (String temp : data)
		{
			try
			{
				addressBook.add (new Contact (loadContact (temp)));
				if(loadContact (temp).getType ( ) == ContactType.OWNER)
				{
					blnOwner = true;
				}
			}
			catch (Exception e)
			{
				
				e.printStackTrace ( );
			}
		}
		if (blnOwner)
		{
			for (int i = 0; i < addressBook.size ( ) ; i++ )
			{
				String strOwner = addressBook.get (i).getType ( ).toString ( );
				if (strOwner.equals ("OWNER"))
				{
					System.out.println ("\n\nWelcome " + 
										addressBook.get (i).getName ( ) + 
										"\n\n\n");
					addressBook.setOwner(addressBook.get (i));
					addressBook.remove (i);
				}
			}
		}
		//Create Popup for owner
		/*while (!blnOwner)
		{
			if(addressBook.size ( ) != 0 ||!blnOwner)
			{
				System.out.println ("There is no owner for Address Book " +
							"\nPlease fill out this info");
				addressBook.setOwner (new Contact
									("OWNER",
										help.info(NAMES[1]).toUpperCase ( ),
										help.info(NAMES[2]).toUpperCase ( ),
										help.info(NAMES[3]).toUpperCase ( ),
										help.info(NAMES[4]).toUpperCase ( ),
										help.info(NAMES[5]),
										help.info(NAMES[6]),
										help.info(NAMES[7]).toUpperCase ( ),
										help.info(NAMES[8])));
				blnOwner = true;
			}
		}*/
	}
	
	/**
	 * Creates the model data.
	 *
	 * @param addressBook the address book
	 * @return the object[][]
	 */
	public Object[][] createModelData(AddressBook addressBook)
	{
		ArrayList <Contact> book = new ArrayList<Contact> (addressBook.size ( ));
		Object[][] modelData = new Object[addressBook.size ( )][9];
		System.out.println (addressBook);
		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			book.add (i, addressBook.get (i));
			
		}
		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			for (int j = 0; j < 9; j++ )
			{
				switch (j)
				{
					case 0:
						modelData[i][j] = book.get (i).getType ( );
						break;
					case 1:
						modelData[i][j] = book.get (i).getName ( );
						break;
					case 2:
						modelData[i][j] = book.get (i).getStreetAddress ( );
						break;
					case 3:
						modelData[i][j] = book.get (i).getCity ( );
						break;
					case 4:
						modelData[i][j] = book.get (i).getState ( );
						break;
					case 5:
						modelData[i][j] = book.get (i).getZipCode ( );
						break;
					case 6:
						modelData[i][j] = book.get (i).getPhone ( );
						break;
					case 7:
						modelData[i][j] = book.get (i).getEmail ( );
						break;
					case 8:
						modelData[i][j] = book.get (i).getPhoto ( );
						break;
				}//End switch
				
			}//End for loop
			
		}//End for loop
		
		return modelData;
	}//End createModelData(AddressBook)
	
	
	/**
	 * Import export data.
	 *
	 * @param temp the temp
	 * @param choice the choice
	 * @return the string[]
	 */
	public String [ ] importExportData (String [ ] temp, int choice)
	{
		String holder = "";		//Holder for file data in string
		Scanner data = null;	//File reader
		switch (choice)
		{
			case 0:
			{
				JFileChooser file = new JFileChooser (".\\docs");
				file.showDialog (null, "Import");
				if (file.APPROVE_OPTION == 0)
				{
					try
					{
						data = new Scanner (file.getSelectedFile ( ));
					}
					catch (FileNotFoundException e)
					{
						e.printStackTrace ( );
					}
					while (data.hasNextLine ( ))
					{
						String strCheck = data.nextLine ( )+"\n";
						holder += strCheck;
						strCheck = "";
					}
					temp = holder.split ("\\r?\\n");
				}
				data.close ( );
				break;
			}// End case 0:
			case 1:
			{
				JFileChooser file = new JFileChooser (".\\docs");
				PrintWriter write = null; 	//File writer
				file.showDialog (null, "Export");
				if (file.APPROVE_OPTION == 0)
				{
					try
					{
						write = new PrintWriter (new File (file.getSelectedFile ( )
															.getAbsolutePath ( )));
					}
					catch (FileNotFoundException e)
					{
						e.printStackTrace ( );
					}
					
					for (int i = 0; i < temp.length; i++ )
					{
						write.println (temp[i]);
					}// End for loop
				}
				else
				{
					return null;
				}
				write.close ( );
				break;
			}// End case 1:
		}// End switch ( )
		return temp;
	}// End importExportData (String[], int)
	
	
	/**
	 * Load contact.
	 *
	 * @param data the data
	 * @return the contact
	 */
	public Contact loadContact (String data)
	{
		Contact temp = new Contact ( );//Temporey holder for contact
		String [ ] strTemp = data.split ("\\|");//Split string into an array
		for (int i = 0; i < strTemp.length; i++ )
		{
			switch (i)
			{
				case 0:
					temp.setType (strTemp [i].toUpperCase ( ));
					break;
				case 1:
					temp.setName (strTemp [i].toUpperCase ( ));
					break;
				case 2:
					temp.setStreetAddress (strTemp [i].toUpperCase ( ));
					break;
				case 3:
					temp.setCity (strTemp [i].toUpperCase ( ));
					break;
				case 4:
					temp.setState (strTemp [i].toUpperCase ( ));
					break;
				case 5:
					temp.setZipCode (strTemp [i].toUpperCase ( ));
					break;
				case 6:
					strTemp [i] = removePhone(strTemp [i]);
					temp.setPhone (strTemp [i].toUpperCase ( ));
					break;
				case 7:
					temp.setEmail (strTemp [i].toUpperCase ( ));
					break;
				case 8:
					temp.setPhoto (strTemp [i]);
					break;
			}// End switch ( )
		}// End for loop
		return temp;
	}// End loadContact (int,String)
	
    public static BufferedImage grabImage(String title, String address, int choice)
    {
        BufferedImage image = null;
        String file = "docs\\photo\\"+title+".jpg";
        if(choice == 0)
        {
            URL url = null;
            try(InputStream in = new URL(address).openStream())
            {
                Files.copy(in, Paths.get("build\\Images\\"+title+".jpg"));
            } 
            catch (IOException ex)
            {
                Logger.getLogger(AddressBookDriver.class.getName()).log(Level.SEVERE, null, ex);
                grabImage(title,address,1);
            }
            
            try
            {
                image = ImageIO.read(new File(file));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
            
        }
        if(choice == 1)
        {
            try
            {
                image = ImageIO.read(new File(file));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return image;
    }
	/**
	 * Load string.
	 *
	 * @param data the data
	 * @return the string
	 */
	public String loadString (Contact data)
	{
		return new String(data.getType ( )+"|"+
						data.getName ( )+"|"+
						data.getStreetAddress ( )+"|"+
						data.getCity ( )+"|"+
						data.getState ( )+"|"+
						data.getZipCode ( )+"|"+
						data.getPhone ( )+"|"+
						data.getEmail ( )+"|"+
						data.getPhoto ( ));
	}//End loadString (Contact)
	
	
	/**
	 * @return nAMES
	 */
	public String [ ] getNAMES ( )
	{
		return NAMES;
	}
	
	/**
	 * Removes the phone.
	 *
	 * @param phone the phone
	 * @return the string
	 */
	public String removePhone (String phone)throws StringIndexOutOfBoundsException
	{
			String strArea = phone.substring (1, 4);
			String strFirst = phone.substring (5, 8);
			String strLast = phone.substring (9, 13);	
			phone = strArea + strFirst + strLast;
			return phone;	
	}//End removePhone (String)

	public void sort (AddressBook addressBook)
	{
		ArrayList<Contact> sorting = addressBook.copy ( );
		ArrayList<String> unsorted = new ArrayList<String>(sorting.size ( ));
		ArrayList<String> sorted = new ArrayList<String>(sorting.size ( ));
		for (int i = 0; i < sorting.size ( ); i++ )
		{
			unsorted.add (sorting.get (i).getName ( ));
		}
		for (int h = 0; h < sorting.size ( ); h++)
		{
			sorted.add(sorting.get (h).getName ( ));
		}
		ArrayOperations.selectionSort(sorted, sorted.size ( ));
		for (int i = 0; i < sorted.size ( ); i++ )
		{
			sorting = addressBook.copy ( );
			int iPosition = ArrayOperations.sequenceSearch (unsorted, sorted.get (i));
			Contact cTemp = addressBook.get(iPosition);
			addressBook.set (iPosition, addressBook.get (i));
			addressBook.set(i,cTemp);
			sorting = addressBook.copy ( );
			unsorted = new ArrayList<String>(sorting.size ( ));
			for (int j = 0; j < sorting.size ( ); j++ )
			{
				unsorted.add (sorting.get (j).getName ( ));
			}
		}
	}

	public BufferedImage grabImage (String photo)
	{
		BufferedImage image = null;
		System.out.println (photo);
		URL url = this.getClass().getResource(photo);
		System.out.println (url.getPath ( ));
        try(InputStream in = new URL(photo).openStream())
        {
            Files.copy(in, Paths.get(photo));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(AddressBookDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
		try
        {
            image = ImageIO.read(url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
		return image;
	}
}


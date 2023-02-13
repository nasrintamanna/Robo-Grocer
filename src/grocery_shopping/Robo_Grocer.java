/*You will need to develop an interactive one or two- worded grocery list generating programmed system called “Robo - grocer” to assist users in storing their grocery list items interactively. This program will initially allow for the storage of three top grocery items on the user's list but the system
can be extended to store more grocery items in the future. The robo - grocer should also be able to take screenshots of the grocery items that the user would like to buy for reference based on the website URL addresses the user enters. These screenshots will be stored in a file on the user's computer. 
The robo grocer system should also allow users to make changes to the grocery item names(which are either one or two-worded) they have entered by changing the first or second word of the grocery item name before finally getting their grocery list typed and stored for final use.

To develop the robo - grocer programmed system, the Following guidelines need to be Followed during the design and development of the program:-

1. The main class should be created first. Then, a welcome message should be included with ANSI color codes applied to the text to make the GUI interactive and user-friendly. Then the user should be asked to enter their three top grocery items sequentially along with the quantity needed per item.

2. With the help of the Desktop and Robot classes in Java, each of the user's grocery item images will be stored ina file for later access by the user. The user will need to enter the image address URI in the program and with the help of the Desktop class a tab will be
opened on the user's browser containing the picture of the grocery item which will then be screen captured with the implementation of the Robot class.

3. The StringBuilder class and several methods of this class like the replaceQ) method, deleteO method, indexOfFOQ method, length0 method, etc will be used to allow the user to make changes to their grocery items list before finally having the list interactively written and stored by the Robot class in Java.

4. Finally, the written grocery list by the robo - grocer based on the user selection will be stored as a file by the user using a text editor software like Notepad for Windows OS or TextEdit forMac OS with the help of the Runtime class and exec command that will need to be implemented in the system codes. */

package grocery_shopping;

import java.util.*;
//For controlling keyboard and mouse and coping data to clipboard.
import java.awt.AWTException;
import java.awt.Toolkit; //helps us opening any applications that we need.
import java.awt.Robot; //controls mouse and keyboard.
import java.awt.event.KeyEvent; //determines which key on the keyboard has been preesed.
import java.awt.datatransfer.Clipboard; //for transfering data from String to Clipboard.
import java.awt.datatransfer.StringSelection; //for storing the data which we're going to copy on Clipboard.
import java.io.File; //helps to read the image from certain files.
import java.io.IOException; //handles any input/output error that may have happened with any input/output operations.
import java.awt.Rectangle; //For taking screenshot.
import java.awt.image.BufferedImage; //helps us to open up the image that we wanna take screenshot of.
import javax.imageio.ImageIO; //helps us to read, locate the image reader and writer so it can read the image from its path and write it somewhere i.e save it to some file.
import java.awt.*;
import javax.swing.*;
import java.awt.Desktop; //helps us to open up the image URI.
import java.net.URI; //handles anything to do with the internet.
import java.net.URISyntaxException;



public class Robo_Grocer extends JFrame{
	private static String grocery_order;
	private static int index;
	private static int length;
	private static int new_length;
	private static String old_word;
	private static String new_word;
	private static String myString2;
	private static String item_option;
	private static String item1;
	private static String item2;
	private static String item3;
	private static double quantity1;
	private static double quantity2;
	private static double quantity3;

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException, AWTException {
		Scanner text = new Scanner(System.in);
		Scanner number = new Scanner(System.in);
		System.out.println(ANSI_Colors.DARK_RED+"Press enter key to start ");
		String user_response = text.nextLine();
		
		while(user_response.equals("")) {
			System.out.println();
			System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Welcome to Robo Grocer Program where you don't have to worry about writing up your grocery list again!");
			System.out.println();
			Thread.sleep(2000);
			System.out.println(ANSI_Colors.RED+"Enter your 3 grocery order priorities");
			
			//Taking inputs about the three items from the reader and saving the images into a folder.
			//For the first item.
			item_option = "1";
			System.out.println();
			System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the first item: ");
			item1 = text.nextLine();
			System.out.println("Enter the quantity for the first item ");
			quantity1 = number.nextDouble();
			if(item_option.equals("1")) {
				System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for this item ");
				String image_url = text.nextLine();
				
				//Opening the item image using image address url on user's default browser.
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI(image_url));
				try {
				Thread.sleep(3000);
				System.out.println();
				System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
				System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item1.jpg)\n After you insert the file path for storing the image here ");
				System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item1.jpg");
				System.out.println("Enter the file path for which you would like to store the image in");
				String path = text.nextLine();
				System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
				Thread.sleep(10000);
				System.out.println();
				
				//Getting the Screen size of user's monitor and capture screeenshot.
				Robot robo = new Robot();
				Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
				BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
				ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
				System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
				}catch(AWTException | IOException e) {
					e.printStackTrace();
				}
			}
			
			//For the second item.
			System.out.println();
			item_option = "2";
			System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the second item: ");
			item2 = text.nextLine();
			System.out.println("Enter the quantity for the second item ");
			quantity2 = number.nextDouble();
			if(item_option.equals("2")) {
				System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for this item ");
				String image_url = text.nextLine();
				
				//Opening the image using image address url on user's default browser.
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI(image_url));
				try {
					Thread.sleep(3000);
					System.out.println();
					System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
					System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item2.jpg)\n After you insert the file path for storing the image here ");
					System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item2.jpg");
					System.out.println("Enter the file path for which you would like to store the image in");
					String path = text.nextLine();
					System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
					Thread.sleep(10000);
					System.out.println();
					
					//Getting the Screen size of user's monitor and capture screeenshot.
					Robot robo = new Robot();
					Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
					BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
					ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
					System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
					}catch(AWTException | IOException e) {
						e.printStackTrace();
					}
			}
			
			//For the third item.
			System.out.println();
			item_option = "3";
			System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the third item: ");
			item3 = text.nextLine();
			System.out.println("Enter the quantity for the third item ");
			quantity3 = number.nextDouble();
			if(item_option.equals("3")) {
				System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for this item ");
				String image_url = text.nextLine();
				
				//Opening the image using image address url on user's default browser.
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI(image_url));
				try {
					Thread.sleep(3000);
					System.out.println();
					System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
					System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item3.jpg)\n After you insert the file path for storing the image here ");
					System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item3.jpg");
					System.out.println("Enter the file path for which you would like to store the image in");
					String path = text.nextLine();
					System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
					Thread.sleep(10000);
					System.out.println();
					
					//Getting screen size of user's monitor and capture the screenshot.
					Robot robo = new Robot();
					//capturing screenshot.
					Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
					BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
					//storing captured screenshot.
					ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
					System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
					
				}catch(AWTException | IOException e) {
					e.printStackTrace();
				}
			}
			
			
			//Asking user if they you like to change any item.
			System.out.println();
			System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Would you like to make any changes for the first, second or third item? \n1.Yes \n2.No ");
			int change_response = number.nextInt();
			int text_response = 0;
			
			while(change_response == 1) {
				text_response = 1;
				System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"For which item you would like to make a change?\n1.First item \n2.Second item \n3.Third item ");
				int item_response = number.nextInt();
				
				//Change for the first item.
				if(item_response == 1) {
					StringBuilder myString = new StringBuilder(item1);
					System.out.println(ANSI_Colors.PURPLE_BOLD+"What would you like to change for the first item?\n1.Change the second or only word \n2.Change the first word ");
					int item1_response = number.nextInt();
					if(item1_response == 1) {
						System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the old second word or only word of the first grocery item");
						old_word = text.nextLine();
						index = myString.indexOf(old_word);
						length = old_word.length();
						new_length = length - 1;
						myString.delete(index, new_length+index);
						System.out.println(ANSI_Colors.RED_BOLD+"Enter the new second word");
						new_word = text.nextLine();
						myString.replace(index, new_word.length()+3, new_word);
						System.out.println(ANSI_Colors.RED_BOLD+"The new first item of the grocery list is "+ myString);
						myString2 = myString.toString();
						String title = "\t\t\t GROCERY LIST";
						grocery_order = title + "\n" + myString2 + "\t" + quantity1 + "\n" + item2 + "\t" + quantity2 + "\n" + item3 + "\t" + quantity3 ;
						
						//replace the image of old first item with new first item.
						System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for the new item ");
						String image_url = text.nextLine();
						
						//Opening the item image using image address url on user's default browser.
						Desktop desktop = Desktop.getDesktop();
						desktop.browse(new URI(image_url));
						try {
						Thread.sleep(3000);
						System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
						System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item1.jpg)\n After you insert the file path for storing the image here ");
						System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item1.jpg");
						System.out.println("Enter the file path for which you would like to store the image in");
						String path = text.nextLine();
						System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
						Thread.sleep(10000);
						
						//Getting the Screen size of user's monitor and capture screeenshot.
						Robot robo = new Robot();
						Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
						BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
						ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
						System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
						}catch(AWTException | IOException e) {
							e.printStackTrace();
						}
					}
						if(item1_response == 2) {
							System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the old first word of the first grocery item");
							old_word = text.nextLine();
							index = myString.indexOf(old_word);
							length = old_word.length();
							myString.delete(index, length);
							//fish nuggest -- chicken nyggest
							System.out.println(ANSI_Colors.RED_BOLD+"Enter the new first word");
							new_word = text.nextLine();
							myString.replace(index, 1, new_word+"");
							System.out.println(ANSI_Colors.RED_BOLD+"The new first item of the grocery list is "+ myString);
							myString2 = myString.toString();
							String title = "\t\t\t GROCERY LIST";
							grocery_order = title + "\n" + myString2 + "\t" + quantity1 + "\n" + item2 + "\t" + quantity2 + "\n" + item3 + "\t" + quantity3 ;
							
							//replace the image of old first item with new first item.
							System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for the new item ");
							String image_url = text.nextLine();
							
							//Opening the item image using image address url on user's default browser.
							Desktop desktop2 = Desktop.getDesktop();
							desktop2.browse(new URI(image_url));
							try {
							Thread.sleep(3000);
							System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
							System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item1.jpg)\n After you insert the file path for storing the image here ");
							System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item1.jpg");
							System.out.println("Enter the file path for which you would like to store the image in");
							String path = text.nextLine();
							System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
							Thread.sleep(10000);
							
							//Getting the Screen size of user's monitor and capture screeenshot.
							Robot robo = new Robot();
							Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
							BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
							ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
							System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
							}catch(AWTException | IOException e) {
								e.printStackTrace();
							}
						}
				}
				
				
				//Change for the second item.
				if(item_response == 2) {
					StringBuilder myString = new StringBuilder(item2);
					System.out.println(ANSI_Colors.PURPLE_BOLD+"What would you like to change for the second item?\n1.Change the second or only word \n2.Change the first word ");
					int item2_response = number.nextInt();
					if(item2_response == 1) {
						System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the old second word or only word of the second grocery item");
						old_word = text.nextLine();
						index = myString.indexOf(old_word);
						length = old_word.length();
						new_length = length - 1;
						myString.delete(index, new_length+index);
						System.out.println(ANSI_Colors.RED_BOLD+"Enter the new second word");
						new_word = text.nextLine();
						myString.replace(index, new_word.length()+3, new_word);
						System.out.println(ANSI_Colors.RED_BOLD+"The new second item of the grocery list is "+ myString);
						myString2 = myString.toString();
						String title = "\t\t\t GROCERY LIST";
						grocery_order = title + "\n" + item1 + "\t" + quantity1 + "\n" + myString2 + "\t" + quantity2 + "\n" + item3 + "\t" + quantity3 ;
						
						//replace the image of old first item with new first item.
						System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for the new item ");
						String image_url = text.nextLine();
						
						//Opening the item image using image address url on user's default browser.
						Desktop desktop = Desktop.getDesktop();
						desktop.browse(new URI(image_url));
						try {
						Thread.sleep(3000);
						System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
						System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item2.jpg)\n After you insert the file path for storing the image here ");
						System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item2.jpg");
						System.out.println("Enter the file path for which you would like to store the image in");
						String path = text.nextLine();
						System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
						Thread.sleep(10000);
						
						//Getting the Screen size of user's monitor and capture screeenshot.
						Robot robo = new Robot();
						Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
						BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
						ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
						System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
						}catch(AWTException | IOException e) {
							e.printStackTrace();
						}
					}
						if(item2_response == 2) {
							System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the old first word of the second grocery item");
							old_word = text.nextLine();
							index = myString.indexOf(old_word);
							length = old_word.length();
							myString.delete(index, length);
							//fish nuggest -- chicken nuggest
							System.out.println(ANSI_Colors.RED_BOLD+"Enter the new first word");
							new_word = text.nextLine();
							myString.replace(index, 1, new_word+"");
							System.out.println(ANSI_Colors.RED_BOLD+"The new second item of the grocery list is "+ myString);
							myString2 = myString.toString();
							String title = "\t\t\t GROCERY LIST";
							grocery_order = title + "\n" + item1 + "\t" + quantity1 + "\n" + myString2 + "\t" + quantity2 + "\n" + item3 + "\t" + quantity3 ;
							
							//replace the image of old first item with new first item.
							System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for the new item ");
							String image_url = text.nextLine();
							
							//Opening the item image using image address url on user's default browser.
							Desktop desktop2 = Desktop.getDesktop();
							desktop2.browse(new URI(image_url));
							try {
							Thread.sleep(3000);
							System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
							System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item2.jpg)\n After you insert the file path for storing the image here ");
							System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\image2.jpg");
							System.out.println("Enter the file path for which you would like to store the image in");
							String path = text.nextLine();
							System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
							Thread.sleep(10000);
							
							//Getting the Screen size of user's monitor and capture screeenshot.
							Robot robo = new Robot();
							Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
							BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
							ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
							System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
							}catch(AWTException | IOException e) {
								e.printStackTrace();
							}
						}
				}
				
				
				//Change for the third item.
				if(item_response == 3) {
					StringBuilder myString = new StringBuilder(item3);
					System.out.println(ANSI_Colors.PURPLE_BOLD+"What would you like to change for the third item?\n1.Change the second or only word \n2.Change the first word ");
					int item3_response = number.nextInt();
					if(item3_response == 1) {
						System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the old second word or only word of the third grocery item");
						old_word = text.nextLine();
						index = myString.indexOf(old_word);
						length = old_word.length();
						new_length = length - 1;
						myString.delete(index, new_length+index);
						System.out.println(ANSI_Colors.RED_BOLD+"Enter the new second word");
						new_word = text.nextLine();
						myString.replace(index, new_word.length()+3, new_word);
						System.out.println(ANSI_Colors.RED_BOLD+"The new third item of the grocery list is "+ myString);
						myString2 = myString.toString();
						String title = "\t\t\t GROCERY LIST";
						grocery_order = title + "\n" + item1 + "\t" + quantity1 + "\n" + item2 + "\t" + quantity2 + "\n" + myString2 + "\t" + quantity3 ;
						
					//replace the image of old first item with new first item.
						System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for the new item ");
						String image_url = text.nextLine();
						
						//Opening the item image using image address url on user's default browser.
						Desktop desktop = Desktop.getDesktop();
						desktop.browse(new URI(image_url));
						try {
						Thread.sleep(3000);
						System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
						System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item3.jpg)\n After you insert the file path for storing the image here ");
						System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item3.jpg");
						System.out.println("Enter the file path for which you would like to store the image in");
						String path = text.nextLine();
						System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
						Thread.sleep(10000);
						
						//Getting the Screen size of user's monitor and capture screeenshot.
						Robot robo = new Robot();
						Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
						BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
						ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
						System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
						}catch(AWTException | IOException e) {
							e.printStackTrace();
						}
					}
						if(item3_response == 2) {
							System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Enter the old first word of the third grocery item");
							old_word = text.nextLine();
							index = myString.indexOf(old_word);
							length = old_word.length();
							myString.delete(index, length);
							//fish nuggest -- chicken nuggest
							System.out.println(ANSI_Colors.RED_BOLD+"Enter the new first word");
							new_word = text.nextLine();
							myString.replace(index, 1, new_word+"");
							System.out.println(ANSI_Colors.RED_BOLD+"The new third item of the grocery list is "+ myString);
							myString2 = myString.toString();
							String title = "\t\t\t GROCERY LIST";
							grocery_order = title + "\n" + item1 + "\t" + quantity1 + "\n" + item2 + "\t" + quantity2 + "\n" + myString2 + "\t" + quantity3 ;
							
							//replace the image of old first item with new first item.
							System.out.println(ANSI_Colors.PURPLE_BOLD_BRIGHT+"Enter the image address url for the new item ");
							String image_url = text.nextLine();
							
							//Opening the item image using image address url on user's default browser.
							Desktop desktop2 = Desktop.getDesktop();
							desktop2.browse(new URI(image_url));
							try {
							Thread.sleep(3000);
							System.out.println(ANSI_Colors.CYAN_BOLD_BRIGHT+"Please create a file called IMAGES where you would like to store the grocery images");
							System.out.println("Make sure to the add image name dot jpg the extention which should be in jpg(like item3.jpg)\n After you insert the file path for storing the image here ");
							System.out.println("For example:- ‪C:\\Users\\nasri\\Documents\\IMAGES\\item3.jpg");
							System.out.println("Enter the file path for which you would like to store the image in");
							String path = text.nextLine();
							System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"Please open the image of the item from your browser back up \nWait for 5seconds on the image so the screenshot can be taken	!");
							Thread.sleep(10000);
							
							//Getting the Screen size of user's monitor and capture screeenshot.
							Robot robo = new Robot();
							Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //This is going to get the screen size of user's monitor.
							BufferedImage image = robo.createScreenCapture(capture); //We're using Robot Class to be able to screen capture that image we've opened for the first item.
							ImageIO.write(image, "jpg", new File(path)); //ImageIO reads and writes images. So here we're going to write that means store the image in a particular full folder referance and that's the folder that we asked the user to enter which is under the variable called path.
							System.out.println(ANSI_Colors.RED_BOLD_BRIGHT+"The item's image has been saved successfully!");
							}catch(AWTException | IOException e) {
								e.printStackTrace();
							}
						}
				}
			
				System.out.println(ANSI_Colors.BLUE_BOLD_BRIGHT+"Would you like to make any changes for the first, second or third item? \n1.yes \n2.No)? ");
				change_response = number.nextInt();
				
				
			}
			if(change_response == 2) {
				text_response = 2;
			}
			
			//All changes made. Now we've to copy the information into notepad.
			

			if(text_response == 1) {
				Thread.sleep(2000);
				String title = "\t\t\t GROCERY LIST";
				grocery_order = title + "\n" + item1 + "\t" + quantity1 + "\n" + item2 + "\t" + quantity2 + "\n" + item3 + "\t" + quantity3 ;
				System.out.println(ANSI_Colors.YELLOW_BOLD_BRIGHT+"Please make sure save your grocery list to the notepad/TextEdit");
				String cmd = "";
				String os = System.getProperty("os.name").toString();
				if(os.startsWith("Mac OS X")) {
					cmd = "Textedit";
				}
				if(os.startsWith("Windows")) {
					cmd = "notepad";
				}
				
				Thread.sleep(2000);
				//Opening notepad.
				Runtime.getRuntime().exec(cmd);
				Thread.sleep(2000);
				Robot rb = new Robot();
				for(int i=0; i<grocery_order.length(); i++) {
					if(Character.isUpperCase(grocery_order.charAt(i))) {
						rb.keyPress(KeyEvent.VK_SHIFT);
						rb.keyPress(Character.toUpperCase(grocery_order.charAt(i)));
						rb.keyRelease(KeyEvent.VK_SHIFT);
					}
					else {
						rb.keyPress(Character.toUpperCase(grocery_order.charAt(i)));	
					}
					Thread.sleep(500);
				}
			
				}
			
			else if(text_response == 2) {
				Thread.sleep(2000);
				System.out.println(ANSI_Colors.YELLOW_BOLD_BRIGHT+"Please make sure save your grocery list to the notepad/TextEdit");
				String cmd = "";
				String os = System.getProperty("os.name").toString();
				if(os.startsWith("Mac OS X")) {
					cmd = "Textedit";
				}
				if(os.startsWith("Windows")) {
					cmd = "notepad";
				}
				
				Thread.sleep(2000);
				//Opening notepad.
				Runtime.getRuntime().exec(cmd);
				Thread.sleep(2000);
				Robot rb = new Robot();
				for(int i=0; i<grocery_order.length(); i++) {
					if(Character.isUpperCase(grocery_order.charAt(i))) {
						rb.keyPress(KeyEvent.VK_SHIFT);
						rb.keyPress(Character.toUpperCase(grocery_order.charAt(i)));
						rb.keyRelease(KeyEvent.VK_SHIFT);
					}
					else {
						rb.keyPress(Character.toUpperCase(grocery_order.charAt(i)));	
					}
					Thread.sleep(500);
				}
			
				}
			
			System.out.println(ANSI_Colors.DARK_RED+"Press enter key to start and e to exit ");
			user_response = text.nextLine();
			
		}
				
		System.out.println(ANSI_Colors.GREEN_BOLD_BRIGHT+"Thank You!");

	}

}

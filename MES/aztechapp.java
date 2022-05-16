import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.io.IOException;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class aztechapp {

	String brand = new String();
	String model = new String();
	String description = new String();
	int qty;
	int quantity;
	double price;
	String type = new String();
	int procRank;
	int batRank;

	String[] titles = { "Brand", "Model", "Price", "Stock", "Description", "type", "Battery Ranking",
			"Processing Ranking", "Image" };
	String[] titlescart = { "Username", "Brand", "Model", "Quantity", "Price" };
	String[] titleshistory = { "Username", "Brand", "Model", "Quantity", "Date", "Price" };

	private Display display;
	protected Shell shell;
	private Text searchbar;
	private Label lblAztech;
	private Label cartbtn;
	private Composite Home;
	private Button componentsbtn;
	private Button pcbtn;
	private Button mobilebtn;
	private Label searchbtn;
	private Label categorieslbl;
	private Composite Loginpage;
	private Button loginadminbtn;
	private Button Loginbtn_page;
	private Label lbcreateaccount;
	private Label validation;
	private Text password;
	private Text username;
	private Label passwordlbl;
	private Label usernamelbl;
	private Label lblLogin;
	private Composite Registerpage;
	private Label lblregister;
	private Label lblname;
	private Text name_register;
	private Label lblusername;
	private Text username_register;
	private Label lbl_email;
	private Text email_resgiter;
	private Label lblgender;
	private Label lblphone;
	private Label lblpassword;
	private Label lblpassword2;
	private Text confpassword_register;
	private Text password_register;
	private Text phone_resgiter;
	private Button maleButton;
	private Button femaleButton;
	private Button btnRegister;
	private Label lblhaveaccount;
	private Composite Adminpage;
	private Button btnAddProduct;
	private Button btnRemoveProduct;
	private Button btnChangeProduct;
	private Label lblAdministratorPage;
	private Composite Addproduct;
	private Label lblAddProduct;
	private Text brandadd;
	private Text modeladd;
	private Text priceadd;
	private Text stockadd;
	private Text descriptionadd;
	private Label imageadd;
	private Text categoryadd;
	private Button addprobtn;
	private Composite Changeproduct;
	private Label lblChangeProduct;
	private Text priceupdate;
	private Text stockupdate;
	private Text rankingupdate;
	private Text modelupdate;
	private Text descriptionupdate;
	private Text batrankadd;
	private Text procrankadd;
	private Text rankingadd;
	private Button changeprobtn;
	private Composite Removeproduct;
	private Label lblRemoveProduct;
	private Button removeprobtn;
	private Text nameremovepro;
	private Label lblForgotPassword;
	private Composite Changepassword;
	private Text usernamecp;
	private Text newpasscp;
	private Text confnewpasscp;
	private Table homeTable;
	private Composite Cartpage;
	private Table adminTable;
	private Composite Computerfilters;
	private Composite Mobilefilters;
	private Composite Componentsfilters;
	private Label lbluserpage;
	private Composite Userpage;
	private Button btnCarthistory;
	private Button btnUserinf;
	private Composite Userinf;
	private Composite UserHistory;
	private Text userinfname;
	private Text userinfemail;
	private Text userinfphone;
	private Text userinfgender;
	private Button changeinfbtn;
	private Label lblCartname;
	private Label loginbtn;
	private Text typeadd;
	private Button btnLoogoutadmin;
	private Table tblCart;
	private Table userhistorytbl;
	private Button Buybtn;
	private Button changepasswordbtn;
	public Shell saveShell;
	private ImageData imageData;
	private Color cinza;
	private Color roxo;
	private Color fundo;
	private Color azul;
	private Color border;
	private Color fundo2;
	private double sum;
	private Label validation_register;
	private Label Lblvalidation_pass;
	private Label lblStock;
	private int outofstock;
	private Text removeprodcart;
	private Button removeprodcartbtn;
	private Label lblcartoperation;
	private Label proupdatesms;
	private Label addprosms;
	private Label proremovesms;

	String gender_register = "";
	String image_path = null;
	private String logged = "";
	private Label nextToCat;
	private Label barraAzul;
	private Label lock;
	private Label azulClaro;
	private Label lblSum;
	private Label lblTotalPrice;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			aztechapp window = new aztechapp();
			// ProductView wind = new ProductView();
			window.open("home");
			// wind.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public aztechapp() {

	}

	/**
	 * Open the window.
	 */
	public void open(String s) {

		createContents(s);

		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(String s) {

		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setImage(SWTResourceManager.getImage(aztechapp.class, "/Icons/Aztech_Logo.png"));
		shell.setBackground(fundo);

		// Cores
		roxo = SWTResourceManager.getColor(113, 0, 184);
		fundo = SWTResourceManager.getColor(23, 33, 46);
		cinza = SWTResourceManager.getColor(229, 230, 231);
		azul = SWTResourceManager.getColor(0, 216, 227);
		fundo2 = SWTResourceManager.getColor(37, 48, 61);
		border = SWTResourceManager.getColor(63, 78, 89);

		shell.setSize(1480, 720);
		shell.setText("Aztech");
		shell.addListener(SWT.Close, new Listener()

		{
			public void handleEvent(Event event) {
				/*
				 * int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO; MessageBox messageBox =
				 * new MessageBox(shell, style); messageBox.setText("Information");
				 * messageBox.setMessage("Close the shell?"); event.doit = messageBox.open() ==
				 * SWT.YE
				 */
			}
		});

		// User page
		Userpage = new Composite(shell, SWT.NONE);
		Userpage.setBackground(fundo);
		Userpage.setLocation(0, 79);
		Userpage.setSize(1476, 602);

		lbluserpage = new Label(Userpage, SWT.NONE);
		lbluserpage.setBackground(fundo);
		lbluserpage.setForeground(cinza);
		lbluserpage.setAlignment(SWT.CENTER);
		lbluserpage.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.BOLD));
		lbluserpage.setBounds(20, 20, 200, 40);
		lbluserpage.setText("My Account");

		btnUserinf = new Button(Userpage, SWT.NONE);
		btnUserinf.setForeground(cinza);
		btnUserinf.setBackground(roxo);
		btnUserinf.addSelectionListener(new SelectionAdapter() {
			///////// DISPLAYS USER INFO
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserHistory.setVisible(false);
				Userinf.setVisible(true);

				ArrayList<UserList> user_inf = UserData.userInformation(logged);

				for (int i = 0; i < user_inf.size(); i++) {
					userinfname.setText(user_inf.get(i).getname());
					userinfemail.setText(user_inf.get(i).getemail());
					userinfphone.setText(user_inf.get(i).getphone());
					userinfgender.setText(user_inf.get(i).getgender());
				}

			}
		});
		btnUserinf.setText("Personal Information");
		btnUserinf.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 10, SWT.NORMAL));
		btnUserinf.setBounds(36, 103, 160, 60);

		btnCarthistory = new Button(Userpage, SWT.NONE);
		btnCarthistory.setBackground(roxo);
		btnCarthistory.setForeground(cinza);
		btnCarthistory.setText("Purchasing History");
		btnCarthistory.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 10, SWT.NORMAL));
		btnCarthistory.setBounds(36, 181, 160, 60);

		// UserHistory
		UserHistory = new Composite(Userpage, SWT.NONE);
		UserHistory.setBounds(260, 10, 1192, 574);
		UserHistory.setVisible(true);
		UserHistory.setVisible(false);
		UserHistory.setBackground(fundo);
		UserHistory.setForeground(cinza);

		userhistorytbl = new Table(UserHistory, SWT.BORDER | SWT.FULL_SELECTION);
		userhistorytbl.setHeaderBackground(SWTResourceManager.getColor(105, 105, 105));
		userhistorytbl.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		userhistorytbl.setLocation(20, 90);
		userhistorytbl.setSize(900, 300);
		userhistorytbl.setHeaderVisible(true);
		userhistorytbl.setLinesVisible(true);

		btnCarthistory.addSelectionListener(new SelectionAdapter() {
			///////////// DISPLAYS USER PURCHASING HISTORY
			@Override
			public void widgetSelected(SelectionEvent e) {
				Userinf.setVisible(false);
				UserHistory.setVisible(true);
				userhistorytbl.removeAll();
				;
				userhistorytbl.clearAll();

				ArrayList<UserHistoryList> user = UserData.userHistory(logged);

				for (int i = 0; i < user.size(); i++) {

					brand = user.get(i).getBrand();
					model = user.get(i).getModel();
					double price1 = user.get(i).getPrice();
					qty = user.get(i).getQty();

					System.out.println("dados " + brand + "||" + model + "||" + price + "||" + qty);

					TableItem item = new TableItem(userhistorytbl, SWT.NONE);
					item.setText(0, logged);
					item.setText(1, brand);
					item.setText(2, model);
					item.setText(3, Integer.toString(qty));
					item.setText(4, user.get(i).getDate());
					item.setText(5, Double.toString(price1));

					System.out.println("hist  username:" + user.get(i).getUsername() + " brand:"
							+ user.get(i).getBrand() + " model: " + user.get(i).getModel() + " date: "
							+ user.get(i).getDate() + " qty:" + Integer.toString(user.get(i).getQty()));

				}
				for (int i = 0; i < titleshistory.length; i++) {
					userhistorytbl.getColumn(i).pack();
				}

				user.clear();

			}
		});

		Button btnLogOut = new Button(Userpage, SWT.NONE);
		btnLogOut.setBackground(roxo);
		btnLogOut.setForeground(cinza);
		btnLogOut.addSelectionListener(new SelectionAdapter() {
			///////// LOG OUT
			@Override
			public void widgetSelected(SelectionEvent e) {
				logged = "";
				JOptionPane.showMessageDialog(null, "Log out Successfull");
				lblCartname.setText("Cart");
				Home.setVisible(true);
				Userpage.setVisible(false);
				tblCart.removeAll();
			}
		});
		btnLogOut.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 10, SWT.NORMAL));
		btnLogOut.setBounds(36, 274, 160, 60);
		btnLogOut.setText("Log out");

		// Userinf
		Userinf = new Composite(Userpage, SWT.NONE);
		Userinf.setBounds(260, 10, 1192, 574);
		Userinf.setBackground(fundo);
		Userinf.setForeground(cinza);

		userinfname = new Text(Userinf, SWT.BORDER);
		userinfname.setBackground(fundo2);
		userinfname.setForeground(cinza);
		userinfname.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		userinfname.setLocation(300, 90);
		userinfname.setSize(300, 30);

		userinfemail = new Text(Userinf, SWT.BORDER);
		userinfemail.setForeground(cinza);
		userinfemail.setBackground(fundo2);
		userinfemail.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		userinfemail.setLocation(300, 180);
		userinfemail.setSize(300, 30);

		userinfphone = new Text(Userinf, SWT.BORDER);
		userinfphone.setBackground(fundo2);
		userinfphone.setForeground(cinza);
		userinfphone.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		userinfphone.setLocation(300, 210);
		userinfphone.setSize(300, 30);

		userinfgender = new Text(Userinf, SWT.BORDER);
		userinfgender.setBackground(fundo2);
		userinfgender.setForeground(cinza);
		userinfgender.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		userinfgender.setLocation(300, 240);
		userinfgender.setSize(300, 30);

		changeinfbtn = new Button(Userinf, SWT.NONE);
		changeinfbtn.setBackground(roxo);
		changeinfbtn.setForeground(cinza);
		changeinfbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		changeinfbtn.addSelectionListener(new SelectionAdapter() {
			/////////// UPDATE USER INFO
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (!userinfname.getText().equals("") && !userinfemail.getText().equals("")
						&& !userinfphone.getText().equals("") && !userinfgender.getText().equals("")) {

					ArrayList<UserList> user_inf = UserData.userInformation(logged);

					UserList user_update = new UserList(userinfname.getText(), logged, user_inf.get(0).getpassword(),
							userinfemail.getText(), userinfphone.getText(), "", userinfgender.getText());

					UserData.userUpdate(user_update);
					JOptionPane.showMessageDialog(null, "Update user with Success");
					System.out.println("Update user with Success");

				}

			}
		});
		changeinfbtn.setText("Update information");
		changeinfbtn.setBounds(460, 401, 160, 60);

		changepasswordbtn = new Button(Userinf, SWT.NONE);
		changepasswordbtn.setForeground(cinza);
		changepasswordbtn.setBackground(roxo);
		changepasswordbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		changepasswordbtn.addSelectionListener(new SelectionAdapter() {
			/////////////////// CHANGE PASSWORD PAGE
			@Override
			public void widgetSelected(SelectionEvent e) {
				Userpage.setVisible(false);
				Changepassword.setVisible(true);
				Userinf.setVisible(false);

				usernamecp.setText("username");
				usernamecp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				newpasscp.setText("password");
				newpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				confnewpasscp.setText("password");
				confnewpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

			}
		});
		changepasswordbtn.setText("Change Password");
		changepasswordbtn.setBounds(240, 401, 160, 60);

		Userinf.setVisible(false);
		Userpage.setVisible(false);
		Userpage.setVisible(false);
		Userinf.setVisible(true);

		// Cart page
		Cartpage = new Composite(shell, SWT.NONE);
		Cartpage.setBackground(fundo);
		Cartpage.setLocation(0, 79);
		Cartpage.setSize(1476, 602);

		Label buySms = new Label(Cartpage, SWT.NONE);
		buySms.setBounds(1000, 200, 150, 30);
		buySms.setBackground(SWTResourceManager.getColor(23, 33, 46));
		buySms.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		buySms.setForeground(SWTResourceManager.getColor(229, 230, 231));
		buySms.setText("");

		Buybtn = new Button(Cartpage, SWT.NONE);
		Buybtn.setLocation(1000, 137);
		Buybtn.setBackground(roxo);
		Buybtn.setForeground(cinza);
		Buybtn.setSize(150, 50);
		Buybtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		Buybtn.addSelectionListener(new SelectionAdapter() {
			///// BUY ALL ITEMS IN USER'S CART
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (Double.valueOf(lblSum.getText()) != 0.0) {
					AdminData.updateStock(logged);

					UserData.addUserHistory(logged);

					tblCart.removeAll();

					buySms.setText("Successfull Purchase");

					Cartpage.setVisible(false);
					Home.setVisible(true);
				} else {
					buySms.setText("No Items In the Cart");
				}

			}
		});
		Buybtn.setText("BUY");

		tblCart = new Table(Cartpage, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		tblCart.setHeaderBackground(SWTResourceManager.getColor(105, 105, 105));
		tblCart.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		tblCart.setBounds(566, 89, 353, 331);
		tblCart.setHeaderVisible(true);
		tblCart.setLinesVisible(true);

		lblCartname = new Label(Cartpage, SWT.NONE);
		lblCartname.setBackground(fundo);
		lblCartname.setForeground(cinza);
		lblCartname.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 16, SWT.BOLD));
		lblCartname.setBounds(25, 20, 200, 40);
		lblCartname.setText("Cart");

		Cartpage.setVisible(false);

		lblSum = new Label(Cartpage, SWT.NONE);
		lblSum.setAlignment(SWT.CENTER);
		lblSum.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblSum.setBackground(fundo2);
		lblSum.setForeground(cinza);
		lblSum.setBounds(836, 444, 71, 15);
		lblSum.setText(String.valueOf(sum));

		lblcartoperation = new Label(Cartpage, SWT.NONE);
		lblcartoperation.setBackground(fundo);
		lblcartoperation.setForeground(cinza);
		lblcartoperation.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		lblcartoperation.setBounds(1020, 370, 150, 40);
		lblcartoperation.setText("");

		removeprodcart = new Text(Cartpage, SWT.BORDER);
		removeprodcart.setBackground(fundo2);
		removeprodcart.setForeground(cinza);
		removeprodcart.setText("Model to Remove 1 Unit");
		removeprodcart.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (removeprodcart.getText().trim().toLowerCase().equals("model to remove 1 unit")) {
					removeprodcart.setText("");
					removeprodcart.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (removeprodcart.getText().trim().equals("")
						|| removeprodcart.getText().trim().toLowerCase().equals("Model to Remove 1 Unit")) {
					removeprodcart.setText("Model to Remove 1 Unit");
					removeprodcart.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		removeprodcart.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		removeprodcart.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		removeprodcart.setBounds(134, 150, 300, 30);

		removeprodcartbtn = new Button(Cartpage, SWT.NONE);
		removeprodcartbtn.setLocation(284, 229);
		removeprodcartbtn.setBackground(roxo);
		removeprodcartbtn.setForeground(cinza);
		removeprodcartbtn.setSize(150, 50);
		removeprodcartbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		removeprodcartbtn.addSelectionListener(new SelectionAdapter() {
			//// REMOVE PRODUCT FROM USER'S CART
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!removeprodcart.getText().equals("") && !logged.equals("")) {

					int result = UserData.cartRemove(removeprodcart.getText().trim(), logged);
					if (result == 1) {
						tblCart.removeAll();
						lblcartoperation.setText("Success!");
						ArrayList<CartList> cart = UserData.cartPage(logged);
						sum = 0;
						for (int i = 0; i < cart.size(); i++) {
							brand = cart.get(i).getBrand();
							model = cart.get(i).getModel();
							price = cart.get(i).getPrice();
							quantity = cart.get(i).getQty();
							System.out.println(
									"dados " + brand + "||" + model + "||" + price + "||" + qty + "||" + description);
							TableItem item = new TableItem(tblCart, SWT.NONE);
							item.setText(0, logged);
							item.setText(1, brand);
							item.setText(2, model);
							item.setText(3, Integer.toString(quantity));
							item.setText(4, Double.toString(price));

							sum = sum + price * quantity;

						}
						lblSum.setText(String.valueOf(sum));
						for (int i = 0; i < titlescart.length; i++) {
							tblCart.getColumn(i).pack();
						}

						cart.clear();
					} else if (result == -1) {
						lblcartoperation.setText("Try Again");
					}

				} else if (logged.equals("")) {
					lblcartoperation.setText("Please Sign In");
				}

			}
		});
		removeprodcartbtn.setText("Remove Product");
		Cartpage.setVisible(false);

		lblTotalPrice = new Label(Cartpage, SWT.NONE);
		lblTotalPrice.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblTotalPrice.setBounds(731, 444, 55, 15);
		lblTotalPrice.setBackground(fundo);
		lblTotalPrice.setForeground(cinza);
		lblTotalPrice.setText("total price");
		// Home page
		Home = new Composite(shell, SWT.NONE);
		Home.setBackground(SWTResourceManager.getColor(23, 33, 46));
		Home.setLocation(0, 79);
		Home.setSize(1476, 602);

		componentsbtn = new Button(Home, SWT.NONE);
		componentsbtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				////// HOME PAGE PC COMPONENTS FILTER
				homeTable.removeAll();

				ArrayList<ProductList> listinit = ProductData.homePage(3);

				packhomeTable(listinit);

				Componentsfilters.setVisible(true);
				Computerfilters.setVisible(false);
				Mobilefilters.setVisible(false);

			}
		});
		componentsbtn.setBounds(55, 180, 195, 40);
		componentsbtn.setBackground(SWTResourceManager.getColor(113, 0, 104));
		componentsbtn.setForeground(SWTResourceManager.getColor(229, 230, 231));
		componentsbtn.setText("Pc Components");
		componentsbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));

		pcbtn = new Button(Home, SWT.NONE);
		pcbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		pcbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				////// HOME PAGE PC COMPUTERS FILTER
				homeTable.removeAll();
				ArrayList<ProductList> listinit = ProductData.homePage(1);

				packhomeTable(listinit);

				Computerfilters.setVisible(true);
				Componentsfilters.setVisible(false);
				Mobilefilters.setVisible(false);

			}
		});
		pcbtn.setText("Computers");
		pcbtn.setBounds(55, 60, 195, 40);
		pcbtn.setBackground(SWTResourceManager.getColor(113, 0, 104));
		pcbtn.setForeground(SWTResourceManager.getColor(229, 230, 231));

		mobilebtn = new Button(Home, SWT.NONE); // MOBILE BUTTON HOMEPAGE
		mobilebtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		mobilebtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// HOME PAGE MOBILE FILTER
				homeTable.removeAll();
				ArrayList<ProductList> listinit = ProductData.homePage(2);

				listinit = ProductData.homePage(2);

				packhomeTable(listinit);

				Mobilefilters.setVisible(true);
				Computerfilters.setVisible(false);
				Componentsfilters.setVisible(false);

				listinit.clear();
			}
		});
		mobilebtn.setText("Mobile");
		mobilebtn.setBounds(55, 120, 195, 40);
		mobilebtn.setBackground(SWTResourceManager.getColor(113, 0, 104));
		mobilebtn.setForeground(SWTResourceManager.getColor(229, 230, 231));

		homeTable = new Table(Home, SWT.SINGLE | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		homeTable.setLinesVisible(true);
		homeTable.setHeaderBackground(SWTResourceManager.getColor(105, 105, 105));
		homeTable.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		homeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		homeTable.setBounds(320, 10, 850, 545);
		homeTable.addListener(SWT.DefaultSelection, new Listener() {
			//// PUTS SELECTED PRODUCT INTO PRODUCT VIEW
			public void handleEvent(Event e) {
				Shell shellPV = new Shell(SWT.SHELL_TRIM & ~SWT.RESIZE);
				shellPV.setImage(SWTResourceManager.getImage(aztechapp.class, "/Icons/Aztech_Logo.png"));
				shellPV.setSize(1000, 700);
				shellPV.setText("PV");
				shellPV.layout();
				shellPV.open();
				shellPV.setText("Product View");

				outofstock = 0;

				TableItem selection = homeTable.getItem(homeTable.getSelectionIndex());

				String model = selection.getText(1);

				System.out.println("DefaultSelection={" + model + "}");

				ArrayList<ProductList> product = AdminData.modelSearch(model);
				if (product.size() >= 1) {
					System.out.println("dados " + product.get(0).getBrand() + "||" + product.get(0).getModel() + "||"
							+ product.get(0).getPrice() + "||" + product.get(0).getQty() + "||"
							+ product.get(0).getDescription());

					Composite PV = new Composite(shellPV, SWT.NONE);
					PV.setLocation(0, 0);
					PV.setBackground(fundo);
					PV.setSize(984, 700);

					Label lblComposite = new Label(PV, SWT.NONE);
					lblComposite.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblComposite.setForeground(cinza);
					lblComposite.setBackground(fundo);
					lblComposite.setText(product.get(0).getBrand());
					lblComposite.setBounds(300, 50, 100, 30);

					Label lblStock = new Label(PV, SWT.NONE);
					lblStock.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblStock.setForeground(cinza);
					lblStock.setBackground(fundo);
					lblStock.setBounds(489, 250, 100, 30);
					lblStock.setText("Stock:" + Integer.toString(product.get(0).getQty()));

					Button addToCart = new Button(PV, SWT.NONE);
					addToCart.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 16, SWT.NORMAL));
					addToCart.setBackground(roxo);
					addToCart.setForeground(cinza);
					addToCart.setBounds(786, 218, 175, 69);
					addToCart.setText("add to cart");
					addToCart.addSelectionListener(new SelectionAdapter() {
						/////// ADDS PRODUCT TO USER'S CART
						@Override
						public void widgetSelected(SelectionEvent e) {
							if (!logged.equals("")) {
								outofstock = UserData.addToCart(logged, model, 1, product.get(0).getPrice(),
										product.get(0).getBrand(), product.get(0).getQty());
								if (outofstock == 1) {
									Label lblStockout = new Label(PV, SWT.NONE);
									lblStockout
											.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
									lblStockout.setForeground(cinza);
									lblStockout.setBackground(fundo);
									lblStockout.setBounds(489, 300, 100, 30);
									lblStockout.setText("Out of Stock");

								}

							}
						}
					});

					Label lblModelo = new Label(PV, SWT.NONE);
					lblModelo.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblModelo.setForeground(cinza);
					lblModelo.setBackground(fundo);
					lblModelo.setBounds(489, 50, 100, 30);
					lblModelo.setText(product.get(0).getModel());

					Label lblNewLabel = new Label(PV, SWT.NONE);
					lblNewLabel.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
					lblNewLabel.setForeground(cinza);
					lblNewLabel.setBackground(fundo);
					lblNewLabel.setLocation(10, 10);
					lblNewLabel.setSize(175, 300);

					// imagem
					System.out.println("/Products By ProductID/" + product.get(0).getModel() + "200.png");
					Image img = new Image(display, aztechapp.class
							.getResourceAsStream("/Products By ProductID/" + product.get(0).getModel() + "200.png"));
					lblNewLabel.setImage(img);

					Label lblPrice = new Label(PV, SWT.NONE);
					lblPrice.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblPrice.setForeground(cinza);
					lblPrice.setBackground(fundo);
					lblPrice.setBounds(300, 150, 100, 30);
					lblPrice.setText(product.get(0).getPrice() + "€");

					Label lblbatRank = new Label(PV, SWT.NONE);
					lblbatRank.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblbatRank.setForeground(cinza);
					lblbatRank.setBackground(fundo);
					lblbatRank.setBounds(489, 150, 100, 30);
					lblbatRank.setText("Battery Rank: " + Integer.toString(product.get(0).getBatRank()));

					Label lblprocRank = new Label(PV, SWT.NONE);
					lblprocRank.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblprocRank.setForeground(cinza);
					lblprocRank.setBackground(fundo);
					lblprocRank.setBounds(300, 250, 100, 30);
					lblprocRank.setText("Processing Rank: " + Integer.toString(product.get(0).getProcRank()));

					Label lblDescription = new Label(PV, SWT.NONE);
					lblDescription.setBackground(fundo);
					lblDescription.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
					lblDescription.setForeground(cinza);
					lblDescription.setBounds(300, 400, 411, 150);
					lblDescription.setText(product.get(0).getDescription());

					Label barra = new Label(PV, SWT.NONE);
					barra.setBounds(200, 10, 8, 550);
					barra.setBackground(azul);
				}

			}
		});
		// table.setSize(165, 165*5);
		homeTable.setHeaderVisible(true);

		// Computer Filters Design
		Computerfilters = new Composite(Home, SWT.NONE);
		Computerfilters.setBounds(1206, 10, 246, 574);
		Computerfilters.setBackground(fundo2);

		Label lblFiltersPC = new Label(Computerfilters, SWT.NONE);
		lblFiltersPC.setBackground(fundo2);
		lblFiltersPC.setForeground(cinza);
		lblFiltersPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.NORMAL));
		lblFiltersPC.setLocation(104, 10);
		lblFiltersPC.setSize(106, 25);
		lblFiltersPC.setText("Filters");

		Label lblBatteryPC = new Label(Computerfilters, SWT.NONE);
		lblBatteryPC.setForeground(cinza);
		lblBatteryPC.setBackground(fundo2);
		lblBatteryPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblBatteryPC.setLocation(30, 60);
		lblBatteryPC.setSize(120, 25);
		lblBatteryPC.setText("Battery Score");

		// filtros baterias
		Label lblbatterybadPC = new Label(Computerfilters, SWT.NONE);
		lblbatterybadPC.setBackground(fundo2);
		lblbatterybadPC.setForeground(azul);
		lblbatterybadPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblbatterybadPC.setLocation(90, 90);
		lblbatterybadPC.setSize(70, 20);
		lblbatterybadPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				///// HOME PAGE BATTERY FILTER BAD
				ArrayList<ProductList> listinit = ProductData.filters(1, 1, 1);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblbatterybadPC.setText("0-50%");

		Label lblbatterymediumPC = new Label(Computerfilters, SWT.NONE);
		lblbatterymediumPC.setBackground(fundo2);
		lblbatterymediumPC.setForeground(azul);
		lblbatterymediumPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblbatterymediumPC.setLocation(90, 120);
		lblbatterymediumPC.setSize(70, 20);
		lblbatterymediumPC.addMouseListener(new MouseAdapter() {
			///////// HOME PAGE BATTERY FILTER MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 2, 1);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblbatterymediumPC.setText("50-75%");

		Label lblbatterygoodPC = new Label(Computerfilters, SWT.NONE);
		lblbatterygoodPC.setBackground(fundo2);
		lblbatterygoodPC.setForeground(azul);
		lblbatterygoodPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblbatterygoodPC.setLocation(90, 150);
		lblbatterygoodPC.setSize(70, 20);
		lblbatterygoodPC.addMouseListener(new MouseAdapter() {
			////////////// HOME PAGE BATTERY FILTER GOOD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 3, 1);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblbatterygoodPC.setText("75-100%");

		Label lblprocessingPC = new Label(Computerfilters, SWT.NONE);
		lblprocessingPC.setForeground(cinza);
		lblprocessingPC.setBackground(fundo2);
		lblprocessingPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessingPC.setBounds(30, 190, 130, 20);
		lblprocessingPC.setText("Processing Score");

		Label lblprocessingbadPC = new Label(Computerfilters, SWT.NONE);
		lblprocessingbadPC.setBackground(fundo2);
		lblprocessingbadPC.setForeground(cinza);
		lblprocessingbadPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessingbadPC.addMouseListener(new MouseAdapter() {
			////////////// HOME PAGE PROCESSING FILTER BAD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 1, 2);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessingbadPC.setText("Bad");
		lblprocessingbadPC.setBounds(90, 220, 70, 20);

		Label lblprocessingmediumPC = new Label(Computerfilters, SWT.NONE);
		lblprocessingmediumPC.setForeground(cinza);
		lblprocessingmediumPC.setBackground(fundo2);
		lblprocessingmediumPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessingmediumPC.addMouseListener(new MouseAdapter() {
			/////////////// HOME PAGE PROCESSING FILTER MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 2, 2);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessingmediumPC.setText("Medium");
		lblprocessingmediumPC.setBounds(90, 250, 70, 20);

		Label lblprocessinggoodPC = new Label(Computerfilters, SWT.NONE);
		lblprocessinggoodPC.setForeground(cinza);
		lblprocessinggoodPC.setBackground(fundo2);
		lblprocessinggoodPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessinggoodPC.addMouseListener(new MouseAdapter() {
			/////////// HOME PAGE PROCESSING FILTER GOOD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 3, 2);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessinggoodPC.setText("Good");
		lblprocessinggoodPC.setBounds(90, 280, 70, 20);

		Label lbrankingslPC = new Label(Computerfilters, SWT.NONE);
		lbrankingslPC.setForeground(cinza);
		lbrankingslPC.setBackground(fundo2);
		lbrankingslPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lbrankingslPC.setText("Rankings");
		lbrankingslPC.setBounds(30, 320, 130, 20);

		Label lblrankingsbadPC = new Label(Computerfilters, SWT.NONE);
		lblrankingsbadPC.setBackground(fundo2);
		lblrankingsbadPC.setForeground(azul);
		lblrankingsbadPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankingsbadPC.addMouseListener(new MouseAdapter() {
			/////////////// HOME PAGE RANKINGS FILTER BAD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 1, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankingsbadPC.setText("0-50%");
		lblrankingsbadPC.setBounds(90, 350, 70, 20);

		Label lblrankingmediumPC = new Label(Computerfilters, SWT.NONE);
		lblrankingmediumPC.setBackground(fundo2);
		lblrankingmediumPC.setForeground(azul);
		lblrankingmediumPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankingmediumPC.addMouseListener(new MouseAdapter() {
			///////// HOME PAGE RANKINGS FILTER MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 2, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankingmediumPC.setText("50-75%");
		lblrankingmediumPC.setBounds(90, 380, 70, 20);

		Label lblrankinggoodPC = new Label(Computerfilters, SWT.NONE);
		lblrankinggoodPC.setForeground(azul);
		lblrankinggoodPC.setBackground(fundo2);
		lblrankinggoodPC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankinggoodPC.addMouseListener(new MouseAdapter() {
			//////////////// HOME PAGE RANKINGS FILTER GOOD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(1, 3, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankinggoodPC.setText("75-100%");
		lblrankinggoodPC.setBounds(90, 410, 70, 20);

		Computerfilters.setVisible(false);

		// Mobile Filters
		Mobilefilters = new Composite(Home, SWT.NONE);
		Mobilefilters.setBackground(fundo2);
		Mobilefilters.setBounds(1206, 10, 246, 574);

		Label lblFiltersM = new Label(Mobilefilters, SWT.NONE);
		lblFiltersM.setBackground(fundo2);
		lblFiltersM.setForeground(cinza);
		lblFiltersM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.NORMAL));
		lblFiltersM.setLocation(104, 10);
		lblFiltersM.setSize(106, 25);
		lblFiltersM.setText("Filters");

		Label lblBatteryM = new Label(Mobilefilters, SWT.NONE);
		lblBatteryM.setForeground(cinza);
		lblBatteryM.setBackground(fundo2);
		lblBatteryM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblBatteryM.setLocation(30, 60);
		lblBatteryM.setSize(120, 25);
		lblBatteryM.setText("Battery Score");

		Label lblbatterybadM = new Label(Mobilefilters, SWT.NONE);
		lblbatterybadM.setBackground(fundo2);
		lblbatterybadM.setForeground(azul);
		lblbatterybadM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblbatterybadM.setLocation(90, 90);
		lblbatterybadM.setSize(70, 20);
		lblbatterybadM.addMouseListener(new MouseAdapter() {
			////////// HOME PAGE MOBILE BATTERY FILTER BAD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 1, 1);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblbatterybadM.setText("0-50%");

		Label lblbatterymediumM = new Label(Mobilefilters, SWT.NONE);
		lblbatterymediumM.setBackground(fundo2);
		lblbatterymediumM.setForeground(azul);
		lblbatterymediumM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblbatterymediumM.setLocation(90, 120);
		lblbatterymediumM.setSize(70, 20);
		lblbatterymediumM.addMouseListener(new MouseAdapter() {
			//////////// HOME PAGE MOBILE BATTERY FILTER MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 2, 1);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblbatterymediumM.setText("50-75%");

		Label lblbatterygoodM = new Label(Mobilefilters, SWT.NONE);
		lblbatterygoodM.setForeground(azul);
		lblbatterygoodM.setBackground(fundo2);
		lblbatterygoodM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblbatterygoodM.setLocation(90, 150);
		lblbatterygoodM.setSize(70, 20);
		lblbatterygoodM.addMouseListener(new MouseAdapter() {
			////////// HOME PAGE MOBILE BATTERY FILTER GOOD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 3, 1);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblbatterygoodM.setText("75-100%");

		Label lblprocessingM = new Label(Mobilefilters, SWT.NONE);
		lblprocessingM.setForeground(cinza);
		lblprocessingM.setBackground(fundo2);
		lblprocessingM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessingM.setBounds(30, 190, 130, 20);
		lblprocessingM.setText("Processing Score");

		Label lblprocessingbadM = new Label(Mobilefilters, SWT.NONE);
		lblprocessingbadM.setForeground(azul);
		lblprocessingbadM.setBackground(fundo2);
		lblprocessingbadM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessingbadM.addMouseListener(new MouseAdapter() {
			///////////// HOME PAGE MOBILE PROCESSING FILTER BAD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 1, 2);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessingbadM.setText("Bad");
		lblprocessingbadM.setBounds(90, 220, 70, 20);

		Label lblprocessingmediumM = new Label(Mobilefilters, SWT.NONE);
		lblprocessingmediumM.setBackground(fundo2);
		lblprocessingmediumM.setForeground(azul);
		lblprocessingmediumM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessingmediumM.addMouseListener(new MouseAdapter() {
			//////////// HOME PAGE MOBILE PROCESSING FILTER MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 2, 2);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessingmediumM.setText("Medium");
		lblprocessingmediumM.setBounds(90, 250, 70, 20);

		Label lblprocessinggoodM = new Label(Mobilefilters, SWT.NONE);
		lblprocessinggoodM.setBackground(fundo2);
		lblprocessinggoodM.setForeground(azul);
		lblprocessinggoodM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessinggoodM.addMouseListener(new MouseAdapter() {
			///////// HOME PAGE MOBILE PROCESSING FILTER GOOD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 3, 2);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessinggoodM.setText("Good");
		lblprocessinggoodM.setBounds(90, 280, 70, 20);

		Label lbrankingslM = new Label(Mobilefilters, SWT.NONE);
		lbrankingslM.setBackground(fundo2);
		lbrankingslM.setForeground(cinza);
		lbrankingslM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lbrankingslM.setText("Rankings");
		lbrankingslM.setBounds(30, 320, 130, 20);

		Label lblrankingsbadM = new Label(Mobilefilters, SWT.NONE);
		lblrankingsbadM.setBackground(fundo2);
		lblrankingsbadM.setForeground(azul);
		lblrankingsbadM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankingsbadM.addMouseListener(new MouseAdapter() {
			/////// HOME PAGE MOBILE RANKING BAD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 1, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankingsbadM.setText("0-50%");
		lblrankingsbadM.setBounds(90, 350, 70, 20);

		Label lblrankingmediumM = new Label(Mobilefilters, SWT.NONE);
		lblrankingmediumM.setForeground(azul);
		lblrankingmediumM.setBackground(fundo2);
		lblrankingmediumM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankingmediumM.addMouseListener(new MouseAdapter() {
			/////// HOME PAGE MOBILE RANKING MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 2, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankingmediumM.setText("50-75%");
		lblrankingmediumM.setBounds(90, 380, 70, 20);

		Label lblrankinggoodM = new Label(Mobilefilters, SWT.NONE);
		lblrankinggoodM.setBackground(fundo2);
		lblrankinggoodM.setForeground(azul);
		lblrankinggoodM.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankinggoodM.addMouseListener(new MouseAdapter() {
			//////////// HOME PAGE MOBILE RANKING GOOD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(2, 3, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankinggoodM.setText("75-100%");
		lblrankinggoodM.setBounds(90, 410, 70, 20);

		Mobilefilters.setVisible(false);

		// Components Filters
		Componentsfilters = new Composite(Home, SWT.NONE);
		Componentsfilters.setBounds(1206, 10, 246, 574);
		Componentsfilters.setBackground(fundo2);

		Label lblFiltersC = new Label(Componentsfilters, SWT.NONE);
		lblFiltersC.setBackground(fundo2);
		lblFiltersC.setForeground(cinza);
		lblFiltersC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.NORMAL));
		lblFiltersC.setLocation(104, 10);
		lblFiltersC.setSize(106, 25);
		lblFiltersC.setText("Filters");

		Label lblmouseC = new Label(Componentsfilters, SWT.NONE); // Mouse Filters
		lblmouseC.setBackground(fundo2);
		lblmouseC.setForeground(cinza);
		lblmouseC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblmouseC.addMouseListener(new MouseAdapter() {
			////////// HOME PAGE MOUSE FILTER
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(0, 0, 5);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblmouseC.setLocation(30, 105);
		lblmouseC.setSize(120, 25);
		lblmouseC.setText("Mouse");

		Label lblkeyboardC = new Label(Componentsfilters, SWT.NONE); // Filters keyboard
		lblkeyboardC.setForeground(cinza);
		lblkeyboardC.setBackground(fundo2);
		lblkeyboardC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblkeyboardC.addMouseListener(new MouseAdapter() {
			//////////// HOME PAGE KEYBOARD FILTER
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(0, 0, 4);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblkeyboardC.setBounds(30, 65, 130, 20);
		lblkeyboardC.setText("Keyboard");

		Label lblprocessorC = new Label(Componentsfilters, SWT.NONE); // Filter Processors
		lblprocessorC.setForeground(cinza);
		lblprocessorC.setBackground(fundo2);
		lblprocessorC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblprocessorC.addMouseListener(new MouseAdapter() {
			//////////// HOME PAGE PROCESSOR FILTER
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(0, 0, 6);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblprocessorC.setLocation(30, 185);
		lblprocessorC.setSize(120, 25);
		lblprocessorC.setText("Processor");

		Label lblgcC = new Label(Componentsfilters, SWT.NONE); // Filters Graphics cards
		lblgcC.setForeground(cinza);
		lblgcC.setBackground(fundo2);
		lblgcC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblgcC.addMouseListener(new MouseAdapter() {
			/////////////// HOME PAGE GRAPHICS CARD FILTER
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(0, 0, 7);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblgcC.setLocation(30, 145);
		lblgcC.setSize(120, 25);
		lblgcC.setText("Graphics Card");

		Label lbrankingslC = new Label(Componentsfilters, SWT.NONE);
		lbrankingslC.setForeground(cinza);
		lbrankingslC.setBackground(fundo2);
		lbrankingslC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lbrankingslC.setText("Rankings");
		lbrankingslC.setBounds(30, 225, 130, 20);

		Label lblrankingsbadC = new Label(Componentsfilters, SWT.NONE);// Filters bad ranking
		lblrankingsbadC.setForeground(azul);
		lblrankingsbadC.setBackground(fundo2);
		lblrankingsbadC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankingsbadC.addMouseListener(new MouseAdapter() {
			///////// HOME PAGE COMPONENTS RANKING FILTER BAD
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(3, 1, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankingsbadC.setText("0-50%");
		lblrankingsbadC.setBounds(90, 260, 70, 20);

		Label lblrankingmediumC = new Label(Componentsfilters, SWT.NONE);// Filters med ranking
		lblrankingmediumC.setForeground(azul);
		lblrankingmediumC.setBackground(fundo2);
		lblrankingmediumC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankingmediumC.addMouseListener(new MouseAdapter() {
			/////////////// HOME PAGE COMPONENTS RANKING FILTER MEDIUM
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> listinit = ProductData.filters(3, 2, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankingmediumC.setText("50-75%");
		lblrankingmediumC.setBounds(90, 290, 70, 20);

		Label lblrankinggoodC = new Label(Componentsfilters, SWT.NONE); // Filters good ranking
		lblrankinggoodC.setForeground(azul);
		lblrankinggoodC.setBackground(fundo2);
		lblrankinggoodC.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblrankinggoodC.addMouseListener(new MouseAdapter() {
			//////////// HOME PAGE COMPONENTS RANKING FILTER GOOD
			@Override
			public void mouseDown(MouseEvent e) {

				ArrayList<ProductList> listinit = ProductData.filters(3, 3, 3);
				homeTable.removeAll();
				packhomeTable(listinit);
			}
		});
		lblrankinggoodC.setText("75-100%");
		lblrankinggoodC.setBounds(90, 320, 70, 20);

		Componentsfilters.setVisible(false);
		Home.setVisible(false);

		nextToCat = new Label(Home, SWT.NONE);
		nextToCat.setBackground(SWTResourceManager.getColor(113, 0, 184));
		nextToCat.setBounds(55, 20, 3, 19);

		categorieslbl = new Label(Home, SWT.NONE);
		categorieslbl.setBounds(64, 20, 98, 19);
		categorieslbl.setBackground(SWTResourceManager.getColor(23, 33, 46));
		categorieslbl.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		categorieslbl.setForeground(SWTResourceManager.getColor(229, 230, 231));
		categorieslbl.setText("CATEGORIES");

		barraAzul = new Label(Home, SWT.NONE);
		barraAzul.setBackground(azul);
		barraAzul.setBounds(290, 10, 4, 545);
		Home.setVisible(false);
		Componentsfilters.setVisible(false);
		Mobilefilters.setVisible(false);
		Computerfilters.setVisible(false);

		// Register page
		Registerpage = new Composite(shell, SWT.NONE);
		Registerpage.setBackground(fundo);
		Registerpage.setLocation(0, 79);
		Registerpage.setSize(1476, 602);

		lblregister = new Label(Registerpage, SWT.NONE);
		lblregister.setAlignment(SWT.CENTER);
		lblregister.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.NORMAL));
		lblregister.setForeground(cinza);
		lblregister.setBackground(fundo);
		lblregister.setText("Register");
		lblregister.setBounds(60, 10, 150, 69);

		lblname = new Label(Registerpage, SWT.NONE);
		lblname.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblname.setForeground(cinza);
		lblname.setBackground(fundo);
		lblname.setText("Name:");
		lblname.setBounds(226, 74, 70, 20);

		name_register = new Text(Registerpage, SWT.BORDER);
		name_register.setForeground(cinza);
		name_register.setBackground(fundo2);
		name_register.setText("Name");
		name_register.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (name_register.getText().trim().toLowerCase().equals("name")) {
					name_register.setText("");
					name_register.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (name_register.getText().trim().equals("")
						|| name_register.getText().trim().toLowerCase().equals("Name")) {
					name_register.setText("Name");
					name_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		name_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		name_register.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		name_register.setBounds(397, 71, 257, 35);

		lblusername = new Label(Registerpage, SWT.NONE);
		lblusername.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblusername.setText("Username:");
		lblusername.setForeground(cinza);
		lblusername.setBackground(fundo);
		lblusername.setBounds(226, 135, 70, 20);

		username_register = new Text(Registerpage, SWT.BORDER);
		username_register.setForeground(cinza);
		username_register.setBackground(fundo2);
		username_register.setText("Username");
		username_register.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (username_register.getText().trim().toLowerCase().equals("username")) {
					username_register.setText("");
					username_register.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (username_register.getText().trim().equals("")
						|| username_register.getText().trim().toLowerCase().equals("Username")) {
					username_register.setText("Username");
					username_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		username_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		username_register.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		username_register.setBounds(397, 132, 257, 35);

		lbl_email = new Label(Registerpage, SWT.NONE);
		lbl_email.setForeground(cinza);
		lbl_email.setBackground(fundo);
		lbl_email.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lbl_email.setText("e-mail:");
		lbl_email.setBounds(226, 194, 70, 20);

		email_resgiter = new Text(Registerpage, SWT.BORDER);
		email_resgiter.setBackground(fundo2);
		email_resgiter.setForeground(cinza);
		email_resgiter.setText("email");
		email_resgiter.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (email_resgiter.getText().trim().toLowerCase().equals("email")) {
					email_resgiter.setText("");
					email_resgiter.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (email_resgiter.getText().trim().equals("")
						|| email_resgiter.getText().trim().toLowerCase().equals("email")) {
					email_resgiter.setText("email");
					email_resgiter.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		email_resgiter.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		email_resgiter.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		email_resgiter.setBounds(397, 191, 257, 35);

		lblgender = new Label(Registerpage, SWT.NONE);
		lblgender.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblgender.setBackground(fundo);
		lblgender.setForeground(cinza);
		lblgender.setText("Gender:");
		lblgender.setBounds(226, 251, 70, 20);

		lblphone = new Label(Registerpage, SWT.NONE);
		lblphone.setBackground(fundo);
		lblphone.setForeground(cinza);
		lblphone.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblphone.setText("Phone number:");
		lblphone.setBounds(226, 299, 97, 20);

		lblpassword = new Label(Registerpage, SWT.NONE);
		lblpassword.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblpassword.setForeground(cinza);
		lblpassword.setBackground(fundo);
		lblpassword.setText("Password:");
		lblpassword.setBounds(226, 358, 70, 20);

		lblpassword2 = new Label(Registerpage, SWT.NONE);
		lblpassword2.setBackground(fundo);
		lblpassword2.setForeground(cinza);
		lblpassword2.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblpassword2.setText("Confirm Password:");
		lblpassword2.setBounds(226, 416, 150, 35);

		confpassword_register = new Text(Registerpage, SWT.BORDER | SWT.PASSWORD);
		confpassword_register.setBackground(fundo2);
		confpassword_register.setForeground(cinza);
		confpassword_register.setText("Password");
		confpassword_register.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (confpassword_register.getText().trim().toLowerCase().equals("password")) {
					confpassword_register.setText("");
					confpassword_register.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (confpassword_register.getText().trim().equals("")
						|| confpassword_register.getText().trim().toLowerCase().equals("Password")) {
					confpassword_register.setText("Password");
					confpassword_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		confpassword_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		confpassword_register.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		confpassword_register.setBounds(397, 416, 257, 35);

		password_register = new Text(Registerpage, SWT.BORDER | SWT.PASSWORD);
		password_register.setForeground(cinza);
		password_register.setBackground(fundo2);
		password_register.setText("Password");
		password_register.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (password_register.getText().trim().toLowerCase().equals("password")) {
					password_register.setText("");
					password_register.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (password_register.getText().trim().equals("")
						|| password_register.getText().trim().toLowerCase().equals("Password")) {
					password_register.setText("Password");
					password_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		password_register.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		password_register.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		password_register.setBounds(397, 358, 257, 35);

		phone_resgiter = new Text(Registerpage, SWT.BORDER);
		phone_resgiter.setBackground(fundo2);
		phone_resgiter.setForeground(cinza);
		phone_resgiter.setText("Phone");
		phone_resgiter.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (phone_resgiter.getText().trim().toLowerCase().equals("phone")) {
					phone_resgiter.setText("");
					phone_resgiter.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (phone_resgiter.getText().trim().equals("")
						|| phone_resgiter.getText().trim().toLowerCase().equals("Phone")) {
					phone_resgiter.setText("Phone");
					phone_resgiter.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		phone_resgiter.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		phone_resgiter.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		phone_resgiter.setBounds(397, 296, 257, 35);

		maleButton = new Button(Registerpage, SWT.RADIO);
		maleButton.setBackground(fundo);
		maleButton.setForeground(cinza);
		maleButton.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		maleButton.setText("Male");
		maleButton.setBounds(397, 251, 111, 20);

		femaleButton = new Button(Registerpage, SWT.RADIO);
		femaleButton.setForeground(cinza);
		femaleButton.setBackground(fundo);
		femaleButton.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		femaleButton.setText("Female");
		femaleButton.setBounds(514, 251, 111, 20);

		validation_register = new Label(Registerpage, SWT.RADIO);
		validation_register.setForeground(cinza);
		validation_register.setBackground(fundo);
		validation_register.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		validation_register.setBounds(480, 515, 200, 30);

		btnRegister = new Button(Registerpage, SWT.NONE);
		btnRegister.setForeground(cinza);
		btnRegister.setBackground(roxo);
		btnRegister.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		btnRegister.addSelectionListener(new SelectionAdapter() {
			////////////// REGISTER BUTTON
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (maleButton.getSelection()) {
					gender_register = "male";
				}
				if (femaleButton.getSelection()) {
					gender_register = "female";
				}

				if (name_register.getText().trim().toLowerCase().equals("name")
						|| username_register.getText().trim().toLowerCase().equals("username")
						|| password_register.getText().trim().toLowerCase().equals("password")
						|| email_resgiter.getText().trim().toLowerCase().equals("email")
						|| phone_resgiter.getText().trim().toLowerCase().equals("phone")
						|| (!maleButton.getSelection() && !femaleButton.getSelection())) {
					validation_register.setText("Fill all spaces");
				} else if (password_register.getText().equals(confpassword_register.getText())) {

					ArrayList<UserList> user_inf = UserData.userInformation(username_register.getText().trim());
					String usernameData = new String();
					int success = 1;

					for (int i = 0; i < user_inf.size(); i++) {

						usernameData = user_inf.get(i).getusername();

						if (username_register.getText().equals(usernameData)) {
							success = 0;
						}
					}
					// create account
					if (success == 1) {
						UserList user_res = new UserList(name_register.getText(), username_register.getText(),
								password_register.getText(), email_resgiter.getText(), phone_resgiter.getText(),
								"admin", gender_register);

						UserData.InsertUser(user_res);
						JOptionPane.showMessageDialog(null, "Register Successfull");
						System.out.println("Registe Successfull");
						lblCartname.setText(logged + "'s Cart");
						Loginpage.setVisible(true);
						Registerpage.setVisible(false);
						validation_register.setText("");
					} else {
						validation_register.setText("User already exits");
					}
				}

			}
		});
		btnRegister.setText("Register");
		btnRegister.setBounds(480, 483, 90, 30);

		lblhaveaccount = new Label(Registerpage, SWT.NONE);
		lblhaveaccount.setForeground(cinza);
		lblhaveaccount.setBackground(fundo);
		lblhaveaccount.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblhaveaccount.addMouseListener(new MouseAdapter() {
			////////// HAVE ACCOUNT -> RETURN TO LOGIN PAGE
			@Override
			public void mouseDown(MouseEvent e) {
				username.setText("username");
				username.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				password.setText("password");
				password.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

				Loginpage.setVisible(true);
				Registerpage.setVisible(false);
			}
		});
		lblhaveaccount.setText("Already have an account? Login!");
		lblhaveaccount.setBounds(581, 554, 257, 20);
		Registerpage.setVisible(false);
		// lblCart.setText(logged + "'s Cart");

		// Changepassword
		Changepassword = new Composite(shell, SWT.NONE);
		Changepassword.setBackground(fundo);
		Changepassword.setLocation(0, 79);
		Changepassword.setSize(1462, 594);

		Label lblchangepass = new Label(Changepassword, SWT.NONE);
		lblchangepass.setForeground(cinza);
		lblchangepass.setBackground(fundo);
		lblchangepass.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		lblchangepass.setAlignment(SWT.CENTER);
		lblchangepass.setBounds(36, 38, 200, 59);
		lblchangepass.setText("Change Password");

		usernamecp = new Text(Changepassword, SWT.BORDER);
		usernamecp.setForeground(cinza);
		usernamecp.setBackground(fundo2);
		usernamecp.setText("Username");
		usernamecp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (usernamecp.getText().trim().toLowerCase().equals("username")) {
					usernamecp.setText("");
					usernamecp.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (usernamecp.getText().trim().equals("")
						|| usernamecp.getText().trim().toLowerCase().equals("Username")) {
					usernamecp.setText("Username");
					usernamecp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		usernamecp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		usernamecp.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		usernamecp.setBounds(749, 125, 200, 30);

		newpasscp = new Text(Changepassword, SWT.BORDER);
		newpasscp.setForeground(cinza);
		newpasscp.setBackground(fundo2);
		newpasscp.setText("Password");
		newpasscp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (newpasscp.getText().trim().toLowerCase().equals("password")) {
					newpasscp.setText("");
					newpasscp.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (newpasscp.getText().trim().equals("")
						|| newpasscp.getText().trim().toLowerCase().equals("Password")) {
					newpasscp.setText("Password");
					newpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		newpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		newpasscp.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		newpasscp.setBounds(749, 209, 200, 30);

		confnewpasscp = new Text(Changepassword, SWT.BORDER);
		confnewpasscp.setBackground(fundo2);
		confnewpasscp.setForeground(cinza);
		confnewpasscp.setText("Password");
		confnewpasscp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (confnewpasscp.getText().trim().toLowerCase().equals("password")) {
					confnewpasscp.setText("");
					confnewpasscp.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (confnewpasscp.getText().trim().equals("")
						|| confnewpasscp.getText().trim().toLowerCase().equals("Password")) {
					confnewpasscp.setText("Password");
					confnewpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		confnewpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		confnewpasscp.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		confnewpasscp.setBounds(749, 299, 200, 30);

		Label lblUsername = new Label(Changepassword, SWT.NONE);
		lblUsername.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblUsername.setForeground(cinza);
		lblUsername.setBackground(fundo);
		lblUsername.setText("Username");
		lblUsername.setBounds(474, 125, 160, 20);

		Label lblNewPassword = new Label(Changepassword, SWT.NONE);
		lblNewPassword.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblNewPassword.setForeground(cinza);
		lblNewPassword.setBackground(fundo);
		lblNewPassword.setText("New Password");
		lblNewPassword.setBounds(474, 209, 160, 20);

		Label lblConfirmNewPassword = new Label(Changepassword, SWT.NONE);
		lblConfirmNewPassword.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		lblConfirmNewPassword.setForeground(cinza);
		lblConfirmNewPassword.setBackground(fundo);
		lblConfirmNewPassword.setText("Confirm New Password");
		lblConfirmNewPassword.setBounds(474, 299, 160, 20);

		Lblvalidation_pass = new Label(Changepassword, SWT.NONE);
		Lblvalidation_pass.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.NORMAL));
		Lblvalidation_pass.setForeground(cinza);
		Lblvalidation_pass.setBackground(fundo);
		Lblvalidation_pass.setBounds(656, 500, 250, 65);

		Button changepassbtn = new Button(Changepassword, SWT.NONE);
		changepassbtn.setForeground(cinza);
		changepassbtn.setBackground(roxo);
		changepassbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.NORMAL));
		changepassbtn.addSelectionListener(new SelectionAdapter() {
			////// CHANGE PASSWORD BUTTON
			@Override
			public void widgetSelected(SelectionEvent e) {

				ArrayList<UserList> user_inf = UserData.userInformation(usernamecp.getText().trim());

				String nameData = new String();
				String usernameData = new String();
				String passwordData = new String();
				String emailData = new String();
				String phoneData = new String();
				String genderData = new String();

				int success = 0;

				for (int i = 0; i < user_inf.size(); i++) {

					nameData = user_inf.get(i).getname();
					usernameData = user_inf.get(i).getusername();
					passwordData = user_inf.get(i).getpassword();
					emailData = user_inf.get(i).getemail();
					phoneData = user_inf.get(i).getphone();
					genderData = user_inf.get(i).getgender();

					if (!newpasscp.getText().trim().toLowerCase().equals("Password")) {
						success = 1;
						if (usernamecp.getText().equals(usernameData)) {
							success = 2;
							if (newpasscp.getText().equals(confnewpasscp.getText())) {
								if (!newpasscp.getText().equals(passwordData)) {
									UserList update_pass = new UserList(nameData, usernamecp.getText(),
											newpasscp.getText(), emailData, phoneData, "", genderData);

									UserData.userUpdate(update_pass);
									Lblvalidation_pass.setText("");
									JOptionPane.showMessageDialog(null, "Change Password with Successfull");

									if (logged.equals("")) {
										Loginpage.setVisible(true);
										Changepassword.setVisible(false);
									} else {
										Changepassword.setVisible(false);
										Userinf.setVisible(true);
										Userpage.setVisible(true);
									}
									break;
								} else {
									Lblvalidation_pass.setText("Password it's equals to the old password");
								}
							} else {
								Lblvalidation_pass.setText("Password are different");
							}
						}

					}
				}

				if (success != 2) {
					Lblvalidation_pass.setText("Data not Valid");
				}
			}

		});
		changepassbtn.setBounds(656, 417, 200, 65);
		changepassbtn.setText("Change");
		Changepassword.setVisible(false);

		// Admin page
		Adminpage = new Composite(shell, SWT.NONE);
		Adminpage.setLocation(0, 79);
		Adminpage.setSize(1476, 602);
		Adminpage.setBackground(fundo);

		btnAddProduct = new Button(Adminpage, SWT.NONE);
		btnAddProduct.setForeground(cinza);
		btnAddProduct.setBackground(roxo);
		btnAddProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Removeproduct.setVisible(false);
				Addproduct.setVisible(true);
				Changeproduct.setVisible(false);

				brandadd.setText("Brand");
				brandadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				modeladd.setText("Model");
				modeladd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				priceadd.setText("Price");
				priceadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				stockadd.setText("Stock");
				stockadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				descriptionadd.setText("Description");
				descriptionadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				imageadd.setText("Image");
				imageadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				categoryadd.setText("Category");
				categoryadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				typeadd.setText("Type");
				typeadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				batrankadd.setText("Battery Rank");
				batrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				procrankadd.setText("Processing Rank");
				procrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				rankingadd.setText("Ranking");
				rankingadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				addprosms.setText("");

				removePtable();

			}
		});
		btnAddProduct.setText("Add Product");
		btnAddProduct.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		btnAddProduct.setBounds(36, 103, 160, 60);

		btnRemoveProduct = new Button(Adminpage, SWT.NONE);
		btnRemoveProduct.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		btnRemoveProduct.setBackground(roxo);
		btnRemoveProduct.setForeground(cinza);
		btnRemoveProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Removeproduct.setVisible(true);
				Addproduct.setVisible(false);
				Changeproduct.setVisible(false);

				nameremovepro.setText("Model");
				nameremovepro.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				proremovesms.setText("");

				removePtable();
			}
		});
		btnRemoveProduct.setText("Remove Product");
		btnRemoveProduct.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		btnRemoveProduct.setBounds(36, 213, 160, 60);

		btnChangeProduct = new Button(Adminpage, SWT.NONE);
		btnChangeProduct.setForeground(cinza);
		btnChangeProduct.setBackground(roxo);
		btnChangeProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Removeproduct.setVisible(false);
				Addproduct.setVisible(false);
				Changeproduct.setVisible(true);

				modelupdate.setText("Model");
				modelupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				descriptionupdate.setText("Description");
				descriptionupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				priceupdate.setText("Price");
				priceupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				stockupdate.setText("Stock");
				stockupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				rankingupdate.setText("Ranking");
				rankingupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				proupdatesms.setText("");

				removePtable();

			}
		});
		btnChangeProduct.setText("Change Product");
		btnChangeProduct.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		btnChangeProduct.setBounds(36, 323, 160, 60);

		btnLoogoutadmin = new Button(Adminpage, SWT.NONE);
		btnLoogoutadmin.setForeground(cinza);
		btnLoogoutadmin.setBackground(roxo);
		btnLoogoutadmin.addSelectionListener(new SelectionAdapter() {
			//////////// LOGOUT ADMIN
			@Override
			public void widgetSelected(SelectionEvent e) {
				logged = "";
				JOptionPane.showMessageDialog(null, "Log out Successfull");
				lblCartname.setText("Cart");
				Home.setVisible(true);
				Adminpage.setVisible(false);
			}
		});
		btnLoogoutadmin.setText("Log out");
		btnLoogoutadmin.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		btnLoogoutadmin.setBounds(36, 433, 160, 60);

		adminTable = new Table(Adminpage, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		adminTable.setHeaderBackground(SWTResourceManager.getColor(105, 105, 105));
		adminTable.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		adminTable.setLocation(260, 350);
		adminTable.setSize(1068, 234);
		adminTable.setHeaderVisible(true);
		adminTable.setLinesVisible(true);

		lblAdministratorPage = new Label(Adminpage, SWT.NONE);
		lblAdministratorPage.setAlignment(SWT.CENTER);
		lblAdministratorPage.setFont(SWTResourceManager.getFont("Tahoma", 13, SWT.BOLD));
		lblAdministratorPage.setText("Administrator Page");
		lblAdministratorPage.setBounds(20, 20, 200, 40);
		lblAdministratorPage.setBackground(fundo);
		lblAdministratorPage.setForeground(cinza);

		// change product
		Changeproduct = new Composite(Adminpage, SWT.NONE);
		Changeproduct.setBounds(260, 10, 1192, 574);
		Changeproduct.setBackground(fundo);

		lblChangeProduct = new Label(Changeproduct, SWT.NONE);
		lblChangeProduct.setBackground(fundo);
		lblChangeProduct.setForeground(cinza);
		lblChangeProduct.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		lblChangeProduct.setText("Change Product");
		lblChangeProduct.setBounds(20, 40, 150, 35);

		modelupdate = new Text(Changeproduct, SWT.BORDER);
		modelupdate.setBackground(fundo2);
		modelupdate.setForeground(cinza);
		modelupdate.setText("Model");
		modelupdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (modelupdate.getText().trim().toLowerCase().equals("model")) {
					modelupdate.setText("");
					modelupdate.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (modelupdate.getText().trim().equals("")
						|| modelupdate.getText().trim().toLowerCase().equals("Model")) {
					modelupdate.setText("Model");
					modelupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		modelupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		modelupdate.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		modelupdate.setBounds(75, 100, 340, 30);

		descriptionupdate = new Text(Changeproduct, SWT.BORDER);
		descriptionupdate.setForeground(cinza);
		descriptionupdate.setBackground(fundo2);
		descriptionupdate.setText("Description");
		descriptionupdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (descriptionupdate.getText().trim().toLowerCase().equals("description")) {
					descriptionupdate.setText("");
					descriptionupdate.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (descriptionupdate.getText().trim().equals("")
						|| descriptionupdate.getText().trim().toLowerCase().equals("Description")) {
					descriptionupdate.setText("Description");
					descriptionupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		descriptionupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		descriptionupdate.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		descriptionupdate.setBounds(75, 270, 550, 30);

		priceupdate = new Text(Changeproduct, SWT.BORDER);
		priceupdate.setBackground(fundo2);
		priceupdate.setForeground(cinza);
		priceupdate.setText("Price");
		priceupdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (priceupdate.getText().trim().toLowerCase().equals("price")) {
					priceupdate.setText("");
					priceupdate.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (priceupdate.getText().trim().equals("")
						|| priceupdate.getText().trim().toLowerCase().equals("Price")) {
					priceupdate.setText("Price");
					priceupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		priceupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		priceupdate.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		priceupdate.setBounds(75, 210, 80, 30);

		stockupdate = new Text(Changeproduct, SWT.BORDER);
		stockupdate.setForeground(cinza);
		stockupdate.setBackground(fundo2);
		stockupdate.setText("Stock");
		stockupdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (stockupdate.getText().trim().toLowerCase().equals("stock")) {
					stockupdate.setText("");
					stockupdate.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (stockupdate.getText().trim().equals("")
						|| stockupdate.getText().trim().toLowerCase().equals("Stock")) {
					stockupdate.setText("Stock");
					stockupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		stockupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		stockupdate.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		stockupdate.setBounds(75, 160, 80, 30);

		rankingupdate = new Text(Changeproduct, SWT.BORDER);
		rankingupdate.setForeground(cinza);
		rankingupdate.setBackground(fundo2);
		rankingupdate.setText("Ranking");
		rankingupdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (rankingupdate.getText().trim().toLowerCase().equals("ranking")) {
					rankingupdate.setText("");
					rankingupdate.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (rankingupdate.getText().trim().equals("")
						|| rankingupdate.getText().trim().toLowerCase().equals("Ranking")) {
					rankingupdate.setText("Ranking");
					rankingupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		rankingupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		rankingupdate.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		rankingupdate.setBounds(499, 160, 80, 30);

		proupdatesms = new Label(Changeproduct, SWT.NONE);
		proupdatesms.setForeground(cinza);
		proupdatesms.setBackground(fundo);
		proupdatesms.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		proupdatesms.setBounds(1010, 275, 200, 50);

		changeprobtn = new Button(Changeproduct, SWT.NONE);
		changeprobtn.setBackground(roxo);
		changeprobtn.setForeground(cinza);
		changeprobtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		changeprobtn.addSelectionListener(new SelectionAdapter() {
			////////// CHANGE PRODUCT INFO
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (modelupdate.getText().equals("Model")) {
					System.out.println("Campo Vazio.");
					proupdatesms.setText("Fill the Model");
				} else {
					ArrayList<ProductList> products = AdminData.modelSearch(modelupdate.getText().trim());
					int i;

					String model = new String();
					String description = new String();
					int qty;
					double price;

					for (i = 0; i < products.size(); i++) {
						model = products.get(i).getModel();
						price = products.get(i).getPrice();
						qty = products.get(i).getQty();
						description = products.get(i).getDescription();
						System.out.println("dados " + model + "||" + price + "||" + qty + "||" + description);

						if (priceupdate.getText().trim().equals("Price")) {
							priceupdate.setText(Double.toString(price));
							priceupdate.setForeground(cinza);
						}
						if (stockupdate.getText().trim().equals("Stock")) {
							stockupdate.setText(Integer.toString(qty));
							// stockupdate.setForeground(cinza);
						}
						if (descriptionupdate.getText().trim().equals("description")) {
							descriptionupdate.setText(description);
						}
					}

					ProductList admin_update = new ProductList("", modelupdate.getText(),
							Double.valueOf(priceupdate.getText()), Integer.valueOf(stockupdate.getText()),
							descriptionupdate.getText(), 0, Integer.valueOf(rankingupdate.getText()), "", 0, "");

					AdminData.adminUpdate(admin_update);

					System.out.println("Update with Success");
					JOptionPane.showMessageDialog(null, modelupdate.getText() + " Update with Success");

					modelupdate.setText("Model");
					modelupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					descriptionupdate.setText("Description");
					descriptionupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					priceupdate.setText("Price");
					priceupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					stockupdate.setText("Stock");
					stockupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					rankingupdate.setText("Ranking");
					rankingupdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

					removePtable();

					products.clear();
				}
			}

		});
		changeprobtn.setText("Change");
		changeprobtn.setBounds(1010, 200, 150, 50);
		Changeproduct.setVisible(false);

		// remove product

		Removeproduct = new Composite(Adminpage, SWT.NONE);
		Removeproduct.setVisible(false);
		Removeproduct.setBackground(fundo);
		Removeproduct.setBounds(260, 10, 1192, 574);

		lblRemoveProduct = new Label(Removeproduct, SWT.NONE);
		lblRemoveProduct.setBackground(fundo);
		lblRemoveProduct.setForeground(cinza);
		lblRemoveProduct.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		lblRemoveProduct.setText("Remove Product");
		lblRemoveProduct.setBounds(20, 40, 165, 35);

		nameremovepro = new Text(Removeproduct, SWT.BORDER);
		nameremovepro.setForeground(cinza);
		nameremovepro.setBackground(fundo2);
		nameremovepro.setText("Model");
		nameremovepro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (nameremovepro.getText().trim().toLowerCase().equals("model")) {
					nameremovepro.setText("");
					nameremovepro.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nameremovepro.getText().trim().equals("")
						|| nameremovepro.getText().trim().toLowerCase().equals("Model")) {
					nameremovepro.setText("Model");
					nameremovepro.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		nameremovepro.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		nameremovepro.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		nameremovepro.setLocation(275, 90);
		nameremovepro.setSize(300, 30);

		proremovesms = new Label(Removeproduct, SWT.NONE);
		proremovesms.setForeground(cinza);
		proremovesms.setBackground(fundo);
		proremovesms.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		proremovesms.setBounds(1010, 250, 125, 42);

		removeprobtn = new Button(Removeproduct, SWT.NONE);
		removeprobtn.setBackground(roxo);
		removeprobtn.setForeground(cinza);
		removeprobtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		removeprobtn.addSelectionListener(new SelectionAdapter() {
			///////////////// REMOVE PRODUCT BUTTON
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (nameremovepro.getText().trim().equals("Model")) {
					System.out.println("Campo de texto vazio");
					proremovesms.setText("Fill the Model");
				} else {

					ProductList admin_remove = new ProductList("", nameremovepro.getText().trim(), 0, 0, "", 0, 0, "",
							0, "");
					AdminData.adminRemove(admin_remove);

					System.out.println("Removed with Success");
					JOptionPane.showMessageDialog(null, nameremovepro.getText() + " Removed with Success");

					nameremovepro.setText("Model");
					nameremovepro.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

					removePtable();
				}

			}
		});
		removeprobtn.setText("Remove");
		removeprobtn.setBounds(1010, 200, 150, 50);

		Removeproduct.setVisible(false);

		// addproduct
		Addproduct = new Composite(Adminpage, SWT.NONE);
		Addproduct.setVisible(false);
		Addproduct.setBounds(260, 10, 1192, 574);
		Addproduct.setBackground(fundo);
		Addproduct.setForeground(cinza);

		lblAddProduct = new Label(Addproduct, SWT.NONE);
		lblAddProduct.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.BOLD));
		lblAddProduct.setText("Add Product");
		lblAddProduct.setBounds(20, 40, 150, 35);
		lblAddProduct.setBackground(fundo);
		lblAddProduct.setForeground(cinza);

		brandadd = new Text(Addproduct, SWT.BORDER);
		brandadd.setText("Brand");
		brandadd.setForeground(cinza);
		brandadd.setBackground(fundo2);
		brandadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (brandadd.getText().trim().toLowerCase().equals("brand")) {
					brandadd.setText("");
					brandadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (brandadd.getText().trim().equals("") || brandadd.getText().trim().toLowerCase().equals("Brand")) {
					brandadd.setText("Brand");
					brandadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		brandadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		brandadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		brandadd.setBounds(233, 65, 340, 30);

		modeladd = new Text(Addproduct, SWT.BORDER);
		modeladd.setForeground(cinza);
		modeladd.setBackground(fundo2);
		modeladd.setText("Model");
		modeladd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (modeladd.getText().trim().toLowerCase().equals("model")) {
					modeladd.setText("");
					modeladd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (modeladd.getText().trim().equals("") || modeladd.getText().trim().toLowerCase().equals("Model")) {
					modeladd.setText("Model");
					modeladd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		modeladd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		modeladd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		modeladd.setBounds(233, 141, 340, 30);

		priceadd = new Text(Addproduct, SWT.BORDER);
		priceadd.setForeground(cinza);
		priceadd.setBackground(fundo2);
		priceadd.setText("Price");
		priceadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (priceadd.getText().trim().toLowerCase().equals("price")) {
					priceadd.setText("");
					priceadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (priceadd.getText().trim().equals("") || priceadd.getText().trim().toLowerCase().equals("Price")) {
					priceadd.setText("Price");
					priceadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		priceadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		priceadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		priceadd.setBounds(233, 257, 170, 30);

		stockadd = new Text(Addproduct, SWT.BORDER);
		stockadd.setForeground(cinza);
		stockadd.setBackground(fundo2);
		stockadd.setText("Stock");
		stockadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (stockadd.getText().trim().toLowerCase().equals("stock")) {
					stockadd.setText("");
					stockadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (stockadd.getText().trim().equals("") || stockadd.getText().trim().toLowerCase().equals("Stock")) {
					stockadd.setText("Stock");
					stockadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		stockadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		stockadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		stockadd.setBounds(233, 300, 170, 30);

		descriptionadd = new Text(Addproduct, SWT.BORDER);
		descriptionadd.setForeground(cinza);
		descriptionadd.setBackground(fundo2);
		descriptionadd.setText("Description");
		descriptionadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (descriptionadd.getText().trim().toLowerCase().equals("description")) {
					descriptionadd.setText("");
					descriptionadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (descriptionadd.getText().trim().equals("")
						|| descriptionadd.getText().trim().toLowerCase().equals("Description")) {
					descriptionadd.setText("Description");
					descriptionadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		descriptionadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		descriptionadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		descriptionadd.setBounds(233, 207, 340, 30);

		imageadd = new Label(Addproduct, SWT.BORDER);
		imageadd.setForeground(cinza);
		imageadd.setBackground(fundo2);
		imageadd.setText("Image");
		imageadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (imageadd.getText().trim().toLowerCase().equals("image")) {
					imageadd.setText("");
					imageadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (imageadd.getText().trim().equals("") || imageadd.getText().trim().toLowerCase().equals("Image")) {
					imageadd.setText("Image");
					imageadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		imageadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		imageadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		imageadd.setBounds(662, 141, 340, 30);

		categoryadd = new Text(Addproduct, SWT.BORDER);
		categoryadd.setForeground(cinza);
		categoryadd.setBackground(fundo2);
		categoryadd.setText("Category");
		categoryadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (categoryadd.getText().trim().toLowerCase().equals("category")) {
					categoryadd.setText("");
					categoryadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (categoryadd.getText().trim().equals("")
						|| categoryadd.getText().trim().toLowerCase().equals("Category")) {
					categoryadd.setText("Category");
					categoryadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		categoryadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		categoryadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		categoryadd.setBounds(662, 65, 340, 30);

		typeadd = new Text(Addproduct, SWT.BORDER);
		typeadd.setForeground(cinza);
		typeadd.setBackground(fundo2);
		typeadd.setText("Type");
		typeadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (typeadd.getText().trim().toLowerCase().equals("type")) {
					typeadd.setText("");
					typeadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (typeadd.getText().trim().equals("") || typeadd.getText().trim().toLowerCase().equals("Type")) {
					typeadd.setText("Type");
					typeadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		typeadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		typeadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		typeadd.setBounds(662, 207, 340, 30);

		batrankadd = new Text(Addproduct, SWT.BORDER);
		batrankadd.setForeground(cinza);
		batrankadd.setBackground(fundo2);
		batrankadd.setText("Battery Rank");
		batrankadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (batrankadd.getText().trim().toLowerCase().equals("battery rank")) {
					batrankadd.setText("");
					batrankadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (batrankadd.getText().trim().equals("")
						|| batrankadd.getText().trim().toLowerCase().equals("Battery Rank")) {
					batrankadd.setText("Battery Rank");
					batrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		batrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		batrankadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		batrankadd.setBounds(662, 257, 170, 30);

		procrankadd = new Text(Addproduct, SWT.BORDER);
		procrankadd.setForeground(cinza);
		procrankadd.setBackground(fundo2);
		procrankadd.setText("Processing Rank");
		procrankadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (procrankadd.getText().trim().toLowerCase().equals("processing rank")) {
					procrankadd.setText("");
					procrankadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (procrankadd.getText().trim().equals("")
						|| procrankadd.getText().trim().toLowerCase().equals("Processing Rank")) {
					procrankadd.setText("Processing Rank");
					procrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		procrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		procrankadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		procrankadd.setBounds(662, 300, 170, 30);

		rankingadd = new Text(Addproduct, SWT.BORDER);
		rankingadd.setForeground(cinza);
		rankingadd.setBackground(fundo2);
		rankingadd.setText("Ranking");
		rankingadd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (rankingadd.getText().trim().toLowerCase().equals("ranking")) {
					rankingadd.setText("");
					rankingadd.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (rankingadd.getText().trim().equals("")
						|| rankingadd.getText().trim().toLowerCase().equals("Ranking")) {
					rankingadd.setText("Ranking");
					rankingadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		rankingadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		rankingadd.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 12, SWT.NORMAL));
		rankingadd.setBounds(403, 300, 170, 30);

		addprosms = new Label(Addproduct, SWT.NONE);
		addprosms.setForeground(cinza);
		addprosms.setBackground(fundo);
		addprosms.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		addprosms.setBounds(1010, 275, 150, 50);

		addprobtn = new Button(Addproduct, SWT.NONE);
		addprobtn.setForeground(cinza);
		addprobtn.setBackground(roxo);
		addprobtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		addprobtn.addSelectionListener(new SelectionAdapter() {
			/////////////// ADD PRODUCT BUTTON
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (brandadd.getText().equals("Brand") || modeladd.getText().equals("Model")
						|| (priceadd.getText().equals("Price")) || (stockadd.getText().equals("Stock"))
						|| descriptionadd.getText().equals("Description") || categoryadd.getText().equals("Category")
						|| rankingadd.getText().equals("Ranking") || typeadd.getText().equals("Type")
						|| batrankadd.getText().equals("Battery Rank")
						|| procrankadd.getText().equals("Processing Rank") || imageadd.getText().equals("Image")
						|| imageadd.getText().equals("")) {
					System.out.println("Preencher Todos Os Dados.");
					addprosms.setText("Fill all spaces");
				} else {

					ProductList admin_add = new ProductList(brandadd.getText(), modeladd.getText(),
							Double.valueOf(priceadd.getText()), Integer.valueOf(stockadd.getText()),
							descriptionadd.getText(), Integer.valueOf(batrankadd.getText()),
							Integer.valueOf(procrankadd.getText()), typeadd.getText(),
							Integer.valueOf(rankingadd.getText()), categoryadd.getText());

					AdminData.adminADD(admin_add);

					System.out.println("ADD with Success");
					JOptionPane.showMessageDialog(null, modeladd.getText() + " ADD with Success");

					brandadd.setText("Brand");
					brandadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					modeladd.setText("Model");
					modeladd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					priceadd.setText("Price");
					priceadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					stockadd.setText("Stock");
					stockadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					descriptionadd.setText("Description");
					descriptionadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					imageadd.setText("Image");
					imageadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					categoryadd.setText("Category");
					categoryadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					typeadd.setText("Type");
					typeadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					batrankadd.setText("Battery Rank");
					batrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					procrankadd.setText("Processing Rank");
					procrankadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					rankingadd.setText("Ranking");
					rankingadd.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

					removePtable();
					addprosms.setText("");
				}
			}
		});
		addprobtn.setText("Add");
		addprobtn.setBounds(1010, 200, 150, 50);

		Button addimagepro = new Button(Addproduct, SWT.NONE);
		addimagepro.setForeground(cinza);
		addimagepro.setBackground(roxo);
		addimagepro.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 13, SWT.NORMAL));
		addimagepro.addSelectionListener(new SelectionAdapter() {
			/////////////// ADD IMAGE
			@Override
			public void widgetSelected(SelectionEvent e) {

				// check if the user select an image

				// select an image and set the imagine path into a jlabel
				String path = null;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

				FileNameExtensionFilter extension = new FileNameExtensionFilter("*Imagens", ".jpg", "png", "jpeg");
				// FileNameExtensionFilter extension = new FileNameExtensionFilter("png");
				chooser.addChoosableFileFilter(extension);

				int filestate = chooser.showSaveDialog(null);

				File selectedImage = chooser.getSelectedFile();
				path = selectedImage.getAbsolutePath();

				int width = 1920; // width of the image
				int height = 1080; // height of the image
				BufferedImage image200 = null;
				File f = null;

				BufferedImage image100 = null;

				// read image
				try {
					selectedImage = new File(path); // image file path
					image200 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					image200 = ImageIO.read(selectedImage);
					System.out.println("Reading complete.");
					System.out.println("Path imagem ori" + path);
				} catch (IOException er) {
					System.out.println("Error: " + er);
				}

				// Resize 200x200

				// int mode = scale < 1 ? BufferedImage.SCALE_AREA_AVERAGING :
				// BufferedImage.SCALE_SMOOTH;
				java.awt.Image scaledImage200 = image200.getScaledInstance(200, 200, 0);

				image200 = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
				image200.getGraphics().drawImage(scaledImage200, 0, 0, null);

				// reconstruct swt image
				imageData = convertToSWT(image200);

				// write image200

				try {

					String[] aux = this.getClass().getResource("/Products By ProductID/").toString().split("/", 2);

					String newpath = aux[1] + modeladd.getText().trim() + "200.png";

					newpath = newpath.replace("bin", "src");
					newpath = newpath.replace("%20", " ");

					System.out.println("path final = " + newpath);

					f = new File(newpath); // output file path
					// f = new File("C:/Users/ksama/OneDrive - Universidade do
					// Porto/Documentos/GitHub/Aztech/AZtech/src/adminadmin.png");
					f.createNewFile();
					ImageIO.write(image200, "png", f);
					System.out.println("Writing complete.");

				} catch (IOException ex) {
					System.out.println("Error: " + ex);
				}

				// read image100
				try {
					selectedImage = new File(path); // image file path
					image100 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					image100 = ImageIO.read(selectedImage);
					System.out.println("Reading complete.");
					System.out.println("Path imagem ori" + path);
				} catch (IOException er) {
					System.out.println("Error: " + er);
				}

				// Resize 100x100

				// int mode = scale < 1 ? BufferedImage.SCALE_AREA_AVERAGING :
				// BufferedImage.SCALE_SMOOTH;
				java.awt.Image scaledImage100 = image100.getScaledInstance(100, 100, 0);

				image100 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
				image100.getGraphics().drawImage(scaledImage100, 0, 0, null);

				// reconstruct swt image
				imageData = convertToSWT(image100);

				// write image200

				try {

					String[] aux = this.getClass().getResource("/Products By ProductID/").toString().split("/", 2);

					String newpath = aux[1] + modeladd.getText().trim() + "100.png";

					newpath = newpath.replace("bin", "src");
					newpath = newpath.replace("%20", " ");

					System.out.println("path final = " + newpath);

					f = new File(newpath); // output file path
					// f = new File("C:/Users/ksama/OneDrive - Universidade do
					// Porto/Documentos/GitHub/Aztech/AZtech/src/adminadmin.png");
					f.createNewFile();
					ImageIO.write(image100, "png", f);
					System.out.println("Writing complete.");

					imageadd.setText(newpath);

				} catch (IOException ex) {
					System.out.println("Error: " + ex);
				}

			}
		});
		addimagepro.setText("Image");
		addimagepro.setBounds(1010, 120, 150, 50);

		Addproduct.setVisible(false);
		Adminpage.setVisible(false);
		Adminpage.setVisible(false);

		// loginpage
		Loginpage = new Composite(shell, SWT.NONE);
		Loginpage.setBackground(fundo);
		Loginpage.setLocation(0, 79);
		Loginpage.setSize(1476, 602);

		loginadminbtn = new Button(Loginpage, SWT.NONE);
		loginadminbtn.setForeground(cinza);
		loginadminbtn.setBackground(fundo);
		loginadminbtn.addSelectionListener(new SelectionAdapter() {
			////////////////// LOGIN AS ADMIN BUTTON
			@Override
			public void widgetSelected(SelectionEvent e) {

				ArrayList<UserList> user_inf = UserData.userInformation(username.getText().trim());

				String usernameData = new String();
				String passwordData = new String();
				String typeData = new String();

				for (int i = 0; i < user_inf.size(); i++) {

					usernameData = user_inf.get(i).getusername();
					passwordData = user_inf.get(i).getpassword();
					typeData = user_inf.get(i).gettype();
					System.out.println("user:" + usernameData + "  passe:" + passwordData + "  tipo:" + typeData);

					if (username.getText().equals(usernameData)) {
						if (password.getText().equals(passwordData)) {
							if (typeData.equals("admin"))
								JOptionPane.showMessageDialog(null, "Login as Administrator Successfull");
							// logged = user_ad.get(i).getusername();
							logged = "Admin";
							lblCartname.setText(logged + "'s Cart");
							Adminpage.setVisible(true);
							Loginpage.setVisible(false);
							username.setText("username");
							username.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							break;
						} else {
							validation.setText("Invalid Password");
						}
					}
				}
				if (logged.equals("")) {
					validation.setText("Invalid Username or Password");
				}
				password.setText("password");
				password.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

			}
		});
		loginadminbtn.setText("Login as Administrator");
		loginadminbtn.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
		loginadminbtn.setBounds(1118, 548, 148, 26);

		Loginbtn_page = new Button(Loginpage, SWT.TOGGLE);
		Loginbtn_page.setForeground(cinza);
		Loginbtn_page.setBackground(roxo);
//									Loginbtn_page.addMouseTrackListener(new MouseTrackAdapter() {
//										@Override
//										public void mouseEnter(MouseEvent e) {
//											Loginbtn_page.setBackground(SWTResourceManager.getColor(0,0,204));
//										}
//										@Override
//										public void mouseExit(MouseEvent e) {
//											Loginbtn_page.setBackground(SWTResourceManager.getColor(0,0,255));
//										}
//									});
		Loginbtn_page.addSelectionListener(new SelectionAdapter() {
			///////////////////// LOGIN AS USER
			@Override
			public void widgetSelected(SelectionEvent e) {

				ArrayList<UserList> user_inf = UserData.userInformation(username.getText().trim());

				String usernameData = new String();
				String passwordData = new String();

				for (int i = 0; i < user_inf.size(); i++) {

					usernameData = user_inf.get(i).getusername();
					passwordData = user_inf.get(i).getpassword();
					System.out.println("user:" + usernameData + "  passe:" + passwordData);

					if (username.getText().equals(usernameData)) {
						if (password.getText().equals(passwordData)) {
							JOptionPane.showMessageDialog(null, "Login Successfull");
							logged = user_inf.get(i).getusername();
							lblCartname.setText(logged + "'s Cart");
							Home.setVisible(true);
							Loginpage.setVisible(false);
							username.setText("username");
							username.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							break;
						} else {
							validation.setText("Invalid Password");
						}
					}
				}
				if (logged.equals("")) {
					validation.setText("Invalid Username or Password");
				}
				password.setText("password");
				password.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

			}
		});
		Loginbtn_page.setText("Login");
		Loginbtn_page.setForeground(SWTResourceManager.getColor(255, 255, 255));
		Loginbtn_page.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 16, SWT.BOLD));
		Loginbtn_page.setBackground(roxo);
		Loginbtn_page.setBounds(600, 387, 339, 66);

		lbcreateaccount = new Label(Loginpage, SWT.NONE);
		lbcreateaccount.setForeground(cinza);
		lbcreateaccount.setBackground(fundo);
		lbcreateaccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Registerpage.setVisible(true);
				Loginpage.setVisible(false);
			}
		});
		lbcreateaccount.setText("No account? Create one!");
		lbcreateaccount.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
		lbcreateaccount.setBounds(600, 467, 156, 20);

		validation = new Label(Loginpage, SWT.NONE);
		validation.setForeground(cinza);
		validation.setBackground(fundo);
		validation.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.BOLD));
		validation.setBackground(fundo);
		validation.setBounds(600, 350, 339, 20);

		password = new Text(Loginpage, SWT.BORDER | SWT.PASSWORD);
		password.setForeground(cinza);
		password.setBackground(fundo2);
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (password.getText().trim().toLowerCase().equals("password")) {
					password.setText("");
					password.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (password.getText().trim().equals("")
						|| password.getText().trim().toLowerCase().equals("password")) {
					password.setText("password");
					password.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		password.setForeground(SWTResourceManager.getColor(192, 192, 192));
		password.setText("password");
		password.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.BOLD));
		password.setBounds(600, 290, 340, 40);

		username = new Text(Loginpage, SWT.BORDER);
		username.setForeground(cinza);
		username.setBackground(fundo2);
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (username.getText().trim().toLowerCase().equals("username")) {
					username.setText("");
					username.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (username.getText().trim().equals("")
						|| username.getText().trim().toLowerCase().equals("username")) {
					username.setText("username");
					username.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		username.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		username.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 14, SWT.BOLD));
		username.setBounds(600, 210, 340, 40);

		passwordlbl = new Label(Loginpage, SWT.NONE);
		passwordlbl.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.BOLD));
		passwordlbl.setForeground(cinza);
		passwordlbl.setBackground(fundo);
		passwordlbl.setText("Password:");
		passwordlbl.setBounds(600, 265, 70, 15);

		usernamelbl = new Label(Loginpage, SWT.NONE);
		usernamelbl.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 9, SWT.BOLD));
		usernamelbl.setText("Username:");
		usernamelbl.setBounds(600, 185, 70, 15);
		usernamelbl.setBackground(fundo);
		usernamelbl.setForeground(cinza);

		lblLogin = new Label(Loginpage, SWT.NONE);
		lblLogin.setBackground(fundo);
		lblLogin.setForeground(cinza);
		lblLogin.setText("Welcome to AZTECH!");
		lblLogin.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.BOLD));
		lblLogin.setAlignment(SWT.CENTER);
		lblLogin.setBounds(645, 70, 255, 29);
		Loginpage.setVisible(true);
		Loginpage.setVisible(true);

		lblForgotPassword = new Label(Loginpage, SWT.NONE);
		lblForgotPassword.setAlignment(SWT.RIGHT);
		lblForgotPassword.setForeground(cinza);
		lblForgotPassword.setBackground(fundo);
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Loginpage.setVisible(false);
				Changepassword.setVisible(true);

				usernamecp.setText("username");
				usernamecp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				newpasscp.setText("password");
				newpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				confnewpasscp.setText("password");
				confnewpasscp.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			}
		});
		lblForgotPassword.setText("Forgot password?");
		lblForgotPassword.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 8, SWT.BOLD));
		lblForgotPassword.setBounds(783, 467, 156, 20);
		Loginpage.setVisible(false);
		Registerpage.setVisible(false);
		Changepassword.setVisible(false);
		Changeproduct.setVisible(false);
		Addproduct.setVisible(false);
		Adminpage.setVisible(false);
		Loginpage.setVisible(true);

		lock = new Label(Loginpage, SWT.NONE);
		lock.setBackground(fundo);
		Image lockKey = new Image(display, aztechapp.class.getResourceAsStream("Icons/lock.png"));
		lock.setImage(lockKey);

		lock.setBounds(757, 493, 30, 30);

		azulClaro = new Label(Loginpage, SWT.NONE);
		azulClaro.setBounds(738, 110, 75, 4);
		azulClaro.setBackground(azul);
		////////////////// USER HISTORY TABLE HEADER

		for (int i = 0; i < titleshistory.length; i++) {
			TableColumn column = new TableColumn(userhistorytbl, SWT.CENTER);
			column.setText(titleshistory[i]);
		}

//topbar 
		Composite Topbar = new Composite(shell, SWT.NONE);
		Topbar.setLocation(0, 0);
		Topbar.setBackground(SWTResourceManager.getColor(23, 33, 46));
		Topbar.setSize(1480, 80);

		lblAztech = new Label(Topbar, SWT.NONE);
		lblAztech.setBackground(SWTResourceManager.getColor(23, 33, 46));
		lblAztech.setForeground(SWTResourceManager.getColor(229, 230, 231));
		// return to home page
		lblAztech.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				Home.setVisible(true);
				Loginpage.setVisible(false);
				Registerpage.setVisible(false);
				Adminpage.setVisible(false);
				Changepassword.setVisible(false);
				Cartpage.setVisible(false);
				Computerfilters.setVisible(false);
				Mobilefilters.setVisible(false);
				Componentsfilters.setVisible(false);
				Userpage.setVisible(false);
				updateHomeTable();
			}

			////////// HOME BUTTON TOPLEFT
			private void updateHomeTable() {
				// Gets eletronics products and puts them into table
				// homeTable.remove(0, homeTable.getColumns().length);
				// homeTable.redraw();
				ArrayList<ProductList> listinit = ProductData.homePage(3);
				homeTable.removeAll();
				packhomeTable(listinit);

				// Gets mobile products and puts them into table

				listinit = ProductData.homePage(2);

				packhomeTable(listinit);

				// Gets computer products and puts them into table

				listinit = ProductData.homePage(1);

				packhomeTable(listinit);
				;

				for (int i = 0; i < titles.length; i++) {
					homeTable.getColumn(i).pack();
				}

				listinit.clear();

			}
		});
		lblAztech.setFont(SWTResourceManager.getFont("Tahoma", 28, SWT.BOLD));
		lblAztech.setAlignment(SWT.CENTER);
		lblAztech.setBounds(10, 5, 192, 65);
		lblAztech.setText("AZTECH");

		searchbar = new Text(Topbar, SWT.BORDER);
		searchbar.setText("Search");
		searchbar.setForeground(cinza);
		searchbar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// clear the textfield
				if (searchbar.getText().trim().toLowerCase().equals("search")) {
					searchbar.setText("");
					searchbar.setForeground(cinza);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchbar.getText().trim().equals("")
						|| searchbar.getText().trim().toLowerCase().equals("Search")) {
					searchbar.setText("Search");
					searchbar.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
		});
		searchbar.setBackground(fundo2);
		searchbar.setForeground(cinza);
		searchbar.setFont(SWTResourceManager.getFont("Bahnschrift SemiBold", 15, SWT.NORMAL));
		searchbar.setBounds(550, 30, 416, 30);

		loginbtn = new Label(Topbar, SWT.NONE);
		loginbtn.setTouchEnabled(true);
		loginbtn.setBackground(fundo2);
		Image account = new Image(display, aztechapp.class.getResourceAsStream("Icons/account.png"));
		loginbtn.setImage(account);
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				if (logged.equals("")) {
					username.setText("username");
					username.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					password.setText("password");
					password.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));

					Home.setVisible(false);
					Registerpage.setVisible(false);
					Adminpage.setVisible(false);
					Loginpage.setVisible(false);
					Changepassword.setVisible(false);
					Loginpage.setVisible(true);
					Cartpage.setVisible(false);
					Userpage.setVisible(false);
					validation.setText("");

				} else if (logged.equals("Admin")) {
					Home.setVisible(false);
					Registerpage.setVisible(false);
					Adminpage.setVisible(true);
					Loginpage.setVisible(false);
					Changepassword.setVisible(false);
					Loginpage.setVisible(false);
					Cartpage.setVisible(false);
					Userpage.setVisible(false);
					removePtable();
				} else if (!logged.equals("")) {
					Home.setVisible(false);
					Registerpage.setVisible(false);
					Adminpage.setVisible(false);
					Loginpage.setVisible(false);
					Changepassword.setVisible(false);
					Loginpage.setVisible(false);
					Cartpage.setVisible(false);
					Userpage.setVisible(true);
				}
			}
		});
		loginbtn.setBounds(1140, 30, 30, 30);

		cartbtn = new Label(Topbar, SWT.NONE);
		cartbtn.setForeground(fundo2);
		Image shopCart = new Image(display, aztechapp.class.getResourceAsStream("Icons/shoppingCart.png"));
		cartbtn.setBackground(fundo2);
		cartbtn.setImage(shopCart);
		cartbtn.addMouseListener(new MouseAdapter() {
			////////// CART BUTTON
			@Override
			public void mouseDown(MouseEvent e) {
				Home.setVisible(false);
				Registerpage.setVisible(false);
				Adminpage.setVisible(false);
				Loginpage.setVisible(false);
				Changepassword.setVisible(false);
				Cartpage.setVisible(true);
				Userpage.setVisible(false);

				buySms.setText("");
				lblcartoperation.setText("");
				tblCart.removeAll();

				if (!logged.equals("")) {

					ArrayList<CartList> cart = UserData.cartPage(logged);
					sum = 0;
					for (int i = 0; i < cart.size(); i++) {
						brand = cart.get(i).getBrand();
						model = cart.get(i).getModel();
						price = cart.get(i).getPrice();
						quantity = cart.get(i).getQty();
						System.out.println(
								"dados " + brand + "||" + model + "||" + price + "||" + qty + "||" + description);
						TableItem item = new TableItem(tblCart, SWT.NONE);
						item.setText(0, logged);
						item.setText(1, brand);
						item.setText(2, model);
						item.setText(3, Integer.toString(quantity));
						item.setText(4, Double.toString(price));

						sum = sum + price * quantity;

					}
					lblSum.setText(String.valueOf(sum));
					for (int i = 0; i < titlescart.length; i++) {
						tblCart.getColumn(i).pack();
					}

					cart.clear();

				}

			}
		});
		cartbtn.setBounds(1190, 30, 30, 30);

		searchbtn = new Label(Topbar, SWT.NONE);
		searchbtn.setTouchEnabled(true);
		searchbtn.setBounds(980, 30, 30, 30);
		searchbtn.setBackground(fundo2);
		Image magGlass = new Image(display, aztechapp.class.getResourceAsStream("Icons/magGlass.png"));
		searchbtn.setImage(magGlass);

		Label lblSlogan = new Label(Topbar, SWT.NONE);
		lblSlogan.setForeground(SWTResourceManager.getColor(229, 230, 231));
		lblSlogan.setBackground(SWTResourceManager.getColor(23, 33, 46));
		lblSlogan.setBounds(208, 36, 166, 24);
		lblSlogan.setText("Technology from A to Z.");
		searchbtn.addMouseListener(new MouseAdapter() {
			/////// SEARCH BUTTON
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<ProductList> products = SearchData.componentsSearch(searchbar.getText().trim());

				if (searchbar.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Field Empty");
				else if (SearchData.count == 0)
					JOptionPane.showMessageDialog(null, "Product does not exist");
				homeTable.removeAll();
				packhomeTable(products);

				products.clear();
				Home.setVisible(true);
				Registerpage.setVisible(false);
				Adminpage.setVisible(false);
				Loginpage.setVisible(false);
				Changepassword.setVisible(false);
				Cartpage.setVisible(false);

			}

		});

		///////// ADMIN TABLE HEADER
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(adminTable, SWT.CENTER);
			column.setText(titles[i]);
		}
		//////// HOME TABLE HEADER
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(homeTable, SWT.CENTER);
			column.setText(titles[i]);
		}
		///////// CART TABLE HEADER
		for (int i = 0; i < titlescart.length; i++) {
			TableColumn column = new TableColumn(tblCart, SWT.CENTER);
			column.setText(titlescart[i]);
		}

		for (int i = 0; i < titlescart.length; i++) {
			tblCart.getColumn(i).pack();
		}

		ArrayList<ProductList> listinit = ProductData.homePage(3);
		homeTable.removeAll();
		packhomeTable(listinit);

		// Gets mobile products and puts them into table

		listinit = ProductData.homePage(2);

		packhomeTable(listinit);

		// Gets computer products and puts them into table

		listinit = ProductData.homePage(1);

		packhomeTable(listinit);

		for (int i = 0; i < titles.length; i++) {
			homeTable.getColumn(i).pack();
		}

		listinit.clear();

	}

	protected ImageData convertToSWT(BufferedImage bufferedImage) {
		if (bufferedImage.getColorModel() instanceof DirectColorModel) {
			DirectColorModel colorModel = (DirectColorModel) bufferedImage.getColorModel();
			PaletteData palette = new PaletteData(colorModel.getRedMask(), colorModel.getGreenMask(),
					colorModel.getBlueMask());
			ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(),
					colorModel.getPixelSize(), palette);
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[3];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					int pixel = palette.getPixel(new RGB(pixelArray[0], pixelArray[1], pixelArray[2]));
					data.setPixel(x, y, pixel);
				}
			}
			return data;
		} else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
			IndexColorModel colorModel = (IndexColorModel) bufferedImage.getColorModel();
			int size = colorModel.getMapSize();
			byte[] reds = new byte[size];
			byte[] greens = new byte[size];
			byte[] blues = new byte[size];
			colorModel.getReds(reds);
			colorModel.getGreens(greens);
			colorModel.getBlues(blues);
			RGB[] rgbs = new RGB[size];
			for (int i = 0; i < rgbs.length; i++) {
				rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF, blues[i] & 0xFF);
			}
			PaletteData palette = new PaletteData(rgbs);
			ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(),
					colorModel.getPixelSize(), palette);
			data.transparentPixel = colorModel.getTransparentPixel();
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					data.setPixel(x, y, pixelArray[0]);
				}
			}
			return data;
		}
		return null;
	}

	protected BufferedImage convertToAWT(ImageData data) {
		ColorModel colorModel = null;
		PaletteData palette = data.palette;
		if (palette.isDirect) {
			colorModel = new DirectColorModel(data.depth, palette.redMask, palette.greenMask, palette.blueMask);
			BufferedImage bufferedImage = new BufferedImage(colorModel,
					colorModel.createCompatibleWritableRaster(data.width, data.height), false, null);
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[3];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					int pixel = data.getPixel(x, y);
					RGB rgb = palette.getRGB(pixel);
					pixelArray[0] = rgb.red;
					pixelArray[1] = rgb.green;
					pixelArray[2] = rgb.blue;
					raster.setPixels(x, y, 1, 1, pixelArray);
				}
			}
			return bufferedImage;
		} else {
			RGB[] rgbs = palette.getRGBs();
			byte[] red = new byte[rgbs.length];
			byte[] green = new byte[rgbs.length];
			byte[] blue = new byte[rgbs.length];
			for (int i = 0; i < rgbs.length; i++) {
				RGB rgb = rgbs[i];
				red[i] = (byte) rgb.red;
				green[i] = (byte) rgb.green;
				blue[i] = (byte) rgb.blue;
			}
			if (data.transparentPixel != -1) {
				colorModel = new IndexColorModel(data.depth, rgbs.length, red, green, blue, data.transparentPixel);
			} else {
				colorModel = new IndexColorModel(data.depth, rgbs.length, red, green, blue);
			}
			BufferedImage bufferedImage = new BufferedImage(colorModel,
					colorModel.createCompatibleWritableRaster(data.width, data.height), false, null);
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					int pixel = data.getPixel(x, y);
					pixelArray[0] = pixel;
					raster.setPixel(x, y, pixelArray);
				}
			}
			return bufferedImage;
		}
	}

	protected void packhomeTable(ArrayList<ProductList> listinit) {

		for (int i = 0; i < listinit.size(); i++) {
			brand = listinit.get(i).getBrand();
			model = listinit.get(i).getModel();
			price = listinit.get(i).getPrice();
			qty = listinit.get(i).getQty();
			description = listinit.get(i).getDescription();
			batRank = listinit.get(i).getBatRank();
			procRank = listinit.get(i).getProcRank();
			type = listinit.get(i).getType();
			System.out.println("dados " + brand + "||" + model + "||" + price + "||" + qty + "||" + description + "||"
					+ type + "||" + batRank + "||" + procRank);

			TableItem item = new TableItem(homeTable, SWT.NONE);
			item.setText(0, brand);
			item.setText(1, model);
			item.setText(2, Double.toString(price));
			item.setText(3, Integer.toString(qty));
			if (description == null)
				description = "no description";
			item.setText(4, description);
			item.setText(5, type);
			item.setText(6, Integer.toString(batRank));
			item.setText(7, Integer.toString(procRank));

			System.out.println("/Products By ProductID/" + model + "100.png");
			Image img = new Image(display,
					aztechapp.class.getResourceAsStream("/Products By ProductID/" + model + "100.png"));
			item.setImage(8, img);

		}

		listinit.clear();
	}

	protected void removePtable() { //////////// UPDATE PRODUCT REMOVE TABLE
		ArrayList<ProductList> admintabledata = ProductData.homePage(0);
		adminTable.removeAll();
		for (int i = 0; i < admintabledata.size(); i++) {
			brand = admintabledata.get(i).getBrand();
			model = admintabledata.get(i).getModel();
			price = admintabledata.get(i).getPrice();
			qty = admintabledata.get(i).getQty();
			description = admintabledata.get(i).getDescription();
			batRank = admintabledata.get(i).getBatRank();
			procRank = admintabledata.get(i).getProcRank();
			type = admintabledata.get(i).getType();
			System.out.println("dados " + brand + "||" + model + "||" + price + "||" + qty + "||" + description + "||"
					+ type + "||" + batRank + "||" + procRank);

			TableItem item = new TableItem(adminTable, SWT.NONE);
			item.setText(0, brand);
			item.setText(1, model);
			item.setText(2, Double.toString(price));
			item.setText(3, Integer.toString(qty));
			if (description == null)
				description = "no description";
			item.setText(4, description);
			item.setText(5, type);
			item.setText(6, Integer.toString(batRank));
			item.setText(7, Integer.toString(procRank));

		}
		for (int i = 0; i < titles.length; i++) {
			adminTable.getColumn(i).pack();
		}

		admintabledata.clear();

	}
}
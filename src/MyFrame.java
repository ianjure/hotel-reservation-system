package hotelreservationsystem;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Cursor;
import java.text.DecimalFormat;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opencsv.*;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Scanner;

public class MyFrame extends JFrame implements ActionListener, DateChangeListener{
    JLabel home_image;
    JLabel logo;
    JLabel HRS_title;
    JLabel book_a_room;
    
    JLabel name_label;
    JLabel name_invalid;
    
    JLabel contactNumber_label;
    JLabel contactNumber_invalid;
    
    JLabel roomTypes_label;
    JLabel room_invalid;
    JLabel room_full_single;
    JLabel room_full_double;
    JLabel room_full_triple;
    JLabel room_full_quad;
    JLabel room_full_exec;
    JLabel room_full_pres;
    
    JLabel guestNumber_label;
    
    JLabel checkIn_label;
    JLabel checkIn_invalid;
    
    JLabel checkOut_label;
    JLabel checkOut_invalid;
    
    JLabel MOP_label;
    
    JTextField name;
    JTextField contactNumber;
    
    SpinnerNumberModel model;
    JSpinner guestNumber;
    
    JComboBox roomTypes;
    
    DatePicker currentDate;
    DatePicker checkIn;
    DatePicker checkOut;
    
    JRadioButton cash_button;
    JRadioButton ewallet_button;
    JRadioButton bank_button;
    ButtonGroup ModeOfPayment;
    
    JLabel single_price;
    JLabel double_price;
    JLabel triple_price;
    JLabel quad_price;
    JLabel executive_price;
    JLabel presidential_price;
    
    JLabel single_capacity;
    JLabel double_capacity;
    JLabel triple_capacity;
    JLabel quad_capacity;
    JLabel executive_capacity;
    JLabel presidential_capacity;
    
    JLabel single_description;
    JLabel double_description;
    JLabel triple_description;
    JLabel quad_description;
    JLabel executive_description;
    JLabel presidential_description;
    
    JLabel single_amenities;
    JLabel double_amenities;
    JLabel double_amenities2;
    JLabel triple_amenities;
    JLabel triple_amenities2;
    JLabel quad_amenities;
    JLabel quad_amenities2;
    JLabel executive_amenities;
    JLabel executive_amenities2;
    JLabel presidential_amenities;
    JLabel presidential_amenities2;
    
    JLabel single_image;
    JLabel double_image;
    JLabel triple_image;
    JLabel quad_image;
    JLabel exec_image;
    JLabel pres_image;
    
    JLabel personIcon;
    JPanel black_layer;
    JPanel blue_layer;
    JPanel grey_layer;
    JPanel white_layer;
    
    JLabel total_bill_label;
    JLabel total_bill;
    
    JButton book_button;
    
    int startMonth;
    int endMonth;
    int Days;
    
    String getName;
    String getNumber;
    String getCheckIn;
    String getCheckOut;
    String getRoom;
    String getNumGuest;
    String getMOP;
    String getBill;
    
    boolean singleIsFull = false;
    boolean doubleIsFull = false;
    boolean tripleIsFull = false;
    boolean quadIsFull = false;
    boolean executiveIsFull = false;
    boolean presidentialIsFull = false;
	
    MyFrame(){
        //Image Imports
        ImageIcon icon = new ImageIcon("Icon.png");
        ImageIcon main_image = new ImageIcon("Hotel.jpg");
        ImageIcon singleImage = new ImageIcon("Single.jpg");
        ImageIcon doubleImage = new ImageIcon("Double.jpg");
        ImageIcon tripleImage = new ImageIcon("Triple.jpg");
        ImageIcon quadImage = new ImageIcon("Quad.jpg");
        ImageIcon execImage = new ImageIcon("Executive.gif");
        ImageIcon presImage = new ImageIcon("Presidential.gif");
        ImageIcon person = new ImageIcon("Person.png");
        
        //Home Logo
        ImageIcon logo_img = new ImageIcon("Logo.png");
        logo = new JLabel();
        logo.setIcon(logo_img);
        logo.setBounds(130, 100, 135, 150);
        logo.setVisible(true);
 
        //Home Page Image
        home_image = new JLabel();
        home_image.setIcon(main_image);
        home_image.setBounds(0,0, 365, 600);
        home_image.setVisible(true);
        
        //Person/Capacity Icon
        personIcon = new JLabel();
        personIcon.setIcon(person);
        personIcon.setBounds(340,10, 16, 16);
        personIcon.setVisible(false);
        
        //Price and Capacity Background
        black_layer = new JPanel();
        black_layer.setBounds(0,0, 365, 35);
        black_layer.setBackground(new Color(0,0,0,95));
        black_layer.setVisible(false);
        
        //Hotel Reservation System Title
        HRS_title = new JLabel("<html>HOTEL RESERVATION SYSTEM © 2024</html>", SwingConstants.CENTER);
        HRS_title.setBounds(38, 495, 300, 80);
	HRS_title.setFont(new Font("Inter", Font.PLAIN, 10));
        HRS_title.setForeground(Color.white);
        HRS_title.setVisible(true);
        
        //Book a room text
        book_a_room = new JLabel();
        book_a_room.setText("Book a room");
        book_a_room.setFont(new Font("Inter", Font.BOLD, 25));
        book_a_room.setForeground(Color.black);
        book_a_room.setBounds(557,44, 300, 30);
        
        //Name Label
        name_label = new JLabel();
        name_label.setText("NAME");
        name_label.setForeground(new Color(78,78,78));
        name_label.setBounds(453, 105, 100, 12);
        name_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Name Invalid
        name_invalid = new JLabel();
        name_invalid.setText("INVALID");
        name_invalid.setForeground(Color.red);
        name_invalid.setBounds(766, 105, 200, 12);
        name_invalid.setFont(new Font("Inter", Font.BOLD, 12));
        name_invalid.setVisible(false);
        
        //Name Text Field
        name = new JTextField();
        name.setPreferredSize(new Dimension(350,30));
        name.setBounds(453, 122, 360, 30);
        name.setFont(new Font("Inter", Font.BOLD, 15));
        name.setBorder(BorderFactory.createCompoundBorder(name.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));
        
        //Contact Number Label
        contactNumber_label = new JLabel();
        contactNumber_label.setText("CONTACT NUMBER");
        contactNumber_label.setForeground(new Color(78,78,78));
        contactNumber_label.setBounds(453, 163, 200, 12);
        contactNumber_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Contact Number Invalid
        contactNumber_invalid = new JLabel();
        contactNumber_invalid.setText("INVALID");
        contactNumber_invalid.setForeground(Color.red);
        contactNumber_invalid.setBounds(766, 163, 200, 12);
        contactNumber_invalid.setFont(new Font("Inter", Font.BOLD, 12));
        contactNumber_invalid.setVisible(false);
        
        //Contact Number Text Field
        contactNumber = new JTextField();
        contactNumber.setPreferredSize(new Dimension(350,30));
        contactNumber.setBounds(453, 180, 360, 30);
        contactNumber.setFont(new Font("Inter", Font.BOLD, 15));
        contactNumber.setBorder(BorderFactory.createCompoundBorder(contactNumber.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));
        
        //Contact Number Prevent Letters
        contactNumber.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                String phoneNumber = contactNumber.getText();
                int length = phoneNumber.length();
                
                char input = e.getKeyChar();
                if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
                    if(length < 11){
                        contactNumber.setEditable(true);
                    }else{
                        contactNumber.setEditable(false);
                    }
                }else{
                    if(e.getKeyChar()=='\b'){
                        contactNumber.setEditable(true);
                    }else{
                        contactNumber.setEditable(false);
                    }
                }
            }
        });
        
        //Room Type Label
        roomTypes_label = new JLabel();
        roomTypes_label.setText("ROOM TYPE");
        roomTypes_label.setForeground(new Color(78,78,78));
        roomTypes_label.setBounds(677, 236, 200, 12);
        roomTypes_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Room Invalid Background
        white_layer = new JPanel();
        white_layer.setBounds(765,236, 200, 12);
        white_layer.setBackground(Color.white);
        white_layer.setVisible(false);
        
        //Room Invalid
        room_invalid = new JLabel();
        room_invalid.setText("INVALID");
        room_invalid.setForeground(Color.red);
        room_invalid.setBounds(765, 236, 200, 12);
        room_invalid.setFont(new Font("Inter", Font.BOLD, 12));
        room_invalid.setVisible(false);
        
        //Full Single Room
        room_full_single = new JLabel();
        room_full_single.setText("FULL");
        room_full_single.setForeground(Color.red);
        room_full_single.setBounds(782, 236, 200, 12);
        room_full_single.setFont(new Font("Inter", Font.BOLD, 12));
        room_full_single.setVisible(false);
        
        //Full Double Room
        room_full_double = new JLabel();
        room_full_double.setText("FULL");
        room_full_double.setForeground(Color.red);
        room_full_double.setBounds(782, 236, 200, 12);
        room_full_double.setFont(new Font("Inter", Font.BOLD, 12));
        room_full_double.setVisible(false);
        
        //Full Triple Room
        room_full_triple = new JLabel();
        room_full_triple.setText("FULL");
        room_full_triple.setForeground(Color.red);
        room_full_triple.setBounds(782, 236, 200, 12);
        room_full_triple.setFont(new Font("Inter", Font.BOLD, 12));
        room_full_triple.setVisible(false);
        
        //Full Quad Room
        room_full_quad = new JLabel();
        room_full_quad.setText("FULL");
        room_full_quad.setForeground(Color.red);
        room_full_quad.setBounds(782, 236, 200, 12);
        room_full_quad.setFont(new Font("Inter", Font.BOLD, 12));
        room_full_quad.setVisible(false);
        
        //Full Executive Room
        room_full_exec = new JLabel();
        room_full_exec.setText("FULL");
        room_full_exec.setForeground(Color.red);
        room_full_exec.setBounds(782, 236, 200, 12);
        room_full_exec.setFont(new Font("Inter", Font.BOLD, 12));
        room_full_exec.setVisible(false);
        
        //Full Presidential Room
        room_full_pres = new JLabel();
        room_full_pres.setText("FULL");
        room_full_pres.setForeground(Color.red);
        room_full_pres.setBounds(782, 236, 200, 12);
        room_full_pres.setFont(new Font("Inter", Font.BOLD, 12));
        room_full_pres.setVisible(false);
        
        //Room Type
        String[] roomTypesOptions = {"None", "Single", "Double",
                              "Triple", "Quad",
                              "Executive",
                              "Presidential"};
        roomTypes = new JComboBox(roomTypesOptions);
        roomTypes.setBounds(677,253, 135, 30);
        roomTypes.setFont(new Font("Inter", Font.BOLD, 15));
        roomTypes.addActionListener(this);
        
        //Guest Number Label
        guestNumber_label = new JLabel();
        guestNumber_label.setText("NO. OF GUESTS");
        guestNumber_label.setForeground(new Color(78,78,78));
        guestNumber_label.setBounds(677, 294, 200, 12);
        guestNumber_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Guest Number
        model = new SpinnerNumberModel(0, 0, 0, 1);
        guestNumber = new JSpinner(model);
        guestNumber.setBounds(677, 311, 135, 30);
        guestNumber.setFont(new Font("Inter", Font.BOLD, 15));
        guestNumber.setEditor(new JSpinner.DefaultEditor(guestNumber));
        guestNumber.setEnabled(false);
        guestNumber.setBorder(BorderFactory.createCompoundBorder(name.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));
        
        //Current Date
        currentDate = new DatePicker();
        currentDate.setDateToToday();
        currentDate.setVisible(false);
        
        //Check In Label
        checkIn_label = new JLabel();
        checkIn_label.setText("CHECK IN");
        checkIn_label.setForeground(new Color(78,78,78));
        checkIn_label.setBounds(453, 236, 200, 12);
        checkIn_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Check In Invalid
        checkIn_invalid = new JLabel();
        checkIn_invalid.setText("INVALID");
        checkIn_invalid.setForeground(Color.red);
        checkIn_invalid.setBounds(578, 236, 200, 12);
        checkIn_invalid.setFont(new Font("Inter", Font.BOLD, 12));
        checkIn_invalid.setVisible(false);
        
        //Date Picker Settings
        DatePickerSettings checkInSetting = new DatePickerSettings();
        checkInSetting.setAllowKeyboardEditing(false);
        checkInSetting.setVisibleClearButton(false);
        checkInSetting.setVisibleNextYearButton(false);
        checkInSetting.setVisiblePreviousYearButton(false);
        checkInSetting.setEnableYearMenu(false);
        checkInSetting.setEnableMonthMenu(false);
        
        LocalDate today = LocalDate.now();
        String[] dateToday = today.toString().split("-");
        YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(dateToday[0]), Integer.parseInt(dateToday[1]) + 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        
        DatePickerSettings checkOutSetting = new DatePickerSettings();
        checkOutSetting.setAllowKeyboardEditing(false);
        checkOutSetting.setVisibleClearButton(false);
        checkOutSetting.setVisibleNextYearButton(false);
        checkOutSetting.setVisiblePreviousYearButton(false);
        checkOutSetting.setEnableYearMenu(false);
        checkOutSetting.setEnableMonthMenu(false);
        
        //Check In
        checkIn = new DatePicker();
        checkIn.setDateToToday();
        checkIn.setTextFieldToValidStateIfNeeded();
        checkIn.setBounds(453,253, 200, 30);
        checkIn.setSettings(checkInSetting);
        checkInSetting.setDateRangeLimits(today.minusDays(today.getDayOfMonth() - today.getDayOfMonth()), today.plusDays((today.lengthOfMonth() - today.getDayOfMonth()) + daysInMonth));
        checkIn.addDateChangeListener((DateChangeListener) this);
        
        //Check Out Label
        checkOut_label = new JLabel();
        checkOut_label.setText("CHECK OUT");
        checkOut_label.setForeground(new Color(78,78,78));
        checkOut_label.setBounds(453, 294, 200, 12);
        checkOut_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Check Out Invalid
        checkOut_invalid = new JLabel();
        checkOut_invalid.setText("INVALID");
        checkOut_invalid.setForeground(Color.red);
        checkOut_invalid.setBounds(578, 294, 200, 12);
        checkOut_invalid.setFont(new Font("Inter", Font.BOLD, 12));
        checkOut_invalid.setVisible(false);
        
        //Check Out
        checkOut = new DatePicker();
        checkOut.setDateToToday();
        checkOut.setBounds(453, 311, 200, 30);
        checkOut.setSettings(checkOutSetting);
        checkOutSetting.setDateRangeLimits(today.minusDays(today.getDayOfMonth() - today.getDayOfMonth()), today.plusDays((today.lengthOfMonth() - today.getDayOfMonth()) + daysInMonth));
        checkOut.addDateChangeListener((DateChangeListener) this);
        
        //Mode of Payment Label
        MOP_label = new JLabel();
        MOP_label.setText("MODE OF PAYMENT");
        MOP_label.setForeground(new Color(78,78,78));
        MOP_label.setBounds(453, 367, 200, 12);
        MOP_label.setFont(new Font("Inter", Font.PLAIN, 12));
        
        //Mode of Payment (Cash)
        cash_button = new JRadioButton("Cash");
        cash_button.setFont(new Font("Inter", Font.BOLD, 15));
        cash_button.setBounds(453, 390, 65, 15);
        cash_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cash_button.setFocusable(false);
        cash_button.setBackground(Color.white);
        cash_button.setActionCommand("Cash");
        cash_button.addActionListener(this);
        
        //Mode of Payment (E-Wallet)
        ewallet_button = new JRadioButton("E-Wallet");
        ewallet_button.setFont(new Font("Inter", Font.BOLD, 15));
        ewallet_button.setBounds(573, 390, 85, 15);
        ewallet_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ewallet_button.setFocusable(false);
        ewallet_button.setBackground(Color.white);
        ewallet_button.setActionCommand("E-Wallet");
        ewallet_button.addActionListener(this);
        
        //Mode of Payment (Bank)
        bank_button = new JRadioButton("Bank");
        bank_button.setFont(new Font("Inter", Font.BOLD, 15));
        bank_button.setBounds(693, 390, 65, 15);
        bank_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bank_button.setFocusable(false);
        bank_button.setBackground(Color.white);
        bank_button.setActionCommand("Bank");
        bank_button.addActionListener(this);
        
        //Group Mode of Payment Buttons
        ModeOfPayment = new ButtonGroup();
        ModeOfPayment.add(cash_button);
        ModeOfPayment.add(ewallet_button);
        ModeOfPayment.add(bank_button);
        cash_button.setSelected(true);
        
        //Main Button
        book_button = new JButton();
	book_button.setBounds(508, 440, 250, 50);
	book_button.setText("BOOK NOW");
	book_button.setFocusable(false);
        book_button.setFont(new Font("Inter", Font.BOLD, 20));
	book_button.setForeground(Color.white);
	book_button.setBackground(new Color(11,87,208));
        book_button.addActionListener(this);
        
        //Room Description Background
        blue_layer = new JPanel();
        blue_layer.setBounds(0,250, 365, 260);
        blue_layer.setBackground(new Color(210,225,249));
        blue_layer.setVisible(false);
        
        //Total Bill Background
        grey_layer = new JPanel();
        grey_layer.setBounds(0,500, 365, 65);
        grey_layer.setBackground(new Color(72,72,72));
        grey_layer.setVisible(false);
        
        //Total Bill Label
        total_bill_label = new JLabel();
        total_bill_label.setText("TOTAL BILL:");
        total_bill_label.setBounds(15, 495, 300, 80);
	total_bill_label.setFont(new Font("Inter", Font.BOLD, 15));
        total_bill_label.setForeground(Color.white);
        total_bill_label.setVisible(false);
        
        //Total Bill
        total_bill = new JLabel();
        total_bill.setText("₱ 0.00");
        total_bill.setHorizontalAlignment(SwingConstants.RIGHT);
        total_bill.setBounds(120, 495, 230, 80);
	total_bill.setFont(new Font("Inter", Font.PLAIN, 20));
        total_bill.setForeground(Color.white);
        total_bill.setVisible(false);
        
        //Single Room Image, Description and Amenities
        single_image = new JLabel();
        single_image.setIcon(singleImage);
        single_image.setBounds(0,0, 365, 250);
        single_image.setVisible(false);
        
        single_price = new JLabel("<html>₱ 2,000 / Day</html>", SwingConstants.CENTER);
        single_capacity = new JLabel("<html>1</html>", SwingConstants.CENTER);
        single_description = new JLabel("<html>Experience unparalleled comfort in our stylish Single rooms, perfect for solo travelers seeking relaxation and convenience.</html>", SwingConstants.CENTER);
        single_amenities = new JLabel("<html>• Air Conditioned<br>• Television with Cable<br>• Internet<br>• Linen & Towels Provided<br>• Toiletries<br>• Small Desk<br>• Telephone<br>• Room Service</html>", SwingConstants.LEFT);
        
        single_price.setBounds(4, 8, 100, 18);
	single_price.setFont(new Font("Inter", Font.BOLD, 15));
        single_price.setForeground(Color.white);
        
        single_capacity.setBounds(280, 9, 100, 18);
	single_capacity.setFont(new Font("Inter", Font.BOLD, 16));
        single_capacity.setForeground(Color.white);
        
        single_description.setBounds(25, 255, 320, 80);
	single_description.setFont(new Font("Inter", Font.ITALIC, 15));
        single_description.setForeground(Color.black);
        
        single_amenities.setBounds(30, 320, 300, 200);
        single_amenities.setFont(new Font("Inter", Font.PLAIN, 12));
        single_amenities.setForeground(Color.black);
        
        single_price.setVisible(false);
        single_capacity.setVisible(false);
        single_description.setVisible(false);
        single_amenities.setVisible(false);
        
        //Double Room Image, Description and Amenities
        double_image = new JLabel();
        double_image.setIcon(doubleImage);
        double_image.setBounds(0,0, 365, 250);
        double_image.setVisible(false);
        
        double_price = new JLabel("<html>₱ 3,500 / Day</html>", SwingConstants.CENTER);
        double_capacity = new JLabel("<html>2</html>", SwingConstants.CENTER);
        double_description = new JLabel("<html>Embrace shared moments in our inviting Double rooms, designed for couples or close companions seeking a cozy retreat.</html>", SwingConstants.CENTER);
        double_amenities = new JLabel("<html>• Mini Fridge<br>• Iron & Ironing Board<br>• Air Conditioned<br>• Television with Cable<br>• Internet<br>• Linen & Towels Provided<br>• Toiletries<br>• Small Desk</html>", SwingConstants.LEFT);
        double_amenities2 = new JLabel("<html>• Telephone<br>• Room Service</html>", SwingConstants.LEFT);
        
        double_price.setBounds(4, 8, 100, 18);
	double_price.setFont(new Font("Inter", Font.BOLD, 15));
        double_price.setForeground(Color.white);
        
        double_capacity.setBounds(280, 9, 100, 18);
	double_capacity.setFont(new Font("Inter", Font.BOLD, 16));
        double_capacity.setForeground(Color.white);
        
        double_description.setBounds(25, 255, 320, 80);
	double_description.setFont(new Font("Inter", Font.ITALIC, 15));
        double_description.setForeground(Color.black);
        
        double_amenities.setBounds(30, 320, 300, 200);
        double_amenities.setFont(new Font("Inter", Font.PLAIN, 12));
        double_amenities.setForeground(Color.black);
        
        double_amenities2.setBounds(195, 272, 300, 200);
        double_amenities2.setFont(new Font("Inter", Font.PLAIN, 12));
        double_amenities2.setForeground(Color.black);
        
        double_price.setVisible(false);
        double_capacity.setVisible(false);
        double_description.setVisible(false);
        double_amenities.setVisible(false);
        double_amenities2.setVisible(false);
        
        //Triple Room Image, Description and Amenities
        triple_image = new JLabel();
        triple_image.setIcon(tripleImage);
        triple_image.setBounds(0,0, 365, 250);
        triple_image.setVisible(false);
        
        triple_price = new JLabel("<html>₱ 5,000 / Day</html>", SwingConstants.CENTER);
        triple_capacity = new JLabel("<html>3</html>", SwingConstants.CENTER);
        triple_description = new JLabel("<html>Discover versatile comfort in our spacious Triple rooms, ideal for small families or friends seeking a memorable stay.</html>", SwingConstants.CENTER);
        triple_amenities = new JLabel("<html>• Balcony<br>• Laundry Facilities<br>• Hairdryer<br>• Air Conditioned<br>• Iron & Ironing Board<br>• Coffee Maker<br>• Mini Fridge<br>• High Quality beddings</html>", SwingConstants.LEFT);
        triple_amenities2 = new JLabel("<html>• Toiletries<br>• Desk w/ Adjustable Lamp<br>• Television with Cable<br>• Internet<br>• Telephone<br>• Room Service</html>", SwingConstants.LEFT);
        
        triple_price.setBounds(4, 8, 100, 18);
	triple_price.setFont(new Font("Inter", Font.BOLD, 15));
        triple_price.setForeground(Color.white);
        
        triple_capacity.setBounds(280, 9, 100, 18);
	triple_capacity.setFont(new Font("Inter", Font.BOLD, 16));
        triple_capacity.setForeground(Color.white);
        
        triple_description.setBounds(25, 255, 320, 80);
	triple_description.setFont(new Font("Inter", Font.ITALIC, 15));
        triple_description.setForeground(Color.black);
        
        triple_amenities.setBounds(30, 320, 300, 200);
        triple_amenities.setFont(new Font("Inter", Font.PLAIN, 12));
        triple_amenities.setForeground(Color.black);
        
        triple_amenities2.setBounds(195, 304, 300, 200);
        triple_amenities2.setFont(new Font("Inter", Font.PLAIN, 12));
        triple_amenities2.setForeground(Color.black);
        
        triple_price.setVisible(false);
        triple_capacity.setVisible(false);
        triple_description.setVisible(false);
        triple_amenities.setVisible(false);
        triple_amenities2.setVisible(false);
        
        //Quad Room Image, Description and Amenities
        quad_image = new JLabel();
        quad_image.setIcon(quadImage);
        quad_image.setBounds(0,0, 365, 250);
        quad_image.setVisible(false);
        
        quad_price = new JLabel("<html>₱ 6,000 / Day</html>", SwingConstants.CENTER);
        quad_capacity = new JLabel("<html>4</html>", SwingConstants.CENTER);
        quad_description = new JLabel("<html>Maximize your group's comfort in our expansive Quad rooms, offering ample space and convenience for a memorable stay.</html>", SwingConstants.CENTER);
        quad_amenities = new JLabel("<html>• Vanity Area<br>• A Safe<br>• 2 Bathrooms<br>• 32in. Television<br>• Internet<br>• Refrigerator<br>• Air Conditioned<br>• High Quality beddings</html>", SwingConstants.LEFT);
        quad_amenities2 = new JLabel("<html>• Toiletries<br>• Hairdryer<br>• Iron & Ironing Board<br>• Coffee Maker<br>• Desk<br>• Telephone<br>• Room Service</html>", SwingConstants.LEFT);
        
        quad_price.setBounds(4, 8, 100, 18);
	quad_price.setFont(new Font("Inter", Font.BOLD, 15));
        quad_price.setForeground(Color.white);
        
        quad_capacity.setBounds(280, 9, 100, 18);
	quad_capacity.setFont(new Font("Inter", Font.BOLD, 16));
        quad_capacity.setForeground(Color.white);
        
        quad_description.setBounds(25, 255, 320, 80);
	quad_description.setFont(new Font("Inter", Font.ITALIC, 15));
        quad_description.setForeground(Color.black);
        
        quad_amenities.setBounds(30, 320, 300, 200);
        quad_amenities.setFont(new Font("Inter", Font.PLAIN, 12));
        quad_amenities.setForeground(Color.black);
        
        quad_amenities2.setBounds(195, 312, 300, 200);
        quad_amenities2.setFont(new Font("Inter", Font.PLAIN, 12));
        quad_amenities2.setForeground(Color.black);
        
        quad_price.setVisible(false);
        quad_capacity.setVisible(false);
        quad_description.setVisible(false);
        quad_amenities.setVisible(false);
        quad_amenities2.setVisible(false);
        
        //Executive Suite Image, Description and Amenities
        exec_image = new JLabel();
        exec_image.setIcon(execImage);
        exec_image.setBounds(-3,-14, 385, 270);
        exec_image.setVisible(false);
        
        executive_price = new JLabel("<html>₱ 12,000 / Day</html>", SwingConstants.CENTER);
        executive_capacity = new JLabel("<html>5</html>", SwingConstants.CENTER);
        executive_description = new JLabel("<html>Indulge in refined luxury and exclusive amenities with our Executive Suite, designed for discerning travelers seeking an elevated experience.</html>", SwingConstants.CENTER);
        executive_amenities = new JLabel("<html>• Mini Bar<br>• Living Room<br>• Dining Area<br>• Air Conditioned<br>• Soundproofed Room<br>• Powder Room<br>• Refrigerator<br>• Fully Furnished Kitchen</html>", SwingConstants.LEFT);
        executive_amenities2 = new JLabel("<html>• Office Desk<br>• Oversized King Sized Bed<br>• Electronic Door Locks<br>• Housekeeping Services</html>", SwingConstants.LEFT);
        
        executive_price.setBounds(8, 8, 100, 18);
	executive_price.setFont(new Font("Inter", Font.BOLD, 15));
        executive_price.setForeground(Color.white);
        
        executive_capacity.setBounds(280, 9, 100, 18);
	executive_capacity.setFont(new Font("Inter", Font.BOLD, 16));
        executive_capacity.setForeground(Color.white);
        
        executive_description.setBounds(25, 255, 320, 80);
	executive_description.setFont(new Font("Inter", Font.ITALIC, 15));
        executive_description.setForeground(Color.black);
        
        executive_amenities.setBounds(30, 320, 300, 200);
        executive_amenities.setFont(new Font("Inter", Font.PLAIN, 12));
        executive_amenities.setForeground(Color.black);
        
        executive_amenities2.setBounds(195, 288, 300, 200);
        executive_amenities2.setFont(new Font("Inter", Font.PLAIN, 12));
        executive_amenities2.setForeground(Color.black);
        
        executive_price.setVisible(false);
        executive_capacity.setVisible(false);
        executive_description.setVisible(false);
        executive_amenities.setVisible(false);
        executive_amenities2.setVisible(false);
        
        //Presidential Suite Image, Description and Amenities
        pres_image = new JLabel();
        pres_image.setIcon(presImage);
        pres_image.setBounds(-3,-14, 385, 270);
        pres_image.setVisible(false);
        
        presidential_price = new JLabel("<html>₱ 40,000 / Day</html>", SwingConstants.CENTER);
        presidential_capacity = new JLabel("<html>9</html>", SwingConstants.CENTER);
        presidential_description = new JLabel("<html>Unwind in sheer opulence and grandeur in our Presidential Suite, where every moment is a celebration of luxury and sophistication.</html>", SwingConstants.CENTER);
        presidential_amenities = new JLabel("<html>• Housekeeping Service<br>• Laundry Service<br>• Hour Room Service<br>• Kitchenette<br>• Dining Room<br>• 3 Spacious Bedrooms<br>• Spacious Wardrobe<br>• Luggage Rack</html>", SwingConstants.LEFT);
        presidential_amenities2 = new JLabel("<html>• Executive Work Desk<br>• Fax Machine<br>• Vanity Area<br>• Full Length Mirror<br>• Two Marble Bathrooms<br>• Shower Cabin<br>• Luxury Bath Amenities<br>• 4 Flat LED TV's</html>", SwingConstants.LEFT);
        
        presidential_price.setBounds(8, 8, 100, 18);
	presidential_price.setFont(new Font("Inter", Font.BOLD, 15));
        presidential_price.setForeground(Color.white);
        
        presidential_capacity.setBounds(280, 9, 100, 18);
	presidential_capacity.setFont(new Font("Inter", Font.BOLD, 16));
        presidential_capacity.setForeground(Color.white);
        
        presidential_description.setBounds(25, 255, 320, 80);
	presidential_description.setFont(new Font("Inter", Font.ITALIC, 15));
        presidential_description.setForeground(Color.black);
        
        presidential_amenities.setBounds(30, 320, 300, 200);
        presidential_amenities.setFont(new Font("Inter", Font.PLAIN, 12));
        presidential_amenities.setForeground(Color.black);
        
        presidential_amenities2.setBounds(195, 320, 300, 200);
        presidential_amenities2.setFont(new Font("Inter", Font.PLAIN, 12));
        presidential_amenities2.setForeground(Color.black);
        
        presidential_price.setVisible(false);
        presidential_capacity.setVisible(false);
        presidential_description.setVisible(false);
        presidential_amenities.setVisible(false);
        presidential_amenities2.setVisible(false);
        
        //Main Frame
        this.setTitle("Booker");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
	this.setSize(900,600);
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
	this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //Adding Components to the Main Frame
        this.add(name_label);
        this.add(name_invalid);
        this.add(name);
        
        this.add(contactNumber_label);
        this.add(contactNumber_invalid);
        this.add(contactNumber);
        
        this.add(roomTypes_label);
        this.add(room_invalid);
        this.add(white_layer);
        this.add(room_full_single);
        this.add(room_full_double);
        this.add(room_full_triple);
        this.add(room_full_quad);
        this.add(room_full_exec);
        this.add(room_full_pres);
        this.add(roomTypes);
        
        this.add(guestNumber_label);
        this.add(guestNumber);
        
        this.add(checkIn_label);
        this.add(checkIn_invalid);
        this.add(checkIn);
        
        this.add(checkOut_label);
        this.add(checkOut_invalid);
        this.add(checkOut);
        
        this.add(MOP_label);
        this.add(cash_button);
        this.add(ewallet_button);
        this.add(bank_button);
        
	this.add(book_button);
        this.add(book_a_room);
        
        this.add(total_bill_label);
        this.add(total_bill);
        
        this.add(personIcon);
        
        this.add(single_price);
        this.add(single_capacity);
        this.add(double_price);
        this.add(double_capacity);
        this.add(triple_price);
        this.add(triple_capacity);
        this.add(quad_price);
        this.add(quad_capacity);
        this.add(executive_price);
        this.add(executive_capacity);
        this.add(presidential_price);
        this.add(presidential_capacity);
        this.add(black_layer);
        
        this.add(single_image);
        this.add(single_description);
        this.add(single_amenities);
        
        this.add(double_image);
        this.add(double_description);
        this.add(double_amenities);
        this.add(double_amenities2);
        
        this.add(triple_image);
        this.add(triple_description);
        this.add(triple_amenities);
        this.add(triple_amenities2);
        
        this.add(quad_image);
        this.add(quad_description);
        this.add(quad_amenities);
        this.add(quad_amenities2);
        
        this.add(exec_image);
        this.add(executive_description);
        this.add(executive_amenities);
        this.add(executive_amenities2);
        
        this.add(pres_image);
        this.add(presidential_description);
        this.add(presidential_amenities);
        this.add(presidential_amenities2);
        
        this.add(blue_layer);
        this.add(grey_layer);
        
        this.add(logo);
        this.add(HRS_title);
        this.add(home_image);
    }
    
    //Hide invalid message after delay
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            name_invalid.setVisible(false);
            contactNumber_invalid.setVisible(false);
            room_invalid.setVisible(false);
            white_layer.setVisible(false);
            checkIn_invalid.setVisible(false);
            checkOut_invalid.setVisible(false);
            timer.stop();
        }
    };
    
    Timer timer = new Timer(2000 ,taskPerformer);
    
    @Override
    public void actionPerformed(ActionEvent e) {
	if(e.getSource() == book_button) {
            String[] start = checkIn.getText().replace(",","").split(" ");
            String[] end = checkOut.getText().replace(",","").split(" ");
            
            //Invalid if name is empty
            if(name.getText().isEmpty()){
                name_invalid.setVisible(true);
                timer.start();
            //Invalid if number is lesser than 11
            }else if(contactNumber.getText().length() < 11){
                contactNumber_invalid.setVisible(true);
                timer.start();
            //Invalid if room type is not selected
            }else if(roomTypes.getSelectedItem() == "None"){
                room_invalid.setVisible(true);
                timer.start();
            //Invalid if single rooms are full
            }else if((roomTypes.getSelectedItem() == "Single") && singleIsFull){
                room_invalid.setVisible(true);
                white_layer.setVisible(true);
                timer.start();
            //Invalid if double rooms are full
            }else if((roomTypes.getSelectedItem() == "Double") && doubleIsFull){
                room_invalid.setVisible(true);
                white_layer.setVisible(true);
                timer.start();
            //Invalid if triple rooms are full
            }else if((roomTypes.getSelectedItem() == "Triple") && tripleIsFull){
                room_invalid.setVisible(true);
                white_layer.setVisible(true);
                timer.start();
            //Invalid if quad rooms are full
            }else if((roomTypes.getSelectedItem() == "Quad") && quadIsFull){
                room_invalid.setVisible(true);
                white_layer.setVisible(true);
                timer.start();
            //Invalid if executive rooms are full
            }else if((roomTypes.getSelectedItem() == "Executive") && executiveIsFull){
                room_invalid.setVisible(true);
                white_layer.setVisible(true);
                timer.start();
            //Invalid if presidential rooms are full
            }else if((roomTypes.getSelectedItem() == "Presidential") && presidentialIsFull){
                room_invalid.setVisible(true);
                white_layer.setVisible(true);
                timer.start();
            //Invalid if check-in date is equal to check-out
            }else if(checkIn.getText().equals(checkOut.getText())){
                checkIn_invalid.setVisible(true);
                checkOut_invalid.setVisible(true);
                timer.start();
            //Invalid if total bill is zero
            }else if(total_bill.getText().equals("₱ 0.00")){
                checkIn_invalid.setVisible(true);
                checkOut_invalid.setVisible(true);
                timer.start();
            //Show transaction details if the form is filled out properly
            }else{
                name_invalid.setVisible(false);
                contactNumber_invalid.setVisible(false);
                room_invalid.setVisible(false);
                checkIn_invalid.setVisible(false);
                checkOut_invalid.setVisible(false);
                
                //Save User Information to a single string
                getName = name.getText();
                getNumber = contactNumber.getText();
                getCheckIn = checkIn.getText().replace(",","");
                getCheckOut = checkOut.getText().replace(",","");
                getRoom = roomTypes.getSelectedItem().toString();
                getNumGuest = guestNumber.getValue().toString();
                getMOP = ModeOfPayment.getSelection().getActionCommand();
                getBill = total_bill.getText().replaceAll("\\s", "").replace("₱","").replace(",","");
                
                String userInfoString = getName + "," + getNumber + "," + getCheckIn + "," + getCheckOut + "," + getRoom + "," + getNumGuest + "," + getMOP + "," + getBill;

                //Saving User Information to CSV
                String csv = "data.csv";
                String[] UserInfo = userInfoString.split(",");
                CSVWriter writer;
                
                try {
                    writer = new CSVWriter(new FileWriter(csv, true));
                    writer.writeNext(UserInfo);
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Updating Room Availability
                if(getRoom.equals("Single")){
                    try {
                        Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                        scanner.useDelimiter("\\Z");
                        String content = scanner.next();
                        
                        String[] contentArray = content.split(",");
                        String[] room = contentArray[0].split("-");
                        
                        int addOne = Integer.parseInt(room[1]) + 1;
                        String updated = "Single-" + addOne;
                        
                        contentArray[0] = updated;
                        String finalUpdate = Arrays.toString(contentArray).replaceAll("\\s", "").replace("[","").replace("]","");
                        
                        FileWriter newWriter = new FileWriter("AvailableRooms.txt");
                        newWriter.write(finalUpdate);
                        newWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if(getRoom.equals("Double")){
                    try {
                        Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                        scanner.useDelimiter("\\Z");
                        String content = scanner.next();
                        
                        String[] contentArray = content.split(",");
                        String[] room = contentArray[1].split("-");
                        
                        int addOne = Integer.parseInt(room[1]) + 1;
                        String updated = "Double-" + addOne;
                        
                        contentArray[1] = updated;
                        String finalUpdate = Arrays.toString(contentArray).replaceAll("\\s", "").replace("[","").replace("]","");
                        
                        FileWriter newWriter = new FileWriter("AvailableRooms.txt");
                        newWriter.write(finalUpdate);
                        newWriter.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }else if(getRoom.equals("Triple")){
                    try {
                        Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                        scanner.useDelimiter("\\Z");
                        String content = scanner.next();
                        
                        String[] contentArray = content.split(",");
                        String[] room = contentArray[2].split("-");
                        
                        int addOne = Integer.parseInt(room[1]) + 1;
                        String updated = "Triple-" + addOne;
                        
                        contentArray[2] = updated;
                        String finalUpdate = Arrays.toString(contentArray).replaceAll("\\s", "").replace("[","").replace("]","");
                        
                        FileWriter newWriter = new FileWriter("AvailableRooms.txt");
                        newWriter.write(finalUpdate);
                        newWriter.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if(getRoom.equals("Quad")){
                    try {
                        Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                        scanner.useDelimiter("\\Z");
                        String content = scanner.next();
                        
                        String[] contentArray = content.split(",");
                        String[] room = contentArray[3].split("-");
                        
                        int addOne = Integer.parseInt(room[1]) + 1;
                        String updated = "Quad-" + addOne;
                        
                        contentArray[3] = updated;
                        String finalUpdate = Arrays.toString(contentArray).replaceAll("\\s", "").replace("[","").replace("]","");
                        
                        FileWriter newWriter = new FileWriter("AvailableRooms.txt");
                        newWriter.write(finalUpdate);
                        newWriter.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if(getRoom.equals("Executive")){
                    try {
                        Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                        scanner.useDelimiter("\\Z");
                        String content = scanner.next();
                        
                        String[] contentArray = content.split(",");
                        String[] room = contentArray[4].split("-");
                        
                        int addOne = Integer.parseInt(room[1]) + 1;
                        String updated = "Executive-" + addOne;
                        
                        contentArray[4] = updated;
                        String finalUpdate = Arrays.toString(contentArray).replaceAll("\\s", "").replace("[","").replace("]","");
                        
                        FileWriter newWriter = new FileWriter("AvailableRooms.txt");
                        newWriter.write(finalUpdate);
                        newWriter.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if(getRoom.equals("Presidential")){
                    try {
                        Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                        scanner.useDelimiter("\\Z");
                        String content = scanner.next();
                        
                        String[] contentArray = content.split(",");
                        String[] room = contentArray[5].split("-");
                        
                        int addOne = Integer.parseInt(room[1]) + 1;
                        String updated = "Presidential-" + addOne;
                        
                        contentArray[5] = updated;
                        String finalUpdate = Arrays.toString(contentArray).replaceAll("\\s", "").replace("[","").replace("]","");
                        
                        FileWriter newWriter = new FileWriter("AvailableRooms.txt");
                        newWriter.write(finalUpdate);
                        newWriter.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                //Pop up Transaction Details window and reset the form
                if(getMOP.equals("Cash")){
                    TransactionDetails newWindow = new TransactionDetails(getName, getNumber, getCheckIn, getCheckOut, getRoom, getNumGuest, getBill);
                }else{
                    TransactionDetails newWindow = new TransactionDetails(getName, getNumber, getCheckIn, getCheckOut, getRoom, getNumGuest, getMOP, getBill);
                }
                
                //Reset the form
                name.setText("");
                contactNumber.setText("");
                contactNumber.setEditable(true);
                checkIn.setDateToToday();
                checkOut.setDateToToday();
                roomTypes.setSelectedIndex(0);
                cash_button.setSelected(true);
            }
        }
        
        //Selecting Room Type and Displaying Details
        if(e.getSource() == roomTypes) {
            if(roomTypes.getSelectedItem() == "Single"){
                int bill = 2000;
                int final_bill = Days * bill;
            
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
            
                if(final_bill > 0){
                    total_bill.setText("₱ " + decimalFormat.format(final_bill));
                }else{
                    total_bill.setText("₱ 0.00");
                }
                
                //Read txt and check if room is not full
                try {
                    Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                        
                    String[] contentArray = content.split(",");
                    String[] room = contentArray[0].split("-");
                    
                    if(Integer.parseInt(room[1]) == 15){
                        singleIsFull = true;
                        System.out.println(singleIsFull);
                    }else{
                        singleIsFull = false;
                        
                        room_full_single.setVisible(false);
                        room_full_double.setVisible(false);
                        room_full_triple.setVisible(false);
                        room_full_quad.setVisible(false);
                        room_full_exec.setVisible(false);
                        room_full_pres.setVisible(false);
                    } 
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(singleIsFull){
                    room_full_single.setVisible(true);
                    room_full_double.setVisible(false);
                    room_full_triple.setVisible(false);
                    room_full_quad.setVisible(false);
                    room_full_exec.setVisible(false);
                    room_full_pres.setVisible(false);
                }
                
                black_layer.setVisible(true);
                blue_layer.setVisible(true);
                grey_layer.setVisible(true);
                personIcon.setVisible(true);
                
                single_price.setVisible(true);
                single_capacity.setVisible(true);
                single_image.setVisible(true);
                single_description.setVisible(true);
                single_amenities.setVisible(true);
                
                double_price.setVisible(false);
                double_capacity.setVisible(false);
                double_image.setVisible(false);
                double_description.setVisible(false);
                double_amenities.setVisible(false);
                double_amenities2.setVisible(false);
                
                triple_price.setVisible(false);
                triple_capacity.setVisible(false);
                triple_image.setVisible(false);
                triple_description.setVisible(false);
                triple_amenities.setVisible(false);
                triple_amenities2.setVisible(false);
                
                quad_price.setVisible(false);
                quad_capacity.setVisible(false);
                quad_image.setVisible(false);
                quad_description.setVisible(false);
                quad_amenities.setVisible(false);
                quad_amenities2.setVisible(false);
                
                executive_price.setVisible(false);
                executive_capacity.setVisible(false);
                exec_image.setVisible(false);
                executive_description.setVisible(false);
                executive_amenities.setVisible(false);
                executive_amenities2.setVisible(false);
                
                presidential_price.setVisible(false);
                presidential_capacity.setVisible(false);
                pres_image.setVisible(false);
                presidential_description.setVisible(false);
                presidential_amenities.setVisible(false);
                presidential_amenities2.setVisible(false);
                
                guestNumber.setEnabled(true);
                model.setValue(1);
                model.setMaximum(1);
                model.setMinimum(1);
                
                total_bill_label.setVisible(true);
                total_bill.setVisible(true);
                
            }else if(roomTypes.getSelectedItem() == "Double"){
                int bill = 3500;
                int final_bill = Days * bill;
            
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
            
                if(final_bill > 0){
                    total_bill.setText("₱ " + decimalFormat.format(final_bill));
                }else{
                    total_bill.setText("₱ 0.00");
                }
                
                //Read txt and check if room is not full
                try {
                    Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                        
                    String[] contentArray = content.split(",");
                    String[] room = contentArray[1].split("-");
                    
                    if(Integer.parseInt(room[1]) == 10){
                        doubleIsFull = true;
                    }else{
                        doubleIsFull = false;
                        
                        room_full_single.setVisible(false);
                        room_full_double.setVisible(false);
                        room_full_triple.setVisible(false);
                        room_full_quad.setVisible(false);
                        room_full_exec.setVisible(false);
                        room_full_pres.setVisible(false);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(doubleIsFull){
                    room_full_single.setVisible(false);
                    room_full_double.setVisible(true);
                    room_full_triple.setVisible(false);
                    room_full_quad.setVisible(false);
                    room_full_exec.setVisible(false);
                    room_full_pres.setVisible(false);
                }
                
                black_layer.setVisible(true);
                blue_layer.setVisible(true);
                grey_layer.setVisible(true);
                personIcon.setVisible(true);
                
                single_price.setVisible(false);
                single_capacity.setVisible(false);
                single_image.setVisible(false);
                single_description.setVisible(false);
                single_amenities.setVisible(false);
                
                double_price.setVisible(true);
                double_capacity.setVisible(true);
                double_image.setVisible(true);
                double_description.setVisible(true);
                double_amenities.setVisible(true);
                double_amenities2.setVisible(true);
                
                triple_price.setVisible(false);
                triple_capacity.setVisible(false);
                triple_image.setVisible(false);
                triple_description.setVisible(false);
                triple_amenities.setVisible(false);
                triple_amenities2.setVisible(false);
                
                quad_price.setVisible(false);
                quad_capacity.setVisible(false);
                quad_image.setVisible(false);
                quad_description.setVisible(false);
                quad_amenities.setVisible(false);
                quad_amenities2.setVisible(false);
                
                executive_price.setVisible(false);
                executive_capacity.setVisible(false);
                exec_image.setVisible(false);
                executive_description.setVisible(false);
                executive_amenities.setVisible(false);
                executive_amenities2.setVisible(false);
                
                presidential_price.setVisible(false);
                presidential_capacity.setVisible(false);
                pres_image.setVisible(false);
                presidential_description.setVisible(false);
                presidential_amenities.setVisible(false);
                presidential_amenities2.setVisible(false);
                
                guestNumber.setEnabled(true);
                model.setValue(2);
                model.setMaximum(2);
                model.setMinimum(1);
                
                total_bill_label.setVisible(true);
                total_bill.setVisible(true);
                
            }else if(roomTypes.getSelectedItem() == "Triple"){
                int bill = 5000;
                int final_bill = Days * bill;
            
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
            
                if(final_bill > 0){
                    total_bill.setText("₱ " + decimalFormat.format(final_bill));
                }else{
                    total_bill.setText("₱ 0.00");
                }
                
                //Read txt and check if room is not full
                try {
                    Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                        
                    String[] contentArray = content.split(",");
                    String[] room = contentArray[2].split("-");
                    
                    if(Integer.parseInt(room[1]) == 5){
                        tripleIsFull = true;
                    }else{
                        tripleIsFull = false;
                        
                        room_full_single.setVisible(false);
                        room_full_double.setVisible(false);
                        room_full_triple.setVisible(false);
                        room_full_quad.setVisible(false);
                        room_full_exec.setVisible(false);
                        room_full_pres.setVisible(false);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(tripleIsFull){
                    room_full_single.setVisible(false);
                    room_full_double.setVisible(false);
                    room_full_triple.setVisible(true);
                    room_full_quad.setVisible(false);
                    room_full_exec.setVisible(false);
                    room_full_pres.setVisible(false);
                }
                
                black_layer.setVisible(true);
                blue_layer.setVisible(true);
                grey_layer.setVisible(true);
                personIcon.setVisible(true);
                
                single_price.setVisible(false);
                single_capacity.setVisible(false);
                single_image.setVisible(false);
                single_description.setVisible(false);
                single_amenities.setVisible(false);
                
                double_price.setVisible(false);
                double_capacity.setVisible(false);
                double_image.setVisible(false);
                double_description.setVisible(false);
                double_amenities.setVisible(false);
                double_amenities2.setVisible(false);
                
                triple_price.setVisible(true);
                triple_capacity.setVisible(true);
                triple_image.setVisible(true);
                triple_description.setVisible(true);
                triple_amenities.setVisible(true);
                triple_amenities2.setVisible(true);
                
                quad_price.setVisible(false);
                quad_capacity.setVisible(false);
                quad_image.setVisible(false);
                quad_description.setVisible(false);
                quad_amenities.setVisible(false);
                quad_amenities2.setVisible(false);
                
                executive_price.setVisible(false);
                executive_capacity.setVisible(false);
                exec_image.setVisible(false);
                executive_description.setVisible(false);
                executive_amenities.setVisible(false);
                executive_amenities2.setVisible(false);
                
                presidential_price.setVisible(false);
                presidential_capacity.setVisible(false);
                pres_image.setVisible(false);
                presidential_description.setVisible(false);
                presidential_amenities.setVisible(false);
                presidential_amenities2.setVisible(false);
                
                guestNumber.setEnabled(true);
                model.setValue(3);
                model.setMaximum(3);
                model.setMinimum(1);
                
                total_bill_label.setVisible(true);
                total_bill.setVisible(true);
                
            }else if(roomTypes.getSelectedItem() == "Quad"){
                int bill = 6000;
                int final_bill = Days * bill;
            
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
            
                if(final_bill > 0){
                    total_bill.setText("₱ " + decimalFormat.format(final_bill));
                }else{
                    total_bill.setText("₱ 0.00");
                }
                
                //Read txt and check if room is not full
                try {
                    Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                        
                    String[] contentArray = content.split(",");
                    String[] room = contentArray[3].split("-");
                    
                    if(Integer.parseInt(room[1]) == 5){
                        quadIsFull = true;
                    }else{
                        quadIsFull = false;
                        
                        room_full_single.setVisible(false);
                        room_full_double.setVisible(false);
                        room_full_triple.setVisible(false);
                        room_full_quad.setVisible(false);
                        room_full_exec.setVisible(false);
                        room_full_pres.setVisible(false);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(quadIsFull){
                    room_full_single.setVisible(false);
                    room_full_double.setVisible(false);
                    room_full_triple.setVisible(false);
                    room_full_quad.setVisible(true);
                    room_full_exec.setVisible(false);
                    room_full_pres.setVisible(false);
                }
                
                black_layer.setVisible(true);
                blue_layer.setVisible(true);
                grey_layer.setVisible(true);
                personIcon.setVisible(true);
                
                single_price.setVisible(false);
                single_capacity.setVisible(false);
                single_image.setVisible(false);
                single_description.setVisible(false);
                single_amenities.setVisible(false);
                
                double_price.setVisible(false);
                double_capacity.setVisible(false);
                double_image.setVisible(false);
                double_description.setVisible(false);
                double_amenities.setVisible(false);
                double_amenities2.setVisible(false);
                
                triple_price.setVisible(false);
                triple_capacity.setVisible(false);
                triple_image.setVisible(false);
                triple_description.setVisible(false);
                triple_amenities.setVisible(false);
                triple_amenities2.setVisible(false);
                
                quad_price.setVisible(true);
                quad_capacity.setVisible(true);
                quad_image.setVisible(true);
                quad_description.setVisible(true);
                quad_amenities.setVisible(true);
                quad_amenities2.setVisible(true);
                
                executive_price.setVisible(false);
                executive_capacity.setVisible(false);
                exec_image.setVisible(false);
                executive_description.setVisible(false);
                executive_amenities.setVisible(false);
                executive_amenities2.setVisible(false);
                
                presidential_price.setVisible(false);
                presidential_capacity.setVisible(false);
                pres_image.setVisible(false);
                presidential_description.setVisible(false);
                presidential_amenities.setVisible(false);
                presidential_amenities2.setVisible(false);
                
                guestNumber.setEnabled(true);
                model.setValue(4);
                model.setMaximum(4);
                model.setMinimum(1);
                
                total_bill_label.setVisible(true);
                total_bill.setVisible(true);
                
            }else if(roomTypes.getSelectedItem() == "Executive"){
                int bill = 12000;
                int final_bill = Days * bill;
            
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
            
                if(final_bill > 0){
                    total_bill.setText("₱ " + decimalFormat.format(final_bill));
                }else{
                    total_bill.setText("₱ 0.00");
                }
                
                //Read txt and check if room is not full
                try {
                    Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                        
                    String[] contentArray = content.split(",");
                    String[] room = contentArray[4].split("-");
                    
                    if(Integer.parseInt(room[1]) == 3){
                        executiveIsFull = true;
                    }else{
                        executiveIsFull = false;
                        
                        room_full_single.setVisible(false);
                        room_full_double.setVisible(false);
                        room_full_triple.setVisible(false);
                        room_full_quad.setVisible(false);
                        room_full_exec.setVisible(false);
                        room_full_pres.setVisible(false);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(executiveIsFull){
                    room_full_single.setVisible(false);
                    room_full_double.setVisible(false);
                    room_full_triple.setVisible(false);
                    room_full_quad.setVisible(false);
                    room_full_exec.setVisible(true);
                    room_full_pres.setVisible(false);
                }
                
                black_layer.setVisible(true);
                blue_layer.setVisible(true);
                grey_layer.setVisible(true);
                personIcon.setVisible(true);
                
                single_price.setVisible(false);
                single_capacity.setVisible(false);
                single_image.setVisible(false);
                single_description.setVisible(false);
                single_amenities.setVisible(false);
                
                double_price.setVisible(false);
                double_capacity.setVisible(false);
                double_image.setVisible(false);
                double_description.setVisible(false);
                double_amenities.setVisible(false);
                double_amenities2.setVisible(false);
                
                triple_price.setVisible(false);
                triple_capacity.setVisible(false);
                triple_image.setVisible(false);
                triple_description.setVisible(false);
                triple_amenities.setVisible(false);
                triple_amenities2.setVisible(false);
                
                quad_price.setVisible(false);
                quad_capacity.setVisible(false);
                quad_image.setVisible(false);
                quad_description.setVisible(false);
                quad_amenities.setVisible(false);
                quad_amenities2.setVisible(false);
                
                executive_price.setVisible(true);
                executive_capacity.setVisible(true);
                exec_image.setVisible(true);
                executive_description.setVisible(true);
                executive_amenities.setVisible(true);
                executive_amenities2.setVisible(true);
                
                presidential_price.setVisible(false);
                presidential_capacity.setVisible(false);
                pres_image.setVisible(false);
                presidential_description.setVisible(false);
                presidential_amenities.setVisible(false);
                presidential_amenities2.setVisible(false);
                
                guestNumber.setEnabled(true);
                model.setValue(5);
                model.setMaximum(5);
                model.setMinimum(1);
                
                total_bill_label.setVisible(true);
                total_bill.setVisible(true);
                
            }else if(roomTypes.getSelectedItem() == "Presidential"){
                int bill = 40000;
                int final_bill = Days * bill;
            
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
            
                if(final_bill > 0){
                    total_bill.setText("₱ " + decimalFormat.format(final_bill));
                }else{
                    total_bill.setText("₱ 0.00");
                }
                
                //Read txt and check if room is not full
                try {
                    Scanner scanner = new Scanner(Paths.get("AvailableRooms.txt"));
                    scanner.useDelimiter("\\Z");
                    String content = scanner.next();
                        
                    String[] contentArray = content.split(",");
                    String[] room = contentArray[5].split("-");
                    
                    if(Integer.parseInt(room[1]) == 2){
                        presidentialIsFull = true;
                    }else{
                        presidentialIsFull = false;
                        
                        room_full_single.setVisible(false);
                        room_full_double.setVisible(false);
                        room_full_triple.setVisible(false);
                        room_full_quad.setVisible(false);
                        room_full_exec.setVisible(false);
                        room_full_pres.setVisible(false);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(presidentialIsFull){
                    room_full_single.setVisible(false);
                    room_full_double.setVisible(false);
                    room_full_triple.setVisible(false);
                    room_full_quad.setVisible(false);
                    room_full_exec.setVisible(false);
                    room_full_pres.setVisible(true);
                }
                
                black_layer.setVisible(true);
                blue_layer.setVisible(true);
                grey_layer.setVisible(true);
                personIcon.setVisible(true);
                
                single_price.setVisible(false);
                single_capacity.setVisible(false);
                single_image.setVisible(false);
                single_description.setVisible(false);
                single_amenities.setVisible(false);
                
                double_price.setVisible(false);
                double_capacity.setVisible(false);
                double_image.setVisible(false);
                double_description.setVisible(false);
                double_amenities.setVisible(false);
                double_amenities2.setVisible(false);
                
                triple_price.setVisible(false);
                triple_capacity.setVisible(false);
                triple_image.setVisible(false);
                triple_description.setVisible(false);
                triple_amenities.setVisible(false);
                triple_amenities2.setVisible(false);
                
                quad_price.setVisible(false);
                quad_capacity.setVisible(false);
                quad_image.setVisible(false);
                quad_description.setVisible(false);
                quad_amenities.setVisible(false);
                quad_amenities2.setVisible(false);
                
                executive_price.setVisible(false);
                executive_capacity.setVisible(false);
                exec_image.setVisible(false);
                executive_description.setVisible(false);
                executive_amenities.setVisible(false);
                executive_amenities2.setVisible(false);
                
                presidential_price.setVisible(true);
                presidential_capacity.setVisible(true);
                pres_image.setVisible(true);
                presidential_description.setVisible(true);
                presidential_amenities.setVisible(true);
                presidential_amenities2.setVisible(true);
                
                guestNumber.setEnabled(true);
                model.setValue(9);
                model.setMaximum(9);
                model.setMinimum(1);
                
                total_bill_label.setVisible(true);
                total_bill.setVisible(true);
                
            }else if(roomTypes.getSelectedItem() == "None"){
                
                room_full_single.setVisible(false);
                room_full_double.setVisible(false);
                room_full_triple.setVisible(false);
                room_full_quad.setVisible(false);
                room_full_exec.setVisible(false);
                room_full_pres.setVisible(false);
                
                black_layer.setVisible(false);
                blue_layer.setVisible(false);
                grey_layer.setVisible(false);
                personIcon.setVisible(false);
                
                single_price.setVisible(false);
                single_capacity.setVisible(false);
                single_image.setVisible(false);
                single_description.setVisible(false);
                single_amenities.setVisible(false);
                
                double_price.setVisible(false);
                double_capacity.setVisible(false);
                double_image.setVisible(false);
                double_description.setVisible(false);
                double_amenities.setVisible(false);
                double_amenities2.setVisible(false);
                
                triple_price.setVisible(false);
                triple_capacity.setVisible(false);
                triple_image.setVisible(false);
                triple_description.setVisible(false);
                triple_amenities.setVisible(false);
                triple_amenities2.setVisible(false);
                
                quad_price.setVisible(false);
                quad_capacity.setVisible(false);
                quad_image.setVisible(false);
                quad_description.setVisible(false);
                quad_amenities.setVisible(false);
                quad_amenities2.setVisible(false);
                
                executive_price.setVisible(false);
                executive_capacity.setVisible(false);
                exec_image.setVisible(false);
                executive_description.setVisible(false);
                executive_amenities.setVisible(false);
                executive_amenities2.setVisible(false);
                
                presidential_price.setVisible(false);
                presidential_capacity.setVisible(false);
                pres_image.setVisible(false);
                presidential_description.setVisible(false);
                presidential_amenities.setVisible(false);
                presidential_amenities2.setVisible(false);
                
                guestNumber.setEnabled(false);
                model.setValue(0);
                
                total_bill_label.setVisible(false);
                total_bill.setVisible(false);
            }
        }
    }
    
    //Calculating Total Bill
    @Override
    public void dateChanged(DateChangeEvent dce) {
        //Get the starting, ending and current date
        String[] start = checkIn.getText().replace(",","").split(" ");
        String[] end = checkOut.getText().replace(",","").split(" ");
        
        //Get the Month in Integer form (Start)
        if(start[0].equals("January")){
            startMonth = 1;
        }else if(start[0].equals("February")){
            startMonth = 2;
        }else if(start[0].equals("March")){
            startMonth = 3;
        }else if(start[0].equals("April")){
            startMonth = 4;
        }else if(start[0].equals("May")){
            startMonth = 5;
        }else if(start[0].equals("June")){
            startMonth = 6;
        }else if(start[0].equals("July")){
            startMonth = 7;
        }else if(start[0].equals("August")){
            startMonth = 8;
        }else if(start[0].equals("September")){
            startMonth = 9;
        }else if(start[0].equals("October")){
            startMonth = 10;
        }else if(start[0].equals("November")){
            startMonth = 11;
        }else if(start[0].equals("December")){
            startMonth = 12;
        }
        
        //Get the Month in Integer form (End)
        if(end[0].equals("January")){
            endMonth = 1;
        }else if(end[0].equals("February")){
            endMonth = 2;
        }else if(end[0].equals("March")){
            endMonth = 3;
        }else if(end[0].equals("April")){
            endMonth = 4;
        }else if(end[0].equals("May")){
            endMonth = 5;
        }else if(end[0].equals("June")){
            endMonth = 6;
        }else if(end[0].equals("July")){
            endMonth = 7;
        }else if(end[0].equals("August")){
            endMonth = 8;
        }else if(end[0].equals("September")){
            endMonth = 9;
        }else if(end[0].equals("October")){
            endMonth = 10;
        }else if(end[0].equals("November")){
            endMonth = 11;
        }else if(end[0].equals("December")){
            endMonth = 12;
        }
       
        //Get the day of the year of the check-in and check-out dates and subtract them.
        LocalDate today = LocalDate.now();
        
        LocalDate startDate = LocalDate.of(today.getYear(),startMonth,Integer.parseInt(start[1]));
        int startDay = startDate.getDayOfYear();
        
        LocalDate endDate = LocalDate.of(today.getYear(),endMonth,Integer.parseInt(end[1]));
        int endDay = endDate.getDayOfYear();

        Days = endDay - startDay;
        
        //To display the correct amount per room type
        if(roomTypes.getSelectedItem() == "Single"){
            int bill = 2000;
            int final_bill = Days * bill;
            
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            
            //If bill is negative
            if(final_bill > 0){
                total_bill.setText("₱ " + decimalFormat.format(final_bill));
            }else{
                total_bill.setText("₱ 0.00");
            }
        }else if(roomTypes.getSelectedItem() == "Double"){
            int bill = 3500;
            int final_bill = Days * bill;
            
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            
            //If bill is negative
            if(final_bill > 0){
                total_bill.setText("₱ " + decimalFormat.format(final_bill));
            }else{
                total_bill.setText("₱ 0.00");
            }
        }else if(roomTypes.getSelectedItem() == "Triple"){
            int bill = 5000;
            int final_bill = Days * bill;
            
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            
            //If bill is negative
            if(final_bill > 0){
                total_bill.setText("₱ " + decimalFormat.format(final_bill));
            }else{
                total_bill.setText("₱ 0.00");
            }
        }else if(roomTypes.getSelectedItem() == "Quad"){
            int bill = 6000;
            int final_bill = Days * bill;
            
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            
            //If bill is negative
            if(final_bill > 0){
                total_bill.setText("₱ " + decimalFormat.format(final_bill));
            }else{
                total_bill.setText("₱ 0.00");
            }
        }else if(roomTypes.getSelectedItem() == "Executive"){
            int bill = 12000;
            int final_bill = Days * bill;
            
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            
            //If bill is negative
            if(final_bill > 0){
                total_bill.setText("₱ " + decimalFormat.format(final_bill));
            }else{
                total_bill.setText("₱ 0.00");
            }
        }else if(roomTypes.getSelectedItem() == "Presidential"){
            int bill = 40000;
            int final_bill = Days * bill;
            
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            
            //If bill is negative
            if(final_bill > 0){
                total_bill.setText("₱ " + decimalFormat.format(final_bill));
            }else{
                total_bill.setText("₱ 0.00");
            }
        }else if(roomTypes.getSelectedItem() == "None"){
            total_bill.setText("₱ 0.00");
        }
    }
}

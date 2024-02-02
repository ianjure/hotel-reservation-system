package hotelreservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.*;

public class TransactionDetails{
    
    JFrame frame = new JFrame();
    JLabel transactionDetails;
    JPanel liner;
    JPanel blue_background;
    
    JLabel name_label;
    JLabel contact_label;
    JLabel room_label;
    JLabel guest_label;
    JLabel in_label;
    JLabel out_label;
    JLabel bill_label;
    
    JLabel name_info;
    JLabel contact_info;
    JLabel room_info;
    JLabel guest_info;
    JLabel in_info;
    JLabel out_info;
    JLabel bill_info;
    
    JLabel background_img;
    JLabel gcash_img;
    JLabel bank_img;
    
    TransactionDetails(String name, String contactNumber, String checkIn, String checkOut, String roomType, String guests, String bill){
        
        //Transaction Details Text
        transactionDetails = new JLabel("TRANSACTION DETAILS", SwingConstants.CENTER);
        transactionDetails.setBounds(45,30,250,17);
        transactionDetails.setFont(new Font("Inter", Font.BOLD, 17));
        transactionDetails.setForeground(Color.black);
        
        //Line Separator
        liner = new JPanel();
        liner.setBounds(20,60,292,1);
        liner.setBackground(new Color(0,0,0,60));
        liner.setVisible(true);
        
        //Name Label
        name_label = new JLabel();
        name_label.setText("Name:");
        name_label.setBounds(20,90,200,17);
        name_label.setFont(new Font("Inter", Font.BOLD, 17));
        name_label.setForeground(Color.black);
        
        //Contact Number Label
        contact_label = new JLabel();
        contact_label.setText("Contact No.:");
        contact_label.setBounds(20,115,200,17);
        contact_label.setFont(new Font("Inter", Font.BOLD, 17));
        contact_label.setForeground(Color.black);
        
        //Room Type Label
        room_label = new JLabel();
        room_label.setText("Room:");
        room_label.setBounds(20,140,200,17);
        room_label.setFont(new Font("Inter", Font.BOLD, 17));
        room_label.setForeground(Color.black);
        
        //Guests Label
        guest_label = new JLabel();
        guest_label.setText("No. of Guests:");
        guest_label.setBounds(20,165,200,17);
        guest_label.setFont(new Font("Inter", Font.BOLD, 17));
        guest_label.setForeground(Color.black);
        
        //Check In Label
        in_label = new JLabel();
        in_label.setText("Check In:");
        in_label.setBounds(20,190,200,17);
        in_label.setFont(new Font("Inter", Font.BOLD, 17));
        in_label.setForeground(Color.black);
        
        //Check Out Label
        out_label = new JLabel();
        out_label.setText("Check Out:");
        out_label.setBounds(20,215,200,17);
        out_label.setFont(new Font("Inter", Font.BOLD, 17));
        out_label.setForeground(Color.black);
        
        //Total Bill Label
        bill_label = new JLabel();
        bill_label.setText("Total Bill:");
        bill_label.setBounds(20,270,200,20);
        bill_label.setFont(new Font("Inter", Font.BOLD, 20));
        bill_label.setForeground(Color.black);
	
        //Main Frame
        ImageIcon icon = new ImageIcon("Icon.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLayout(null);
	frame.setSize(350,350);
        frame.getContentPane().setBackground(new Color(244,248,255));
        frame.setResizable(false);
	frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Booked Successfully!");
        
        //User Information
        name_info = new JLabel();
        name_info.setBounds(62,90,250,20);
        name_info.setText(name);
        name_info.setHorizontalAlignment(SwingConstants.RIGHT);
        name_info.setFont(new Font("Inter", Font.PLAIN, 17));
        name_info.setForeground(Color.black);
        name_info.setVisible(true);
        
        contact_info = new JLabel();
        contact_info.setBounds(62,115,250,20);
        contact_info.setText(contactNumber);
        contact_info.setHorizontalAlignment(SwingConstants.RIGHT);
        contact_info.setFont(new Font("Inter", Font.PLAIN, 17));
        contact_info.setForeground(Color.black);
        contact_info.setVisible(true);
        
        room_info = new JLabel();
        room_info.setBounds(62,140,250,20);
        room_info.setText(roomType);
        room_info.setHorizontalAlignment(SwingConstants.RIGHT);
        room_info.setFont(new Font("Inter", Font.PLAIN, 17));
        room_info.setForeground(Color.black);
        room_info.setVisible(true);
        
        guest_info = new JLabel();
        guest_info.setBounds(62,165,250,20);
        guest_info.setText(guests);
        guest_info.setHorizontalAlignment(SwingConstants.RIGHT);
        guest_info.setFont(new Font("Inter", Font.PLAIN, 17));
        guest_info.setForeground(Color.black);
        guest_info.setVisible(true);
        
        in_info = new JLabel();
        in_info.setBounds(62,190,250,20);
        in_info.setText(checkIn);
        in_info.setHorizontalAlignment(SwingConstants.RIGHT);
        in_info.setFont(new Font("Inter", Font.PLAIN, 17));
        in_info.setForeground(Color.black);
        in_info.setVisible(true);
        
        out_info = new JLabel();
        out_info.setBounds(62,215,250,20);
        out_info.setText(checkOut);
        out_info.setHorizontalAlignment(SwingConstants.RIGHT);
        out_info.setFont(new Font("Inter", Font.PLAIN, 17));
        out_info.setForeground(Color.black);
        out_info.setVisible(true);
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        
        bill_info = new JLabel();
        bill_info.setBounds(62,270,250,20);
        bill_info.setText("₱ " + decimalFormat.format(Integer.parseInt(bill)));
        bill_info.setHorizontalAlignment(SwingConstants.RIGHT);
        bill_info.setFont(new Font("Inter", Font.PLAIN, 20));
        bill_info.setForeground(Color.black);
        bill_info.setVisible(true);
        
        //Background Image
        ImageIcon background = new ImageIcon("Background.png");
        background_img = new JLabel();
        background_img.setIcon(background);
        background_img.setBounds(17,5,300,300);
        background_img.setVisible(true);
        
        //Adding Components To Main Frame
        frame.add(transactionDetails);
        frame.add(liner);
        frame.add(name_label);
        frame.add(contact_label);
        frame.add(room_label);
        frame.add(guest_label);
        frame.add(in_label);
        frame.add(out_label);
        frame.add(bill_label);
        
        frame.add(name_info);
        frame.add(contact_info);
        frame.add(room_info);
        frame.add(guest_info);
        frame.add(in_info);
        frame.add(out_info);
        frame.add(bill_info);
        
        frame.add(background_img);
        
    }
    
    TransactionDetails(String name, String contactNumber, String checkIn, String checkOut, String roomType, String guests, String MOP, String bill){
        
        //Transaction Details Text
        transactionDetails = new JLabel("TRANSACTION DETAILS", SwingConstants.CENTER);
        transactionDetails.setBounds(45,30,250,17);
        transactionDetails.setFont(new Font("Inter", Font.BOLD, 17));
        transactionDetails.setForeground(Color.black);
        
        //Line Separator
        liner = new JPanel();
        liner.setBounds(20,60,292,1);
        liner.setBackground(new Color(0,0,0,60));
        liner.setVisible(true);
        
        //Name Label
        name_label = new JLabel();
        name_label.setText("Name:");
        name_label.setBounds(20,90,200,17);
        name_label.setFont(new Font("Inter", Font.BOLD, 17));
        name_label.setForeground(Color.black);
        
        //Contact Number Label
        contact_label = new JLabel();
        contact_label.setText("Contact No.:");
        contact_label.setBounds(20,115,200,17);
        contact_label.setFont(new Font("Inter", Font.BOLD, 17));
        contact_label.setForeground(Color.black);
        
        //Room Type Label
        room_label = new JLabel();
        room_label.setText("Room:");
        room_label.setBounds(20,140,200,17);
        room_label.setFont(new Font("Inter", Font.BOLD, 17));
        room_label.setForeground(Color.black);
        
        //Guests Label
        guest_label = new JLabel();
        guest_label.setText("No. of Guests:");
        guest_label.setBounds(20,165,200,17);
        guest_label.setFont(new Font("Inter", Font.BOLD, 17));
        guest_label.setForeground(Color.black);
        
        //Check In Label
        in_label = new JLabel();
        in_label.setText("Check In:");
        in_label.setBounds(20,190,200,17);
        in_label.setFont(new Font("Inter", Font.BOLD, 17));
        in_label.setForeground(Color.black);
        
        //Check Out Label
        out_label = new JLabel();
        out_label.setText("Check Out:");
        out_label.setBounds(20,215,200,17);
        out_label.setFont(new Font("Inter", Font.BOLD, 17));
        out_label.setForeground(Color.black);
        
        //Total Bill Label
        bill_label = new JLabel();
        bill_label.setText("Total Bill:");
        bill_label.setBounds(20,270,200,20);
        bill_label.setFont(new Font("Inter", Font.BOLD, 20));
        bill_label.setForeground(Color.black);
	
        //Main Frame
        ImageIcon icon = new ImageIcon("Icon.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLayout(null);
	frame.setSize(700,350);
        frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);
	frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Booked Successfully!");
        
        //User Information
        name_info = new JLabel();
        name_info.setBounds(62,90,250,20);
        name_info.setText(name);
        name_info.setHorizontalAlignment(SwingConstants.RIGHT);
        name_info.setFont(new Font("Inter", Font.PLAIN, 17));
        name_info.setForeground(Color.black);
        name_info.setVisible(true);
        
        contact_info = new JLabel();
        contact_info.setBounds(62,115,250,20);
        contact_info.setText(contactNumber);
        contact_info.setHorizontalAlignment(SwingConstants.RIGHT);
        contact_info.setFont(new Font("Inter", Font.PLAIN, 17));
        contact_info.setForeground(Color.black);
        contact_info.setVisible(true);
        
        room_info = new JLabel();
        room_info.setBounds(62,140,250,20);
        room_info.setText(roomType);
        room_info.setHorizontalAlignment(SwingConstants.RIGHT);
        room_info.setFont(new Font("Inter", Font.PLAIN, 17));
        room_info.setForeground(Color.black);
        room_info.setVisible(true);
        
        guest_info = new JLabel();
        guest_info.setBounds(62,165,250,20);
        guest_info.setText(guests);
        guest_info.setHorizontalAlignment(SwingConstants.RIGHT);
        guest_info.setFont(new Font("Inter", Font.PLAIN, 17));
        guest_info.setForeground(Color.black);
        guest_info.setVisible(true);
        
        in_info = new JLabel();
        in_info.setBounds(62,190,250,20);
        in_info.setText(checkIn);
        in_info.setHorizontalAlignment(SwingConstants.RIGHT);
        in_info.setFont(new Font("Inter", Font.PLAIN, 17));
        in_info.setForeground(Color.black);
        in_info.setVisible(true);
        
        out_info = new JLabel();
        out_info.setBounds(62,215,250,20);
        out_info.setText(checkOut);
        out_info.setHorizontalAlignment(SwingConstants.RIGHT);
        out_info.setFont(new Font("Inter", Font.PLAIN, 17));
        out_info.setForeground(Color.black);
        out_info.setVisible(true);
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        
        bill_info = new JLabel();
        bill_info.setBounds(62,270,250,20);
        bill_info.setText("₱ " + decimalFormat.format(Integer.parseInt(bill)));
        bill_info.setHorizontalAlignment(SwingConstants.RIGHT);
        bill_info.setFont(new Font("Inter", Font.PLAIN, 20));
        bill_info.setForeground(Color.black);
        bill_info.setVisible(true);
        
        //Background Image
        ImageIcon background = new ImageIcon("Background.png");
        background_img = new JLabel();
        background_img.setIcon(background);
        background_img.setBounds(17,5,300,300);
        background_img.setVisible(true);
        
        //Blue Background
        blue_background = new JPanel();
        blue_background.setBounds(0,0,335,350);
        blue_background.setBackground(new Color(244,248,255));
        blue_background.setVisible(true);
        
        //Gcash Image
        ImageIcon gcash = new ImageIcon("Gcash.jpg");
        gcash_img = new JLabel();
        gcash_img.setIcon(gcash);
        gcash_img.setBounds(361,-18,350,350);
        gcash_img.setVisible(false);
        
        //Bank Image
        ImageIcon bank = new ImageIcon("Bank.jpg");
        bank_img = new JLabel();
        bank_img.setIcon(bank);
        bank_img.setBounds(361,-25,350,350);
        bank_img.setVisible(false);
        
        if(MOP.equals("Bank")){
            bank_img.setVisible(true);
        }else{
            gcash_img.setVisible(true);
        }
        
        //Adding Components To Main Frame
        frame.add(transactionDetails);
        frame.add(liner);
        frame.add(name_label);
        frame.add(contact_label);
        frame.add(room_label);
        frame.add(guest_label);
        frame.add(in_label);
        frame.add(out_label);
        frame.add(bill_label);
        
        frame.add(name_info);
        frame.add(contact_info);
        frame.add(room_info);
        frame.add(guest_info);
        frame.add(in_info);
        frame.add(out_info);
        frame.add(bill_info);
        
        frame.add(bank_img);
        frame.add(gcash_img);
        frame.add(background_img);
        frame.add(blue_background);
    }
}

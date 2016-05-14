package sm130075.vl130298.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import sm130075.vl130298.exception.StartFrameException;
import sm130075.vl130298.types.KeyStorage;
import sm130075.vl130298.types.UnsignedCert;
import sm130075.vl130298.util.Generator;
import sun.security.util.Debug;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.BasicConstraintsExtension;
import sun.security.x509.GeneralName;
import sun.security.x509.GeneralNames;
import sun.security.x509.IssuerAlternativeNameExtension;
import sun.security.x509.KeyUsageExtension;
import sun.security.x509.X500Name;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import java.awt.ScrollPane;

public class StartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField keySize_textField;
	private JTextField Version_textField;
	private JTextField SerialNumber_textField;
	private JTextField StartDate_textField;
	private JTextField PrivateKey_textField;
	private JTextField PublicKey_textField;
	private JTextField CN_textField;
	private JTextField OU_textField;
	private JTextField O_textField;
	private JTextField L_textField;
	private JTextField ST_textField;
	private JTextField C_textField;
	private JTextField E_textField;
	private JTextField EndDate_textField;
	private JTextField Depth_textField;

	/**
	 * Launch the application.
	 */

	KeyStorage ks = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartFrame() {

		/* My class */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKeySize = new JLabel("Key size:");
		lblKeySize.setBounds(10, 27, 46, 14);
		contentPane.add(lblKeySize);

		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(10, 52, 46, 14);
		contentPane.add(lblVersion);

		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setBounds(10, 77, 66, 14);
		contentPane.add(lblSerialNumber);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(10, 102, 66, 14);
		contentPane.add(lblStartDate);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(10, 127, 46, 14);
		contentPane.add(lblEndDate);

		JLabel lblPrivateKey = new JLabel("Private key");
		lblPrivateKey.setBounds(10, 402, 66, 14);
		contentPane.add(lblPrivateKey);

		JLabel lblPublicKey = new JLabel("Public key");
		lblPublicKey.setBounds(10, 365, 66, 14);
		contentPane.add(lblPublicKey);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 167, 198, 153);
		contentPane.add(calendar);

		JLabel lblBasicE = new JLabel("Basic Constraints Extension ");
		lblBasicE.setEnabled(false);
		lblBasicE.setBounds(400, 27, 141, 14);
		contentPane.add(lblBasicE);

		keySize_textField = new JTextField();
		keySize_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});
		keySize_textField.setColumns(10);
		keySize_textField.setBounds(86, 24, 86, 20);
		contentPane.add(keySize_textField);

		Version_textField = new JTextField();
		Version_textField.setEditable(false);
		Version_textField.setText("V3");
		Version_textField.setBounds(86, 49, 86, 20);
		contentPane.add(Version_textField);
		Version_textField.setColumns(10);

		SerialNumber_textField = new JTextField();
		SerialNumber_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});
		SerialNumber_textField.setBounds(86, 74, 86, 20);
		contentPane.add(SerialNumber_textField);
		SerialNumber_textField.setColumns(10);

		StartDate_textField = new JTextField();
		StartDate_textField.setEditable(false);
		StartDate_textField.setBounds(86, 99, 86, 20);
		contentPane.add(StartDate_textField);
		StartDate_textField.setColumns(10);

		PrivateKey_textField = new JTextField();
		PrivateKey_textField.setEditable(false);
		PrivateKey_textField.setText("");
		PrivateKey_textField.setBounds(75, 399, 537, 20);
		contentPane.add(PrivateKey_textField);
		PrivateKey_textField.setColumns(10);

		PublicKey_textField = new JTextField();
		PublicKey_textField.setEditable(false);
		PublicKey_textField.setBounds(75, 362, 537, 20);
		contentPane.add(PublicKey_textField);
		PublicKey_textField.setColumns(10);

		JLabel label = new JLabel("CN:");
		label.setBounds(229, 27, 46, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("OU:");
		label_1.setBounds(229, 52, 46, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("O:");
		label_2.setBounds(229, 77, 46, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("L:");
		label_3.setBounds(229, 102, 46, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("ST:");
		label_4.setBounds(229, 127, 46, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("C:");
		label_5.setBounds(229, 155, 46, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("E:");
		label_6.setBounds(229, 186, 46, 14);
		contentPane.add(label_6);

		CN_textField = new JTextField();
		CN_textField.setBounds(263, 24, 86, 20);
		contentPane.add(CN_textField);
		CN_textField.setColumns(10);

		OU_textField = new JTextField();
		OU_textField.setBounds(263, 49, 86, 20);
		contentPane.add(OU_textField);
		OU_textField.setColumns(10);

		O_textField = new JTextField();
		O_textField.setBounds(263, 74, 86, 20);
		contentPane.add(O_textField);
		O_textField.setColumns(10);

		L_textField = new JTextField();
		L_textField.setBounds(263, 99, 86, 20);
		contentPane.add(L_textField);
		L_textField.setColumns(10);

		ST_textField = new JTextField();
		ST_textField.setBounds(263, 124, 86, 20);
		contentPane.add(ST_textField);
		ST_textField.setColumns(10);

		C_textField = new JTextField();
		C_textField.setBounds(263, 155, 86, 20);
		contentPane.add(C_textField);
		C_textField.setColumns(10);

		E_textField = new JTextField();
		E_textField.setBounds(263, 186, 86, 20);
		contentPane.add(E_textField);
		E_textField.setColumns(10);

		EndDate_textField = new JTextField();
		EndDate_textField.setEditable(false);
		EndDate_textField.setBounds(86, 127, 86, 20);
		contentPane.add(EndDate_textField);
		EndDate_textField.setColumns(10);

		JLabel lblSubjectInfo = new JLabel("Subject Info:");
		lblSubjectInfo.setBounds(229, 2, 66, 14);
		contentPane.add(lblSubjectInfo);

		JLabel lblOptionalField = new JLabel("Optional field:");
		lblOptionalField.setBounds(398, 2, 86, 14);
		contentPane.add(lblOptionalField);

		JCheckBox Critical_cbx = new JCheckBox("Critical?");
		Critical_cbx.setEnabled(false);
		Critical_cbx.setBounds(398, 48, 97, 23);
		contentPane.add(Critical_cbx);

		JCheckBox CA_cbx = new JCheckBox("CA?");
		CA_cbx.setEnabled(false);
		CA_cbx.setBounds(398, 73, 97, 23);
		contentPane.add(CA_cbx);

		Depth_textField = new JTextField();
		Depth_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});
		Depth_textField.setEnabled(false);
		Depth_textField.setBounds(400, 124, 86, 20);
		contentPane.add(Depth_textField);
		Depth_textField.setColumns(10);

		JLabel lblDepth = new JLabel("Depth of the certification path:");
		lblDepth.setEnabled(false);
		lblDepth.setBounds(400, 102, 165, 14);
		contentPane.add(lblDepth);

		JLabel lblAlternative = new JLabel("Issuer Alternative Name Extension");
		lblAlternative.setEnabled(false);
		lblAlternative.setBounds(398, 161, 167, 14);
		contentPane.add(lblAlternative);

		JTextArea IssuerAlternative_textArea = new JTextArea();
		IssuerAlternative_textArea.setEditable(false);
		IssuerAlternative_textArea.setRows(5);
		IssuerAlternative_textArea.setColumns(1);
		IssuerAlternative_textArea.setBounds(398, 186, 141, 100);
		contentPane.add(IssuerAlternative_textArea);

		JTextArea Certificate_textArea = new JTextArea();
		Certificate_textArea.setWrapStyleWord(true);
		Certificate_textArea.setLineWrap(true);
		Certificate_textArea.setVisible(false);
		Certificate_textArea.setEditable(false);
		Certificate_textArea.setColumns(1);
		Certificate_textArea.setRows(20);
	
		Certificate_textArea.setBounds(658, 22, 301, 430);
		contentPane.add(Certificate_textArea);

		JScrollPane scrollPane = new JScrollPane(Certificate_textArea);
		scrollPane.setSize(301, 390);
		scrollPane.setVisible(false);
		scrollPane.setLocation(658, 27);
		contentPane.add(scrollPane);

		JLabel lblCertificate = new JLabel("Certificate");
		lblCertificate.setVisible(false);
		lblCertificate.setBounds(658, 2, 59, 14);
		contentPane.add(lblCertificate);

		JButton Save_button = new JButton("Save");
		Save_button.setVisible(false);
		Save_button.setBounds(658, 476, 89, 23);
		contentPane.add(Save_button);

		JButton Discard_button = new JButton("Discard");
		Discard_button.setVisible(false);
		Discard_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Certificate_textArea.setText("");
				ks = null;
				Save_button.setVisible(false);
				Discard_button.setVisible(false);
				scrollPane.setVisible(false);
				lblCertificate.setVisible(false);
				Certificate_textArea.setVisible(false);

			}
		});
		Discard_button.setBounds(870, 476, 89, 23);
		contentPane.add(Discard_button);

		JComboBox KeyUsage_combobx = new JComboBox();
		KeyUsage_combobx.setEnabled(false);
		KeyUsage_combobx.setEditable(true);
		KeyUsage_combobx.setModel(new DefaultComboBoxModel(
				new String[] { "digitalSignature", "nonRepudiation", "keyEncipherment", "dataEncipherment",
						"keyAgreement", "keyCertSign", "cRLSign", "encipherOnly", "decipherOnly" }));
		KeyUsage_combobx.setSelectedIndex(0);
		KeyUsage_combobx.setBounds(400, 300, 130, 20);
		contentPane.add(KeyUsage_combobx);

		JCheckBox MoreOption_cbx = new JCheckBox("More option");
		MoreOption_cbx.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (MoreOption_cbx.isSelected()) {
					lblBasicE.setEnabled(true);
					lblDepth.setEnabled(true);
					lblAlternative.setEnabled(true);
					Critical_cbx.setEnabled(true);
					CA_cbx.setEnabled(true);
					Depth_textField.setEnabled(true);
					IssuerAlternative_textArea.setEnabled(true);
					KeyUsage_combobx.setEnabled(true);
				} else {

					lblBasicE.setEnabled(false);
					lblDepth.setEnabled(false);
					lblAlternative.setEnabled(false);
					Critical_cbx.setEnabled(false);
					CA_cbx.setEnabled(false);
					Depth_textField.setEnabled(false);
					IssuerAlternative_textArea.setEnabled(false);
					KeyUsage_combobx.setEnabled(false);
				}
			}
		});
		MoreOption_cbx.setBounds(494, -2, 97, 23);
		contentPane.add(MoreOption_cbx);

		JButton generate_button = new JButton("Generate keys");
		generate_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		generate_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					String keySizeString = keySize_textField.getText();
					if("".equals(keySizeString)){
						throw new StartFrameException(6);

					}
					int keySize = Integer.parseInt(keySizeString);
					if (keySize < 512) {

						keySize = 512;
						keySize_textField.setText("512");
						throw new StartFrameException(0);
					}

					
					String serialnNumString = SerialNumber_textField.getText();
					if ( "".equals(serialnNumString)) {
						throw new StartFrameException(4);
					}
					BigInteger bigNum = new BigInteger(serialnNumString);
					

					DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date(System.currentTimeMillis());
					
					StartDate_textField.setText(df.format(date));

					int year = calendar.getYearChooser().getYear();
					int month = calendar.getMonthChooser().getMonth();
					int day = calendar.getDayChooser().getDay();

					Date date1 = new Date(year-1900, month, day);
					if (date1.before(date)) {
						long miliDate = date.getTime() + 1000 * 24 * 60 * 60; 												
						date1 = new Date(miliDate);
						calendar.setDate(date1);
						EndDate_textField.setText(df.format(date1));
						throw new StartFrameException(1);

					} else
						EndDate_textField.setText(df.format(date1));

					// SUBJECT
					String sub = "";
					String[] pre = { "cn=", "ou=", "o=", "l=", "st=", "c=", "e=" };
					String[] info = { CN_textField.getText(), OU_textField.getText(), O_textField.getText(),
							L_textField.getText(), ST_textField.getText(), C_textField.getText(),
							E_textField.getText() };

					boolean b = false;
					for (int i = 0; i < 7; i++) {
						if (!info[i].isEmpty()) {
							if (!b){
								b = true;
							}
							else{
								if(i == 6){
									
									 EmailValidator emailValidator = new EmailValidator();
									   if(!emailValidator.validate(E_textField.getText().trim())) 
										   throw new StartFrameException(2);
								}
								sub += ", ";
							}
							sub += pre[i] + info[i];
						}
					}
					
					

					if ("".equals(sub)) {
						throw new StartFrameException(3);
					}

					X500Name subject =  new X500Name(sub);

					// END SUBJECT

					// Option field

					Boolean critical = false;
					boolean ca = false;
					int len = 0;
					BasicConstraintsExtension bse = null;
					IssuerAlternativeNameExtension issAltN = null;
					KeyUsageExtension keyUsage = null;

					if (MoreOption_cbx.isSelected()) {

						critical = Critical_cbx.isSelected();
						ca = CA_cbx.isSelected();
						
						
						String depthString = Depth_textField.getText();
						if("".equals(depthString)){
							throw new StartFrameException(5);
						}
						
						len = Integer.parseInt(depthString); // STAVITI
						
						

						bse = new BasicConstraintsExtension(critical, ca, len);

						/*
						 * GeneralNames generalNames = null; if
						 * (IssuerAlternative_textArea.getLineCount() != 0) {
						 * int col = IssuerAlternative_textArea.getLineCount();
						 * for (int i = 0; i < col; i++) {
						 * 
						 * String altName = IssuerAlternative_textArea.getText(
						 * IssuerAlternative_textArea.getLineStartOffset(i),
						 * IssuerAlternative_textArea.getLineEndOffset(i));
						 * 
						 * DerValue dv = new DerValue(altName);
						 * 
						 * GeneralName generalName= new GeneralName(dv);
						 * 
						 * generalNames.add(generalName);
						 * 
						 * if (issAltN == null) { throw new
						 * StartFrameException(5); }
						 * 
						 * 
						 * } issAltN = new
						 * IssuerAlternativeNameExtension(generalNames);
						 * 
						 * }
						 * 
						 * 
						 */
						keyUsage = new KeyUsageExtension();
						int keyUsageIndex = KeyUsage_combobx.getSelectedIndex();
						String[] keyUsageStrings = { "digital_signature", "non_repudiation", "key_encipherment",
								"data_encipherment", "key_agreement", "key_certsign", "crl_sign", "encipher_only",
								"decipher_only" };
						keyUsage.set(keyUsageStrings[keyUsageIndex], true);

						// End of option field
					}

					ks = Generator.generateKeyPair(keySize, bigNum, date, date1, subject, bse, issAltN, keyUsage);

					if (ks == null) {
						throw new StartFrameException(8);
					}

					String pr = ks.getPrivateKey().toString();
					String pu = ks.getCert().getPublicKey().toString();

					PrivateKey_textField.setText(pr);
					PublicKey_textField.setText(pu);

					if (ks != null) {
						Certificate_textArea.setVisible(true);
						lblCertificate.setVisible(true);
						Save_button.setVisible(true);
						scrollPane.setVisible(true);
						Discard_button.setVisible(true);

						X509Certificate uc = (X509Certificate) ks.getCert();
						String s ;
						//Ne radi uc.toString()... ? !

						s = "  X.509v3 certificate,\n";
						s += "  Subject is " + subject + "\n";
						s += "  Key:  " + uc.getPublicKey().toString()+ "\n";
						s += "  Validity <" + date + ">\n until \n<" + date1 + ">\n";
						s += "  Issuer is " + subject + "\n";
						s += "  Issuer signature used " + uc.getSigAlgName() + "\n";
						s += "  Serial number = " + Debug.toHexString(bigNum) + "\n";

						if (bse != null) {
							s += "  Basic Constrains = \n " + bse.toString();

						}
						if (keyUsage != null) {
							s += "  KeyUsage = " + keyUsage.toString();
						}

						s = "[\n" + s + "]";

						Certificate_textArea.setText(s);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error StartFrame",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		generate_button.setBounds(10, 444, 129, 23);
		contentPane.add(generate_button);

	}
}

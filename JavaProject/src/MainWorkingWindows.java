
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shsha
 */
public final class MainWorkingWindows extends javax.swing.JFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet resultSet = null;
    private byte[] personImg = null;
    private String filePath = null;

    /**
     * Creates new form MainWorkingWindows
     */
    public MainWorkingWindows() {
        initComponents();
        init();
        connection = JavaDBConnect.dbConnection();
        UpdateStudentInfoTbl();
        UpdateStudentshrtInfo();
        currentDate();
        UpdateDoc();
    }

    public void init() {
        setLocationRelativeTo(null);  // Done !!
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Done !!
        setResizable(false);  // Done !!
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void UpdateStudentInfoTbl() {

        try {
            String sql = "select Student_id, First_name, Last_name, Department, Series, Age, Height,"
                    + "Weight, Gender, Blood from Student_info";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            tblStudentInfo.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }

    private void UpdateStudentshrtInfo() {

        try {
            String sql = "select Student_id, First_name from Student_info";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            tblStudentshrtInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }

    private void UpdateDoc() {

        try {
            String sql = "select * from Doc_table";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            tblDoc.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }

    private void getValue() {

        try {
            txtStudentId.setText(resultSet.getString("Student_id"));
            txtStudenFname.setText(resultSet.getString("First_name"));
            txtStudentLname.setText(resultSet.getString("Last_name"));
            txtStudentdept.setText(resultSet.getString("Department"));
            txtStudentSeries.setText(resultSet.getString("Series"));
            txtStudentAge.setText(resultSet.getString("Age"));
            txtStudentHeight.setText(resultSet.getString("Height"));
            txtStudentWeight.setText(resultSet.getString("Weight"));
            txtStudentCmboxGender.setSelectedItem(resultSet.getString("Gender"));
            txtStudentblood.setText(resultSet.getString("Blood"));

            byte[] imageData = resultSet.getBytes("Photo");
            ImageIcon format = new ImageIcon(scaledImage(imageData, labelImage.getWidth(), labelImage.getHeight()));
            labelImage.setIcon(format);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private Image scaledImage(byte[] img, int w, int h) {
        BufferedImage resizeImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D g2 = resizeImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            //convert byte array to buffered image
            ByteArrayInputStream in = new ByteArrayInputStream(img);
            BufferedImage bImageFromConver = ImageIO.read(in);
            g2.drawImage(bImageFromConver, 0, 0, w, h, null);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        return resizeImage;
    }

    private void currentDate() {
        // Static Date and Time!!
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        menuDate.setText("Current Date: " + day + " / " + (month + 1) + " / " + year);
        menuDate.setForeground(Color.pink);

        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        menuTime.setText("Current Time: " + hour + " : " + minute + " : " + second);
        menuTime.setForeground(Color.orange);
    }

    // get Screenshot
    public static BufferedImage getScreenshot(Component com) {
        BufferedImage image = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage.TYPE_INT_RGB);
        com.paint(image.getGraphics());
        return image;
    }

    // Saved The Image 
    private static void saveScreenshot(Component com, String fileName) throws Exception {
        BufferedImage img = getScreenshot(com);
        ImageIO.write(img, "png", new File(fileName));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudentInfo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        emailTxtArea = new javax.swing.JTextArea();
        txtAttach = new javax.swing.JTextField();
        txtAttachment = new javax.swing.JTextField();
        btnAttach = new javax.swing.JButton();
        btnAttachment = new javax.swing.JLabel();
        emailSendMail = new javax.swing.JButton();
        btnFrom = new javax.swing.JLabel();
        btnPass = new javax.swing.JLabel();
        btnTo = new javax.swing.JLabel();
        btnSubject = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoc = new javax.swing.JTable();
        txtDocAtach = new javax.swing.JTextField();
        btnDocAttach = new javax.swing.JButton();
        txtDocId = new javax.swing.JTextField();
        txtDocSId = new javax.swing.JTextField();
        txtDocName = new javax.swing.JTextField();
        btnDocAdd = new javax.swing.JButton();
        btnDocDelete = new javax.swing.JButton();
        btnDocClear = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        panelStudentInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStudenFname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStudentLname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStudentdept = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStudentSeries = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStudentAge = new javax.swing.JTextField();
        txtStudentblood = new javax.swing.JTextField();
        txtStudentWeight = new javax.swing.JTextField();
        txtStudentHeight = new javax.swing.JTextField();
        txtStudentCmboxGender = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentshrtInfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        txtImageupld = new javax.swing.JTextField();
        btnImgUpload = new javax.swing.JButton();
        btnImgSave = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        exitbtn = new javax.swing.JMenu();
        mItClose = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mItOffHelp = new javax.swing.JMenuItem();
        mItWebHelp = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuDate = new javax.swing.JMenu();
        menuTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1265, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 0));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Agency FB", 1, 16), new java.awt.Color(102, 0, 102))); // NOI18N
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStudentInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblStudentInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudentInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblStudentInfo.setAutoscrolls(false);
        tblStudentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentInfoMouseClicked(evt);
            }
        });
        tblStudentInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStudentInfoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudentInfo);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 850, 140));

        jTabbedPane1.addTab("  Data Table  ", jPanel2);
        jTabbedPane1.addTab("  Chart  ", jPanel3);
        jTabbedPane1.addTab("  Statistics  ", jPanel4);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 179, 29));

        txtTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToActionPerformed(evt);
            }
        });
        jPanel12.add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 179, 30));

        txtSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubjectActionPerformed(evt);
            }
        });
        jPanel12.add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 179, 32));

        emailTxtArea.setColumns(20);
        emailTxtArea.setRows(5);
        jScrollPane3.setViewportView(emailTxtArea);

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 390, 80));

        txtAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAttachActionPerformed(evt);
            }
        });
        jPanel12.add(txtAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 280, 30));
        jPanel12.add(txtAttachment, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 280, 30));

        btnAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAttach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486693322_attach.png"))); // NOI18N
        btnAttach.setText("Attach");
        btnAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachActionPerformed(evt);
            }
        });
        jPanel12.add(btnAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 90, 30));

        btnAttachment.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        btnAttachment.setForeground(new java.awt.Color(0, 102, 51));
        btnAttachment.setText(" Attachment");
        jPanel12.add(btnAttachment, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 90, 30));

        emailSendMail.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        emailSendMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/send mail.png"))); // NOI18N
        emailSendMail.setText("Send Mail");
        emailSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailSendMailActionPerformed(evt);
            }
        });
        jPanel12.add(emailSendMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 400, 40));

        btnFrom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFrom.setForeground(new java.awt.Color(255, 0, 51));
        btnFrom.setText("From");
        jPanel12.add(btnFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 20));

        btnPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPass.setForeground(new java.awt.Color(255, 51, 51));
        btnPass.setText("Password");
        jPanel12.add(btnPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 75, 70, 30));

        btnTo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTo.setForeground(new java.awt.Color(0, 153, 0));
        btnTo.setText("To");
        jPanel12.add(btnTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        btnSubject.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubject.setForeground(new java.awt.Color(0, 153, 51));
        btnSubject.setText("Subject");
        jPanel12.add(btnSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, 20));
        jPanel12.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 180, 30));

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 0, 840, 292));

        jTabbedPane1.addTab("  Email", jPanel6);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocMouseClicked(evt);
            }
        });
        tblDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDocKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblDoc);

        jPanel13.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 630, 190));
        jPanel13.add(txtDocAtach, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 42, 336, 29));

        btnDocAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDocAttach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486693322_attach.png"))); // NOI18N
        btnDocAttach.setText("Attach");
        btnDocAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocAttachActionPerformed(evt);
            }
        });
        jPanel13.add(btnDocAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 42, 92, 29));
        jPanel13.add(txtDocId, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 82, 214, 32));
        jPanel13.add(txtDocSId, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 127, 214, 33));
        jPanel13.add(txtDocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 171, 214, 35));

        btnDocAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDocAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnDocAdd.setText("Add");
        btnDocAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocAddActionPerformed(evt);
            }
        });
        jPanel13.add(btnDocAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 82, 92, 32));

        btnDocDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDocDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete30.png"))); // NOI18N
        btnDocDelete.setText("Delete");
        btnDocDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocDeleteActionPerformed(evt);
            }
        });
        jPanel13.add(btnDocDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 127, 92, 33));

        btnDocClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDocClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Clear08.png"))); // NOI18N
        btnDocClear.setText("Clear");
        btnDocClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocClearActionPerformed(evt);
            }
        });
        jPanel13.add(btnDocClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 171, 92, 35));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Doc ID");
        jPanel13.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Student Name");
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Doc Name");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 175, 60, 20));

        jPanel5.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1240, 300));

        jTabbedPane1.addTab("  Documents  ", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1360, 340));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("       Welcome to our System");

        txtSearch.setText("Search...");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel11.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 31, 189, 30));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit24.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel11.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 67, 189, 30));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete30.png"))); // NOI18N
        btnDelete.setText(" Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel11.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 101, 189, 31));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Clear08.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel11.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 138, 189, 34));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtSearch))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 270, 280));

        panelStudentInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Info", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), new java.awt.Color(0, 102, 102))); // NOI18N
        panelStudentInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelStudentInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Student ID");
        panelStudentInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 33, 89, 26));

        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });
        panelStudentInfo.add(txtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 30, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("First Name");
        panelStudentInfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 76, 89, 26));
        panelStudentInfo.add(txtStudenFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 73, 140, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Last Name");
        panelStudentInfo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 117, 89, 26));
        panelStudentInfo.add(txtStudentLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 114, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Department");
        panelStudentInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 162, 89, 26));
        panelStudentInfo.add(txtStudentdept, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 159, 140, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Series");
        panelStudentInfo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 202, 89, 26));
        panelStudentInfo.add(txtStudentSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 202, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Blood");
        panelStudentInfo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 202, 60, 26));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Gender");
        panelStudentInfo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 162, 60, 26));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Weight");
        panelStudentInfo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 117, 60, 26));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Height");
        panelStudentInfo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 76, 60, 26));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Age");
        panelStudentInfo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 33, 60, 26));
        panelStudentInfo.add(txtStudentAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 30, 140, 30));
        panelStudentInfo.add(txtStudentblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 202, 140, 30));

        txtStudentWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentWeightActionPerformed(evt);
            }
        });
        panelStudentInfo.add(txtStudentWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 114, 140, 30));
        panelStudentInfo.add(txtStudentHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 73, 140, 30));

        txtStudentCmboxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        txtStudentCmboxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentCmboxGenderActionPerformed(evt);
            }
        });
        panelStudentInfo.add(txtStudentCmboxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 60, 30));

        getContentPane().add(panelStudentInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 570, 290));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student ID And Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(102, 102, 102))); // NOI18N

        tblStudentshrtInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblStudentshrtInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudentshrtInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentshrtInfoMouseClicked(evt);
            }
        });
        tblStudentshrtInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStudentshrtInfoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudentshrtInfo);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 250, 280));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486311982_close.png"))); // NOI18N
        jButton1.setText("Sig out");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 80, 40));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnImgUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload09.png"))); // NOI18N
        btnImgUpload.setText("Upload");
        btnImgUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgUploadActionPerformed(evt);
            }
        });

        btnImgSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/savvvvvee27.png"))); // NOI18N
        btnImgSave.setText("Saved");
        btnImgSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgSaveActionPerformed(evt);
            }
        });
        btnImgSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnImgSaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnImgSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(txtImageupld, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImgUpload)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImageupld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImgUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImgSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 270, 280));

        exitbtn.setText("  File  ");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        mItClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mItClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486309333_Close_Box_Red.png"))); // NOI18N
        mItClose.setText("Close");
        mItClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItCloseActionPerformed(evt);
            }
        });
        exitbtn.add(mItClose);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486310932_Exit.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        exitbtn.add(jMenuItem2);

        jMenuBar1.add(exitbtn);

        jMenu2.setText("Edit  ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486676809_gtk-cut.png"))); // NOI18N
        jMenuItem1.setText("Capture");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help  ");

        mItOffHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mItOffHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486603518_help-browser.png"))); // NOI18N
        mItOffHelp.setText("Offline Help");
        mItOffHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItOffHelpActionPerformed(evt);
            }
        });
        jMenu3.add(mItOffHelp);

        mItWebHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        mItWebHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1486652728_Internet_Line-20.png"))); // NOI18N
        mItWebHelp.setText("Web Help");
        mItWebHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItWebHelpActionPerformed(evt);
            }
        });
        jMenu3.add(mItWebHelp);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("About  ");
        jMenuBar1.add(jMenu4);

        menuDate.setText("Date  ");
        menuDate.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jMenuBar1.add(menuDate);

        menuTime.setText("Time  ");
        menuTime.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jMenuBar1.add(menuTime);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItCloseActionPerformed

        try {
            close();
            LogIn obj = new LogIn();
            obj.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                resultSet.close();
                pst.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_mItCloseActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed

    }//GEN-LAST:event_exitbtnActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            close();
            LogIn obj = new LogIn();
            obj.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                //resultSet.close();
                //pst.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtStudentWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentWeightActionPerformed

    private void tblStudentshrtInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentshrtInfoMouseClicked
        try {
            // TODO add your handling code here:
            int row = tblStudentshrtInfo.getSelectedRow();
            String tableClick = (tblStudentshrtInfo.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Student_info where Student_id = '" + tableClick + "' ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                getValue();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_tblStudentshrtInfoMouseClicked

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void tblStudentshrtInfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentshrtInfoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {

            try {
                // TODO add your handling code here:
                int row = tblStudentshrtInfo.getSelectedRow();
                String tableClick = (tblStudentshrtInfo.getModel().getValueAt(row, 0).toString());
                String sql = "select * from Student_info where Student_id = '" + tableClick + "' ";
                pst = connection.prepareStatement(sql);
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    getValue();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_tblStudentshrtInfoKeyReleased

    private void tblStudentInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentInfoMouseClicked

        try {
            // TODO add your handling code here:
            int row = tblStudentInfo.getSelectedRow();
            String tableClick = (tblStudentInfo.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Student_info where Student_id = '" + tableClick + "' ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                getValue();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }//GEN-LAST:event_tblStudentInfoMouseClicked

    private void tblStudentInfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentInfoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {

            try {
                // TODO add your handling code here:
                int row = tblStudentInfo.getSelectedRow();
                String tableClick = (tblStudentInfo.getModel().getValueAt(row, 0).toString());
                String sql = "select * from Student_info where Student_id = '" + tableClick + "' ";
                pst = connection.prepareStatement(sql);
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    getValue();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_tblStudentInfoKeyReleased

    private void mItOffHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItOffHelpActionPerformed

        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Files\\java_tutorial.pdf");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, "Error opening File !!");
        }
    }//GEN-LAST:event_mItOffHelpActionPerformed

    private void mItWebHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItWebHelpActionPerformed
        try {
            // TODO add your handling code here:
            String url = "https://www.google.com/webhp?ie=UTF-8&rct=j";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_mItWebHelpActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtStudentId.setText(null);
        txtStudenFname.setText(null);
        txtStudentLname.setText(null);
        txtStudentdept.setText(null);
        txtStudentSeries.setText(null);
        txtStudentAge.setText(null);
        txtStudentHeight.setText(null);
        txtStudentWeight.setText(null);
        txtStudentCmboxGender.setSelectedItem("Male");
        txtStudentblood.setText(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String sql = "select * from Student_info where First_name=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtSearch.getText());
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                getValue();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

        String sql1 = "select * from Student_info where Student_id=?";
        try {
            pst = connection.prepareStatement(sql1);
            pst.setString(1, txtSearch.getText());
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                getValue();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String sql = "insert into Student_info(Student_id,First_name,Last_name,"
                + "Department, Series, Age, Height, Weight,Gender,Blood) values(?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtStudentId.getText());
            pst.setString(2, txtStudenFname.getText());
            pst.setString(3, txtStudentLname.getText());
            pst.setString(4, txtStudentdept.getText());
            pst.setString(5, txtStudentSeries.getText());
            pst.setString(6, txtStudentAge.getText());
            pst.setString(7, txtStudentHeight.getText());
            pst.setString(8, txtStudentWeight.getText());
            pst.setString(9, (String) txtStudentCmboxGender.getSelectedItem());
            pst.setString(10, txtStudentblood.getText());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved !!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);

        } finally {
            UpdateStudentshrtInfo();
            UpdateStudentInfoTbl();
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String sql = "update Student_info set First_name=?,Last_name=?,"
                + "Department=?, Series=?, Age=?, Height=?, Weight=?,Gender=?,Blood=? where Student_id=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtStudenFname.getText());
            pst.setString(2, txtStudentLname.getText());
            pst.setString(3, txtStudentdept.getText());
            pst.setString(4, txtStudentSeries.getText());
            pst.setString(5, txtStudentAge.getText());
            pst.setString(6, txtStudentHeight.getText());
            pst.setString(7, txtStudentWeight.getText());
            pst.setString(8, (String) txtStudentCmboxGender.getSelectedItem());
            pst.setString(9, txtStudentblood.getText());
            pst.setString(10, txtStudentId.getText());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Updated !!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);

        } finally {
            UpdateStudentshrtInfo();
            UpdateStudentInfoTbl();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really want to delete?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from Student_info where Student_id=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, txtStudentId.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            } finally {
                UpdateStudentshrtInfo();
                UpdateStudentInfoTbl();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            saveScreenshot(panelStudentInfo, "Panel Img.png");
            JOptionPane.showMessageDialog(rootPane, "Image is Captured!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnImgUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String fileName = f.getAbsolutePath();
        txtImageupld.setText(fileName);

        try {
            FileInputStream fIS = new FileInputStream(f);
            ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fIS.read(buf)) != -1;) {
                bAOS.write(buf, 0, readNum);
            }
            personImg = bAOS.toByteArray();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnImgUploadActionPerformed

    private void btnImgSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgSaveActionPerformed
        // TODO add your handling code here:
        String sql = "update Student_info set Photo = ? where Student_id =?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setBytes(1, personImg);
            pst.setString(2, txtStudentId.getText());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Image Saved !!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnImgSaveActionPerformed

    private void txtAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAttachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAttachActionPerformed

    private void btnAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(rootPane);
        File f = chooser.getSelectedFile();
        filePath = f.getAbsolutePath();
        txtAttach.setText(filePath);
        txtAttachment.setText(filePath);

    }//GEN-LAST:event_btnAttachActionPerformed

    private void emailSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailSendMailActionPerformed
        // TODO add your handling code here:  
        final String From = txtFrom.getText();
        final String Password = jPasswordField1.getText();

        String To = txtTo.getText();
        String Subject = txtSubject.getText();
        String txtMessage = emailTxtArea.getText();

        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.socketFactory.port", "465"); // SSL protocol port no is 465 !!
        pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(pros,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(From, Password);
            }
        }
        );

        try {
            // Message Header !!

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(From));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);

            // Code for set the text message !!
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(txtMessage);
            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(messageBodyPart);

            // Code for attach file !!
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(txtAttachment.getText());
            multiPart.addBodyPart(messageBodyPart);

            message.setContent(multiPart);
            Transport.send(message);

            JOptionPane.showMessageDialog(rootPane, "Message Send !!");

        } catch (HeadlessException | MessagingException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_emailSendMailActionPerformed

    private void txtToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtToActionPerformed

    private void txtSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubjectActionPerformed

    private void tblDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int row = tblDoc.getSelectedRow();
            String tableClick = (tblDoc.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Doc_table where Doc_id = '" + tableClick + "' ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                txtDocId.setText(resultSet.getString("Doc_id"));
                txtDocSId.setText(resultSet.getString("Student_id"));
                txtDocName.setText(resultSet.getString("Doc_name"));
                txtDocAtach.setText(resultSet.getString("Path"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        try {
            int row = tblDoc.getSelectedRow();
            String tableClick = (tblDoc.getModel().getValueAt(row, 3).toString());
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ tableClick);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_tblDocMouseClicked

    private void tblDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDocKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDocKeyReleased

    private void btnDocAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocAttachActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(rootPane);
        File f = chooser.getSelectedFile();
        String fileDocPath = f.getAbsolutePath();
        txtDocAtach.setText(fileDocPath);
    }//GEN-LAST:event_btnDocAttachActionPerformed

    private void btnDocAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocAddActionPerformed
        // TODO add your handling code here:
        String sql = "insert into Doc_table(Doc_id,Student_id,Doc_name,"
                + "Path) values(?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, txtDocId.getText());
            pst.setString(2, txtDocSId.getText());
            pst.setString(3, txtDocName.getText());
            pst.setString(4, txtDocAtach.getText());

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Saved !!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);

        } finally {
            UpdateDoc();
        }
    }//GEN-LAST:event_btnDocAddActionPerformed

    private void btnDocDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocDeleteActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Do You Really want to delete?", "Deleted", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from Doc_table where Doc_id=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, txtDocId.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted !!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            } finally {
                UpdateDoc();
            }
        }
    }//GEN-LAST:event_btnDocDeleteActionPerformed

    private void btnDocClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocClearActionPerformed
        // TODO add your handling code here:
        txtDocId.setText(null);
        txtDocSId.setText(null);
        txtDocName.setText(null);
        txtDocAtach.setText(null);
    }//GEN-LAST:event_btnDocClearActionPerformed

    private void txtStudentCmboxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentCmboxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentCmboxGenderActionPerformed

    private void btnImgSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnImgSaveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImgSaveKeyPressed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWorkingWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWorkingWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWorkingWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWorkingWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWorkingWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAttach;
    private javax.swing.JLabel btnAttachment;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDocAdd;
    private javax.swing.JButton btnDocAttach;
    private javax.swing.JButton btnDocClear;
    private javax.swing.JButton btnDocDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel btnFrom;
    private javax.swing.JButton btnImgSave;
    private javax.swing.JButton btnImgUpload;
    private javax.swing.JLabel btnPass;
    private javax.swing.JLabel btnSubject;
    private javax.swing.JLabel btnTo;
    private javax.swing.JButton emailSendMail;
    private javax.swing.JTextArea emailTxtArea;
    private javax.swing.JMenu exitbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JMenuItem mItClose;
    private javax.swing.JMenuItem mItOffHelp;
    private javax.swing.JMenuItem mItWebHelp;
    private javax.swing.JMenu menuDate;
    private javax.swing.JMenu menuTime;
    private javax.swing.JPanel panelStudentInfo;
    private javax.swing.JTable tblDoc;
    private javax.swing.JTable tblStudentInfo;
    private javax.swing.JTable tblStudentshrtInfo;
    private javax.swing.JTextField txtAttach;
    private javax.swing.JTextField txtAttachment;
    private javax.swing.JTextField txtDocAtach;
    private javax.swing.JTextField txtDocId;
    private javax.swing.JTextField txtDocName;
    private javax.swing.JTextField txtDocSId;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtImageupld;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStudenFname;
    private javax.swing.JTextField txtStudentAge;
    private javax.swing.JComboBox<String> txtStudentCmboxGender;
    private javax.swing.JTextField txtStudentHeight;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentLname;
    private javax.swing.JTextField txtStudentSeries;
    private javax.swing.JTextField txtStudentWeight;
    private javax.swing.JTextField txtStudentblood;
    private javax.swing.JTextField txtStudentdept;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}

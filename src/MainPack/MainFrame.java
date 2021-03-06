package MainPack;

import Listeners.ProjectionListeners.*;
import Listeners.TransformListeners.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;

public class MainFrame extends JFrame {

    private JPanel mainContext;
    private JTabbedPane tabbedPane1;
    private JPanel create;
    private JPanel transform;
    private JPanel workPart;
    private JPanel konusP;
    private JPanel piramidP;
    private JTextField h1TF;
    private JTextField rTF;
    private JButton makeObjButton;
    private JTextField h2TF;
    private JTextField aTF;
    private JTextField kTF;
    private JPanel buffPanel;
    private JPanel viewPanel;
    private JPanel Other;
    private JTextField wightCount;
    private JButton applyButton;
    private JTextField tPosX;
    private JTextField tSizeX;
    private JTextField tRotX;
    private JTextField tPosY;
    private JTextField tSizeY;
    private JTextField tRotY;
    private JTextField tPosZ;
    private JTextField tSizeZ;
    private JTextField tRotZ;
    private JButton positionButton;
    private JPanel proection;
    private JTextField posX;
    private JTextField posY;
    private JTextField posZ;
    private JPanel posPanel;
    private JPanel sizePanel;
    private JPanel rotatePanel;
    private JButton reposButton;
    private JButton resizeButton;
    private JTextField sizeX;
    private JTextField sizeY;
    private JTextField sizeZ;
    private JTextField rotX;
    private JTextField rotY;
    private JTextField rotZ;
    private JButton rotateButton;
    private JPanel paralProections;
    private JPanel centralProection;
    private JTextField jtFi;
    private JTextField jtPsi;
    private JButton applyAcsonomProection;
    private JTextField obliqueAngle;
    private JButton frontBt;
    private JButton sideBt;
    private JButton upBt;
    private JButton isometricBt;
    private JButton dimetricBt;
    private JTextField cPsi;
    private JTextField cP;
    private JTextField cD;
    private JTextField cFi;
    private JButton applyCenter;
    private JTextField lightX;
    private JTextField lightY;
    private JTextField lightZ;
    private JCheckBox hideLines;
    private JButton light;
    private JTextField intRas;
    private JLabel intensOtr;
    private JLabel IntRas;
    private JTextField kofT;
    private JLabel kof;
    private JTextField intOtr;
    private PaintPanel paintPanel;


    public MainFrame() {
        super();
        init();
    }


    private void init() {
        this.setContentPane(mainContext);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setVisible(true);
        viewPanel.setIgnoreRepaint(true);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        paintPanel = new PaintPanel();
        viewPanel.add(paintPanel, gridBagConstraints);
        paintPanel.setVisible(true);

        makeObjButton.addActionListener(new MakeObjButtonListener(paintPanel, h1TF, rTF, kTF, h2TF, aTF));
        applyButton.addActionListener(new ApplyButtonListener(wightCount));
        reposButton.addActionListener(new RePosApplyListener(paintPanel, posX, posY, posZ));
        resizeButton.addActionListener(new ReSizeApplyListener(paintPanel, sizeX, sizeY, sizeZ));
        rotateButton.addActionListener(new RotateApplyListener(paintPanel, rotX, rotY, rotZ));

        upBt.addActionListener(new UpBtListener(paintPanel));
        sideBt.addActionListener(new SideBtListener(paintPanel));
        frontBt.addActionListener(new FrontBtListener(paintPanel));
        applyAcsonomProection.addActionListener(new AcsomProjectionListener(paintPanel, jtFi, jtPsi));
        isometricBt.addActionListener(new ObliqueIsomProj(paintPanel, obliqueAngle));
        dimetricBt.addActionListener(new ObliqueDimetrProj(paintPanel, obliqueAngle));

        applyCenter.addActionListener(new Central(paintPanel, cFi, cPsi, cD, cP));

        hideLines.addItemListener(e -> {
            Painter.hide = e.getStateChange() == ItemEvent.SELECTED;
            paintPanel.repaint();
        });
        light.addActionListener(e -> {
            try {
                Painter.lightV[0] = Double.parseDouble(lightX.getText());
                Painter.lightV[1] = Double.parseDouble(lightY.getText());
                Painter.lightV[2] = Double.parseDouble(lightZ.getText());
                Painter.lightID = Double.parseDouble(intOtr.getText());
                Painter.lightIa = Double.parseDouble(intRas.getText());
                Painter.lightKa = Double.parseDouble(kofT.getText());
                Painter.light = true;
                paintPanel.repaint();
            } catch (Exception exception) {
                System.out.print(exception);
            }
        });
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainContext = new JPanel();
        mainContext.setLayout(new GridBagLayout());
        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setTabLayoutPolicy(0);
        tabbedPane1.setTabPlacement(2);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainContext.add(tabbedPane1, gbc);
        create = new JPanel();
        create.setLayout(new GridBagLayout());
        create.setEnabled(true);
        create.setToolTipText("");
        tabbedPane1.addTab("???????????????? ??????????????", create);
        workPart = new JPanel();
        workPart.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        create.add(workPart, gbc);
        konusP = new JPanel();
        konusP.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        workPart.add(konusP, gbc);
        konusP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "??????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        label1.setText("???????????? (h1):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 1, 0);
        konusP.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        konusP.add(spacer1, gbc);
        h1TF = new JTextField();
        h1TF.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        konusP.add(h1TF, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("???????????? (R):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 1, 0);
        konusP.add(label2, gbc);
        rTF = new JTextField();
        rTF.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        konusP.add(rTF, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("?????????????????????????? (k):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 1, 0);
        konusP.add(label3, gbc);
        kTF = new JTextField();
        kTF.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        konusP.add(kTF, gbc);
        piramidP = new JPanel();
        piramidP.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        workPart.add(piramidP, gbc);
        piramidP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label4 = new JLabel();
        label4.setText("???????????? (h2):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 1, 0);
        piramidP.add(label4, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        piramidP.add(spacer2, gbc);
        h2TF = new JTextField();
        h2TF.setText("15");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        piramidP.add(h2TF, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("???????????? ?????????????? ?????????????????? (a):");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 1, 0);
        piramidP.add(label5, gbc);
        aTF = new JTextField();
        aTF.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        piramidP.add(aTF, gbc);
        buffPanel = new JPanel();
        buffPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        create.add(buffPanel, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("x:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(label6, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        buffPanel.add(spacer3, gbc);
        hideLines = new JCheckBox();
        hideLines.setText("???????????? ?????????????????? ??????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(hideLines, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("z:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(label7, gbc);
        intensOtr = new JLabel();
        intensOtr.setText("?????????????????????????? ?????????????????????? ??????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(intensOtr, gbc);
        IntRas = new JLabel();
        IntRas.setText("?????????????????????????? ???????????????????? ??????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(IntRas, gbc);
        intRas = new JTextField();
        intRas.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(intRas, gbc);
        kof = new JLabel();
        kof.setText("?????????????????????? ?????????????????? ?????????????????????? ??????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(kof, gbc);
        kofT = new JTextField();
        kofT.setText("0.1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(kofT, gbc);
        light = new JButton();
        light.setText("?????????????????? ????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(light, gbc);
        intOtr = new JTextField();
        intOtr.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(intOtr, gbc);
        makeObjButton = new JButton();
        makeObjButton.setText("??????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(makeObjButton, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("y:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        buffPanel.add(label8, gbc);
        lightY = new JTextField();
        lightY.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(lightY, gbc);
        lightX = new JTextField();
        lightX.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(lightX, gbc);
        lightZ = new JTextField();
        lightZ.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buffPanel.add(lightZ, gbc);
        transform = new JPanel();
        transform.setLayout(new GridBagLayout());
        transform.setForeground(new Color(-16777216));
        tabbedPane1.addTab("?????????????????????????? ??????????????", transform);
        posPanel = new JPanel();
        posPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        transform.add(posPanel, gbc);
        posPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), "??????????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label9 = new JLabel();
        label9.setText("X:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        posPanel.add(label9, gbc);
        posX = new JTextField();
        posX.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        posPanel.add(posX, gbc);
        final JLabel label10 = new JLabel();
        label10.setText("Y:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        posPanel.add(label10, gbc);
        posY = new JTextField();
        posY.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        posPanel.add(posY, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("Z:");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        posPanel.add(label11, gbc);
        posZ = new JTextField();
        posZ.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        posPanel.add(posZ, gbc);
        reposButton = new JButton();
        reposButton.setText("??????????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        posPanel.add(reposButton, gbc);
        sizePanel = new JPanel();
        sizePanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        transform.add(sizePanel, gbc);
        sizePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), "?????????????????? ??????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        sizeX = new JTextField();
        sizeX.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        sizePanel.add(sizeX, gbc);
        final JLabel label12 = new JLabel();
        label12.setText("Y:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        sizePanel.add(label12, gbc);
        sizeY = new JTextField();
        sizeY.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        sizePanel.add(sizeY, gbc);
        final JLabel label13 = new JLabel();
        label13.setText("Z:");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        sizePanel.add(label13, gbc);
        sizeZ = new JTextField();
        sizeZ.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        sizePanel.add(sizeZ, gbc);
        final JLabel label14 = new JLabel();
        label14.setText("X:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        sizePanel.add(label14, gbc);
        resizeButton = new JButton();
        resizeButton.setText("????????????????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        sizePanel.add(resizeButton, gbc);
        rotatePanel = new JPanel();
        rotatePanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        transform.add(rotatePanel, gbc);
        rotatePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "??????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        rotateButton = new JButton();
        rotateButton.setText("??????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rotatePanel.add(rotateButton, gbc);
        rotX = new JTextField();
        rotX.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rotatePanel.add(rotX, gbc);
        final JLabel label15 = new JLabel();
        label15.setText("Y:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rotatePanel.add(label15, gbc);
        rotY = new JTextField();
        rotY.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rotatePanel.add(rotY, gbc);
        final JLabel label16 = new JLabel();
        label16.setText("Z:");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rotatePanel.add(label16, gbc);
        rotZ = new JTextField();
        rotZ.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rotatePanel.add(rotZ, gbc);
        final JLabel label17 = new JLabel();
        label17.setText("X:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rotatePanel.add(label17, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        transform.add(spacer4, gbc);
        proection = new JPanel();
        proection.setLayout(new GridBagLayout());
        tabbedPane1.addTab("???????????????? ??????????????", proection);
        paralProections = new JPanel();
        paralProections.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        proection.add(paralProections, gbc);
        paralProections.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "???????????????????????? ????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        paralProections.add(panel1, gbc);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), "?????????????????????????? ????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), "?????????????????????????????? ????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        frontBt = new JButton();
        frontBt.setText("?????? ??????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(frontBt, gbc);
        sideBt = new JButton();
        sideBt.setText("?????? ??????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(sideBt, gbc);
        upBt = new JButton();
        upBt.setText("?????? ????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(upBt, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(spacer5, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel3, gbc);
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "?????????????????????????????????? ????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        jtPsi = new JTextField();
        jtPsi.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(jtPsi, gbc);
        applyAcsonomProection = new JButton();
        applyAcsonomProection.setText("????????????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(applyAcsonomProection, gbc);
        jtFi = new JTextField();
        jtFi.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(jtFi, gbc);
        final JLabel label18 = new JLabel();
        label18.setText("??:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label18, gbc);
        final JLabel label19 = new JLabel();
        label19.setText("??:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label19, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer6, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        paralProections.add(panel4, gbc);
        panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "???????????????????????? ????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label20 = new JLabel();
        label20.setText("???????? ?????? Z:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label20, gbc);
        obliqueAngle = new JTextField();
        obliqueAngle.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(obliqueAngle, gbc);
        isometricBt = new JButton();
        isometricBt.setText("??????????????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(isometricBt, gbc);
        dimetricBt = new JButton();
        dimetricBt.setText("??????????????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(dimetricBt, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel4.add(spacer7, gbc);
        centralProection = new JPanel();
        centralProection.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        proection.add(centralProection, gbc);
        centralProection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "?????????????????????????? ????????????????", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        cPsi = new JTextField();
        cPsi.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centralProection.add(cPsi, gbc);
        cP = new JTextField();
        cP.setText("10");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centralProection.add(cP, gbc);
        cD = new JTextField();
        cD.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centralProection.add(cD, gbc);
        cFi = new JTextField();
        cFi.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centralProection.add(cFi, gbc);
        final JLabel label21 = new JLabel();
        label21.setText("??:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centralProection.add(label21, gbc);
        final JLabel label22 = new JLabel();
        label22.setText("??:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centralProection.add(label22, gbc);
        final JLabel label23 = new JLabel();
        label23.setText("d");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centralProection.add(label23, gbc);
        final JLabel label24 = new JLabel();
        label24.setText("p");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centralProection.add(label24, gbc);
        applyCenter = new JButton();
        applyCenter.setText("??????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centralProection.add(applyCenter, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        centralProection.add(spacer8, gbc);
        Other = new JPanel();
        Other.setLayout(new GridBagLayout());
        tabbedPane1.addTab("??????????????????", Other);
        final JLabel label25 = new JLabel();
        label25.setText("?????????????????????????????? ???????????????????????? ??????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        Other.add(label25, gbc);
        wightCount = new JTextField();
        wightCount.setText("30");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Other.add(wightCount, gbc);
        applyButton = new JButton();
        applyButton.setText("??????????????????");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Other.add(applyButton, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        Other.add(spacer9, gbc);
        viewPanel = new JPanel();
        viewPanel.setLayout(new GridBagLayout());
        viewPanel.setBackground(new Color(-16777216));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainContext.add(viewPanel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainContext;
    }

}

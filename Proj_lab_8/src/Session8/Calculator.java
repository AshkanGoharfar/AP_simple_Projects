package Session8;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.border.Border;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.awt.event.KeyEvent;

public class Calculator {
    private JPanel scientificCalc;
    private HashMap<String,JButton> sciPanel;
    private JMenuItem copyItem;
    private boolean validForDisplayOperators;
    private boolean shiftPressed = false;
    private HashMap<String,JButton> standardPanel;
    private JPanel standardCalc;

    /**
     * Create a Calculator.
     */
    public Calculator() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        JFrame calc_Frame = new JFrame();
        calc_Frame.setTitle("My calculator");
        calc_Frame.setSize(500, 600);
        calc_Frame.setLocation(100, 200);
        calc_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setToolTipText("The menu bar");
        JMenu menu = new JMenu("File");
        menu.setToolTipText("The menu.");
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        exitItem.addActionListener(e -> System.exit(0));
        copyItem = new JMenuItem("Copy to clipboard");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        menu.add(copyItem);
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        jMenuBar.add(menu);
        calc_Frame.setJMenuBar(jMenuBar);
        standardPanel();
        scientificPanel();

        JTabbedPane calculatorTabs = new JTabbedPane();
        calculatorTabs.addTab("Standard calculator", standardCalc);
        calculatorTabs.addTab("Scientific calculator", scientificCalc);
        calc_Frame.add(calculatorTabs);
        calc_Frame.setVisible(true);
    }

    /**
     * The method makes standard calculator panel for standard tab.
     */
    private void standardPanel() {
        standardPanel = new HashMap<>();
        StandardHandler standardHandler = new StandardHandler();
        standardCalc = new JPanel();
        standardCalc.setLayout(new BorderLayout());

        JTextArea display = new JTextArea(2, 5);
        display.setEditable(false);
        display.setFont(new Font("Calibri", Font.BOLD, 36));
        Border border = BorderFactory.createLineBorder(Color.yellow, 1);
        display.setBorder(border);

        copyItem.addActionListener(arg -> {
            StringSelection selection = new StringSelection(display.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        });
        validForDisplayOperators = false;
        display.addKeyListener(standardHandler);

        JPanel opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(2, 5));
        opPanel.setBorder(border);

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(4, 3));
        keyboardPanel.setBorder(border);

        JButton[] numberButton = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton();
            numberButton[i].setToolTipText("Button for numbers");
            numberButton[i].setText("" + i);
            standardPanel.put("" + i,numberButton[i]);
            numberButton[i].addKeyListener(standardHandler);
            numberButton[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                display.append(button.getText());
                validForDisplayOperators = true;
            });
        }

        JButton[] operatorButton = new JButton[9];
        for (int i = 0; i < 9; i++) {
            operatorButton[i] = new JButton();
            operatorButton[i].setToolTipText("Button for operator");
            operatorButton[i].addKeyListener(standardHandler);
            operatorButton[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                String op = button.getText();
                if (button.getText().equals("+")) {
                    actionOnTextArea("+", display);
                }
                if (button.getText().equals("-")) {
                    actionOnTextArea("-", display);
                }
                if (button.getText().equals("*")) {
                    actionOnTextArea("*", display);
                }
                if (button.getText().equals("/")) {
                    actionOnTextArea("/", display);
                }
                if (button.getText().equals("=")) {
                    try{
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        String result = display.getText();
                        display.setText(engine.eval(result).toString());
                    }catch (Exception ignored){display.setText("Wrong input.");}
                }
                if(button.getText().equals(".")) {
                    if(validForDisplayOperators ) {
                        try {
                            String lastFloat = display.getText().substring(display.getText().lastIndexOf(" "));
                            if (lastFloat.contains("."))
                                return;
                            display.append(".");
                            validForDisplayOperators = false;
                        }catch (StringIndexOutOfBoundsException exception){
                            if(display.getText().contains("."))
                                return;
                            display.append(".");
                            validForDisplayOperators = false;}
                    }
                }
                if (button.getText().equals("+/-")) {
                    if (display.getText().charAt(0) == '-') {
                        display.setText(display.getText().substring(1));
                    }
                    else if (display.getText().charAt(0) != '-') {
                        display.setText("-" + display.getText());
                    }
                }
                if (button.getText().equals("%")) {
                    actionOnTextArea("%",display);
                }

            });
        }
        operatorButton[0].addKeyListener(standardHandler);
        operatorButton[0].setText("+");
        standardPanel.put(operatorButton[0].getText(),operatorButton[0]);
        operatorButton[1].addKeyListener(standardHandler);
        operatorButton[1].setText("-");
        standardPanel.put(operatorButton[1].getText(),operatorButton[1]);
        operatorButton[2].addKeyListener(standardHandler);
        operatorButton[2].setText("*");
        standardPanel.put(operatorButton[2].getText(),operatorButton[2]);
        operatorButton[3].addKeyListener(standardHandler);
        operatorButton[3].setText("/");
        standardPanel.put(operatorButton[3].getText(),operatorButton[3]);
        operatorButton[4].addKeyListener(standardHandler);
        operatorButton[4].setText("=");
        standardPanel.put(operatorButton[4].getText(),operatorButton[4]);
        operatorButton[5].addKeyListener(standardHandler);
        operatorButton[5].setText(".");
        standardPanel.put(operatorButton[5].getText(),operatorButton[5]);
        operatorButton[6].setText("+/-");
        operatorButton[7].addKeyListener(standardHandler);
        operatorButton[7].setText("%");
        standardPanel.put(operatorButton[7].getText(),operatorButton[7]);
        operatorButton[8].setText("mod");

        JButton cButton = new JButton();
        cButton.setText("C");
        cButton.setBackground(Color.lightGray);
        cButton.addActionListener(e -> {
            display.setText("");
            validForDisplayOperators = false;
        });
        JButton ceButton = new JButton();
        ceButton.setBackground(Color.blue);
        ceButton.setText("CE");
        ceButton.addActionListener(e -> {
            try {
                if(display.getText().endsWith(" ")) {
                    display.setText(display.getText().substring(0, display.getText().length() - 3));
                    validForDisplayOperators = true;
                }
                else
                    display.setText(display.getText().substring(0, display.getText().length() - 1));
            }catch (StringIndexOutOfBoundsException ignored){}
        });


        JButton openBracket = new JButton();
        JButton closeBracket = new JButton();
        openBracket.setText("(");
        closeBracket.setText(")");

        opPanel.add(operatorButton[0]);
        opPanel.add(operatorButton[1]);
        opPanel.add(operatorButton[2]);
        opPanel.add(ceButton);
        opPanel.add(cButton);
        opPanel.add(operatorButton[6]);
        opPanel.add(operatorButton[7]);
        opPanel.add(operatorButton[3]);
        opPanel.add(openBracket);
        opPanel.add(closeBracket);


//        for (int i = 1; i <= 9; i++) {
//                keyboardPanel.add(numberButton[i]);
//        }

        keyboardPanel.add(numberButton[1]);
        keyboardPanel.add(numberButton[2]);
        keyboardPanel.add(numberButton[3]);
        keyboardPanel.add(numberButton[4]);
        keyboardPanel.add(numberButton[5]);
        keyboardPanel.add(numberButton[6]);
        keyboardPanel.add(numberButton[7]);
        keyboardPanel.add(numberButton[8]);
        keyboardPanel.add(numberButton[9]);
        keyboardPanel.add(operatorButton[5]);
        keyboardPanel.add(numberButton[0]);
        keyboardPanel.add(operatorButton[4]);

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(50, 100));

        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BorderLayout());
        keyPanel.add(opPanel, BorderLayout.NORTH);
        keyPanel.add(keyboardPanel);
        standardCalc.add(scrollPane, BorderLayout.NORTH);
        standardCalc.add(keyPanel, BorderLayout.CENTER);
    }

    /**
     * The method makes scientific calculator panel for scientific tab.
     */
    private void scientificPanel() {
        sciPanel = new HashMap<>();
        SciHandler sciHandler = new SciHandler();
        scientificCalc = new JPanel();
        scientificCalc.setLayout(new BorderLayout());

        JTextArea display = new JTextArea(2, 5);
        display.setEditable(false);
        display.setFont(new Font("Calibri", Font.BOLD, 17));
        Border border = BorderFactory.createLineBorder(Color.red, 1);
        display.setBorder(border);

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(4, 3));
        keyboardPanel.setBorder(border);

        JPanel opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(4, 5));
        opPanel.setBorder(border);

        JButton[] numberButton = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton();
            numberButton[i].setToolTipText("Button for number");
            numberButton[i].setText("" + i);
            sciPanel.put("" + i,numberButton[i]);
            numberButton[i].addKeyListener(sciHandler);
            numberButton[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                display.append(button.getText());
                validForDisplayOperators = true;
            });
        }
        JButton[] operatorButton = new JButton[20];
        for (int i = 0; i < 20; i++) {
            operatorButton[i] = new JButton();
            operatorButton[i].setToolTipText("Button for operator");
            operatorButton[i].addKeyListener(sciHandler);
            operatorButton[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("+")) {
                    actionOnTextArea("+", display);
                }
                if (button.getText().equals("-")) {
                    actionOnTextArea("-", display);
                }
                if (button.getText().equals("*")) {
                    actionOnTextArea("*", display);
                }
                if (button.getText().equals("/")) {
                    actionOnTextArea("/", display);
                }
                if (button.getText().equals("%")) {
                    validForDisplayOperators = true;
                    actionOnTextArea("%",display);
                }
                if (button.getText().equals("+/-")) {
                    if (display.getText().charAt(0) == '-') {
                        display.setText(display.getText().substring(1));
                    }
                    else if (display.getText().charAt(0) != '-') {
                        display.setText("-" + display.getText());
                    }
                }
                if(button.getText().equals(".")) {
                    if(validForDisplayOperators ) {
                        try {
                            String lastFloat = display.getText().substring(display.getText().lastIndexOf(" "));
                            if (lastFloat.contains("."))
                                return;
                            display.append(".");
                            validForDisplayOperators = false;
                        }catch (StringIndexOutOfBoundsException exception){
                            if(display.getText().contains("."))
                                return;
                            display.append(".");
                            validForDisplayOperators = false;}
                    }
                }
                if (button.getText().equals("tan")) {
                    validForDisplayOperators = true;
                    actionOnTextArea("tan(",display);
                }
                if (button.getText().equals("sin")) {
                    validForDisplayOperators = true;
                    actionOnTextArea("sin(",display);
                }
                if (button.getText().equals("cot")) {
                    validForDisplayOperators = true;
                    actionOnTextArea("cot(",display);
                }
                if (button.getText().equals("cos")) {
                    validForDisplayOperators = true;
                    actionOnTextArea("cos(",display);
                }
                if (button.getText().equals("=")) {
                    try{
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        String result = display.getText();
                        result = result.replaceAll("sin", "Math.sin");
                        result = result.replaceAll("cot", "Math.cot");
                        result = result.replaceAll("tan", "Math.tan");
                        result = result.replaceAll("cos", "Math.cos");

                        display.setText(engine.eval(result).toString());
                    }catch (Exception ignored){display.setText("Your input is wrong !");}
                }
            });
        }
        operatorButton[0].setText("+");
        operatorButton[1].setText("-");
        operatorButton[2].setText("*");
        operatorButton[3].setText("/");
        operatorButton[4].setText("=");
        operatorButton[5].setText(".");
        operatorButton[6].setText("+/-");
        operatorButton[7].setText("%");
        operatorButton[8].setText("sin");
        operatorButton[9].setText("cos");
        operatorButton[10].setText("log");
        operatorButton[11].setText("exp");
        operatorButton[12].setText("e");
        operatorButton[13].setText("Pi");
        operatorButton[14].setText("x^y");
        operatorButton[15].setText("ln");
        operatorButton[16].setText("abs");
        operatorButton[17].setText("x^2");
        operatorButton[18].setText("x^1/2");
        operatorButton[19].setText("1/x");
        for (int i = 0; i < 20; i++) {
            operatorButton[i].addKeyListener(sciHandler);
            sciPanel.put(operatorButton[i].getText(),operatorButton[i]);
        }


        JButton cButton = new JButton();
        cButton.setText("C");
        cButton.setBackground(Color.orange);
        cButton.addActionListener(e -> {
            display.setText("");
            validForDisplayOperators = false;
        });
        JButton ceButton = new JButton();
        ceButton.setBackground(Color.green);
        ceButton.setText("CE");
        ceButton.addActionListener(e -> {
            try {
                if(display.getText().endsWith(" ")) {
                    display.setText(display.getText().substring(0, display.getText().length() - 3));
                    validForDisplayOperators = true;
                }
                else
                    display.setText(display.getText().substring(0, display.getText().length() - 1));
            }catch (StringIndexOutOfBoundsException ignored){}
        });

        JButton shiftButton = new JButton();
        shiftButton.setText("Shift");
        shiftButton.setBackground(Color.YELLOW);
        sciPanel.put(shiftButton.getText(), shiftButton);
        shiftButton.addActionListener(e -> {
            shiftPressed = !shiftPressed;
            if (shiftPressed) {
                operatorButton[8].setText("tan");
                operatorButton[9].setText("cot");
            }
            else {
                operatorButton[8].setText("sin");
                operatorButton[9].setText("cos");
            }
        });
        JButton openBracket = new JButton();
        openBracket.setText("(");
        openBracket.addActionListener(e -> {
            display.append("(");
            validForDisplayOperators = true;
        });
        sciPanel.put(openBracket.getText(),openBracket);
        JButton closeBracket = new JButton();
        closeBracket.setText(")");
        closeBracket.addActionListener(e -> {
            display.append(")");
            validForDisplayOperators = true;
        });
        sciPanel.put(closeBracket.getText(),closeBracket);

        opPanel.add(shiftButton);
        opPanel.add(openBracket);
        opPanel.add(closeBracket);
        opPanel.add(ceButton);
        opPanel.add(cButton);

        opPanel.add(operatorButton[15]);
        opPanel.add(operatorButton[17]);
        opPanel.add(operatorButton[18]);
        opPanel.add(operatorButton[19]);
        opPanel.add(operatorButton[16]);

        opPanel.add(operatorButton[9]);
        opPanel.add(operatorButton[10]);
        opPanel.add(operatorButton[13]);
        opPanel.add(operatorButton[7]);
        opPanel.add(operatorButton[11]);

        opPanel.add(operatorButton[8]);
        opPanel.add(operatorButton[14]);
        opPanel.add(operatorButton[12]);
        opPanel.add(operatorButton[6]);

        opPanel.add(operatorButton[5]);
        opPanel.add(operatorButton[4]);


        keyboardPanel.add(numberButton[1]);
        keyboardPanel.add(numberButton[2]);
        keyboardPanel.add(numberButton[3]);
        keyboardPanel.add(operatorButton[0]);
        keyboardPanel.add(numberButton[4]);
        keyboardPanel.add(numberButton[5]);
        keyboardPanel.add(numberButton[6]);
        keyboardPanel.add(operatorButton[1]);
        keyboardPanel.add(numberButton[7]);
        keyboardPanel.add(numberButton[8]);
        keyboardPanel.add(numberButton[9]);
        keyboardPanel.add(operatorButton[2]);
        keyboardPanel.add(operatorButton[5]);
        keyboardPanel.add(numberButton[0]);
        keyboardPanel.add(operatorButton[4]);
        keyboardPanel.add(operatorButton[3]);

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(50, 100));

        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BorderLayout());
        keyPanel.add(opPanel, BorderLayout.NORTH);
        keyPanel.add(keyboardPanel);
        scientificCalc.add(scrollPane, BorderLayout.NORTH);
        scientificCalc.add(keyPanel, BorderLayout.CENTER);
    }
    /**
     * make actionOnTextArea.
     *
     * The method makes action for TextArea.
     *
     * @param string text
     * @param textArea text area
     */
    private void actionOnTextArea(String string , JTextArea textArea)
    {
        if(validForDisplayOperators)
            textArea.append(string);
        validForDisplayOperators = false;
    }

    /**
     * make Standard Handler.
     *
     * The method handel standard keyboard key.
     */
    private class StandardHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
            if(standardPanel.containsKey("" + e.getKeyChar())) {
                standardPanel.get("" + e.getKeyChar()).doClick();
                return;
            }
            if(standardPanel.containsKey("" + KeyEvent.getKeyText(e.getKeyCode())))
                standardPanel.get( "" + KeyEvent.getKeyText(e.getKeyCode())).doClick();
        }
    }
    /**
     * make Scientific Handler.
     *
     * The method handel scientific keyboard key.
     */
    private class SciHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
            if(sciPanel.containsKey("" + e.getKeyChar())) {
                sciPanel.get("" + e.getKeyChar()).doClick();
                return;
            }
            if(sciPanel.containsKey("" + KeyEvent.getKeyText(e.getKeyCode())))
                sciPanel.get( "" + KeyEvent.getKeyText(e.getKeyCode())).doClick();
        }
    }
}

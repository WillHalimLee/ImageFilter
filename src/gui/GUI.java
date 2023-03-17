/*
 * TCSS 305 - Assignment 4
 */
package gui;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * A GUI that allows image filtering.
 * 
 * @author leeh10
 * @version 11/4/2022
 */
public class GUI implements ActionListener {

    /** The Size of the JFrame.*/
    private static final Dimension SIZE = new Dimension(600, 600);

    /** A JFrame used for this GUI.*/
    private final JFrame myFrame;

    /** A JPanel for the Filter Buttons.*/
    private final JPanel myFilterPanel;

    /** A JPanel for the Option Buttons.*/
    private final JPanel myOptionPanel;

    /** A JPanel for the Image Label.*/
    private final JPanel myImagePanel;

    /** A JLabel for the Image Panel.*/
    private final JLabel myImageLabel;

    /** A FileChooser Object used to locate a file.*/
    private final JFileChooser myFileChooser;

    /** The Image that will be displayed.*/
    private PixelImage myImage;

    /** An ArrayList that holds all the filter buttons.*/
    private final List<JButton> myButtonList;

    /** An ArrayList that holds all the option buttons.*/
    private final List<JButton> myOptionList;

    /**Initiates all the fields. */
    public GUI() {
        myFrame = new JFrame("Image Filter");
        myFilterPanel = new JPanel(new GridLayout(0, 1));
        myOptionPanel = new JPanel(new FlowLayout());
        myImagePanel = new JPanel(new GridLayout());
        myImageLabel = new JLabel();
        myFileChooser = new JFileChooser(".");
        myButtonList = new ArrayList<JButton>();
        myOptionList = new ArrayList<JButton>();
    }

    /** The method that is called in the main class to start the GUI.*/
    public void start() {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(SIZE);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        
        myImagePanel.add(myImageLabel);
        myImageLabel.setHorizontalAlignment(JLabel.CENTER);
        myFrame.add(myImagePanel);    
       
        filterPanel();
        myFrame.add(myFilterPanel, BorderLayout.WEST);
        optionPanel();
        myFrame.add(myOptionPanel, BorderLayout.SOUTH);
        

        myFrame.pack();
        for (final JButton button : myButtonList) {
            button.setEnabled(false);
        }

    }

    /** Method for the filter Panel.*/
    public void filterPanel() {

// Instance all the Filters.
        final EdgeDetectFilter edgeDetectFilter = new EdgeDetectFilter();
        final EdgeHighlightFilter edgeHighlightFilter = new EdgeHighlightFilter();
        final FlipHorizontalFilter flipHorizontalFilter = new FlipHorizontalFilter();
        final FlipVerticalFilter flipVerticalFilter = new FlipVerticalFilter();
        final GrayscaleFilter grayScaleFilter = new GrayscaleFilter();
        final SharpenFilter sharpenFilter = new SharpenFilter();
        final SoftenFilter softenFilter = new SoftenFilter();

// Add the buttons to the button List.
        myButtonList.add(buttonED(edgeDetectFilter));
        myButtonList.add(buttonEH(edgeHighlightFilter));
        myButtonList.add(buttonFH(flipHorizontalFilter));
        myButtonList.add(buttonFV(flipVerticalFilter));
        myButtonList.add(buttonGS(grayScaleFilter));
        myButtonList.add(buttonSharp(sharpenFilter));
        myButtonList.add(buttonSoft(softenFilter));

// Add the buttons to the Filter Panel and disable all filter buttons.
        for (final JButton button : myButtonList) {
            myFilterPanel.add(button);
            button.setEnabled(false);
        }

    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonED(final EdgeDetectFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonEH(final EdgeHighlightFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonFH(final FlipHorizontalFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonFV(final FlipVerticalFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonGS(final GrayscaleFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonSharp(final SharpenFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * Creates a single button that applies a filter to the image when pressed.
     * 
     * @param theFilter The Filter
     * @return the Button.
     */
    private JButton buttonSoft(final SoftenFilter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        class AnActionListener implements ActionListener {

            /**
             * Applies a filter on the image.
             *
             * @param theEvent The event, ignored.
             */
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage));
            }
        }
        button.addActionListener(new AnActionListener());
        return button;
    }

    /** 
     * A method that creates buttons for the option panels containing open, save, and close.
     * 
     */
    public void optionPanel() {
        final JButton open = new JButton("Open...");
        final JButton saveAs = new JButton("Save As...");
        final JButton closeImage = new JButton("Close Image");

        open.addActionListener(this);
        saveAs.addActionListener(this);
        closeImage.addActionListener(this);

        saveAs.setEnabled(false);
        closeImage.setEnabled(false);

        myOptionList.add(open);
        myOptionList.add(saveAs);
        myOptionList.add(closeImage);

        myOptionPanel.add(myOptionList.get(0));
        myOptionPanel.add(myOptionList.get(1));
        myOptionPanel.add(myOptionList.get(2));

    }

    /**
     * A action listener method for the option panels containing open, save as,
     * and close image.
     * 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        // Opening the file.
        if (theEvent.getSource().equals(myOptionList.get(0))) {
            final int result = myFileChooser.showOpenDialog(myOptionPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                final File selectedFile = myFileChooser.getSelectedFile();
                try {
                    myImage = PixelImage.load(selectedFile);
                    openMethodHelper();
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(myOptionPanel, 
                            "The selected file did not contain an image!");
                }

            }
        }
        // Saving the File.
        if (theEvent.getSource().equals(myOptionList.get(1))) {
            savingHelp();
        }
       // Closing the Image.
        if (theEvent.getSource().equals(myOptionList.get(2))) {
            myImageLabel.setIcon(null);
            myFrame.setMinimumSize(new Dimension(0, 0));
            myFrame.pack();
            myFrame.setMinimumSize(myFrame.getBounds().getSize());
            for (final JButton button : myButtonList) {
                button.setEnabled(false);
            }
            for (final JButton button : myOptionList) {
                button.setEnabled(false);
            }
            myOptionList.get(0).setEnabled(true);
        }
    }
    
    /** Method that prompts the user a warning when they are about to save over an 
     *  existing file.*/
    public void savingHelp() {
        final int result = myFileChooser.showSaveDialog(myOptionPanel);
        if (result == JFileChooser.APPROVE_OPTION) {
            final File selectedFile = myFileChooser.getSelectedFile();
            if (selectedFile.exists()) {
                final int response = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to override an existing file?",
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    try {
                        myImage.save(selectedFile);
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                try {
                    myImage.save(selectedFile);
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * A helper method that inserts the image selected into the GUI. 
     * Sets all the buttons to be enabled.
     */
    private void openMethodHelper() {
        myImageLabel.setIcon(new ImageIcon(myImage));
        myFrame.setMinimumSize(new Dimension(0, 0));
        myFrame.pack();
        myFrame.setMinimumSize(myFrame.getBounds().getSize());
        for (final JButton button : myButtonList) {
            button.setEnabled(true);
        }
        for (final JButton button : myOptionList) {
            button.setEnabled(true);
        }
    }
}
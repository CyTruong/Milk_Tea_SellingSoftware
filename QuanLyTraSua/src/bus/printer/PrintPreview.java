package bus.printer;
/*******************************************************************

   This software is the confidential  and proprietary information of
   NetCat Inc.  You shall not disclose such confidential information
   and shall use it only in accordance with the terms of the license
   agreement you entered into with NetCat Inc.

   Copyright (c) 2003 - 2004 by NetCat Inc., www.netcat.li

   Author: Arthur Marxer, Dipl. Informatik-Ing. ETH

*******************************************************************/

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

import javax.swing.*;
import javax.swing.border.*;

import li.netcat.print.*;

public class PrintPreview extends JPanel implements ActionListener {
  private static final ImageIcon NEXT_PAGE = new ImageIcon("./res/NextPage.gif");
  private static final ImageIcon PREVIOUS_PAGE = new ImageIcon("./res/PreviousPage.gif");
  private static final ImageIcon ZOOM_IN = new ImageIcon("./res/ZoomIn.gif");
  private static final ImageIcon ZOOM_OUT = new ImageIcon("./res/ZoomOut.gif");
  private static final ImageIcon SCALE_OUT = new ImageIcon("./res/ScaleOut.gif");
  private static final ImageIcon SCALE_IN = new ImageIcon("./res/ScaleIn.gif");
  private static final ImageIcon ORIENTATION = new ImageIcon("./res/Orientation.gif");
  private static final ImageIcon RESET = new ImageIcon("./res/Reset.gif");
  private static final ImageIcon SETUP = new ImageIcon("./res/Setup.gif");
  private static final ImageIcon PRINT = new ImageIcon("./res/Print.gif");
  private PreviewPanel _previewPanel;
  private JButton      _nextPageButton;
  private JButton      _previousPageButton;
  private JButton      _zoomOutButton;
  private JButton      _zoomInButton;
  private JButton      _scaleOutButton;
  private JButton      _scaleInButton;
  private JButton      _orientationButton;
  private JButton      _resetButton;
  private JButton      _pageDialogButton;
  private JButton      _printButton;
  
  //// constructors

  public PrintPreview(Print print) {
    super(new BorderLayout(5, 5));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    _previewPanel = new PreviewPanel(print);
    add(new JScrollPane(_previewPanel), BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel(new GridLayout(1, -1, 5, 5));
    JPanel toolBar = new JPanel(new BorderLayout(5, 5));
    toolBar.add(buttonPanel, BorderLayout.WEST);
    add(toolBar, BorderLayout.NORTH);
    buttonPanel.add(_previousPageButton = createButton(PREVIOUS_PAGE, "Previous Page"));
    buttonPanel.add(_nextPageButton = createButton(NEXT_PAGE, "Next Page"));
    buttonPanel.add(_zoomOutButton = createButton(ZOOM_OUT, "Zoom Out"));
    buttonPanel.add(_zoomInButton = createButton(ZOOM_IN, "Zoom In"));
    buttonPanel.add(_scaleOutButton = createButton(SCALE_OUT, "Scale Out"));
    buttonPanel.add(_scaleInButton = createButton(SCALE_IN, "Scale In"));
    buttonPanel.add(_orientationButton = createButton(ORIENTATION, "Change Orientation"));
    buttonPanel.add(_pageDialogButton = createButton(SETUP, "Page Setup"));
    buttonPanel.add(_resetButton = createButton(RESET, "Reset"));
    buttonPanel.add(_printButton = createButton(PRINT, "Print"));
  }
  
  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    if (source == _nextPageButton) {
      _previewPanel.nextPage();
    }
    else if (source == _previousPageButton) {
      _previewPanel.previousPage();
    }
    else if (source == _zoomOutButton) {
      _previewPanel.setZoom(_previewPanel.getZoom() / 1.3);
    }
    else if (source == _zoomInButton) {
      _previewPanel.setZoom(_previewPanel.getZoom() * 1.3);
    }
    else if (source == _scaleOutButton) {
      _previewPanel.getPrintManager().setScaleValue(_previewPanel.getPrintManager().getScaleValue() / 1.1);
    }
    else if (source == _scaleInButton) {
      _previewPanel.getPrintManager().setScaleValue(_previewPanel.getPrintManager().getScaleValue() * 1.1);
    }
    else if (source == _orientationButton) {
      int newOrientation = _previewPanel.getPrintManager().getOrientation() == PrintConstants.PORTRAIT ? PrintConstants.LANDSCAPE : PrintConstants.PORTRAIT;
      _previewPanel.getPrintManager().setOrientation(newOrientation);
    }
    else if (source == _resetButton) {
      PrintManager pm = _previewPanel.getPrintManager();
      pm.setPageFormat(pm.getPrinterJob().defaultPage());
      pm.setScaleValue(1.0);
      _previewPanel.setZoom(1.0);
    }
    else if (source == _pageDialogButton) {
      _previewPanel.getPrintManager().pageDialog(true);
    }
    else if (source == _printButton) {
      try {
        _previewPanel.getPrintManager().print(true);
        // or call the following if you don't want a dialog:
        //_previewPanel.getPrintManager().print(false);
      }
      catch (PrinterException x) {
        x.printStackTrace();
      }
    }
  }

  //// public methods
  
  public JFrame open() {
    JFrame frame = new JFrame();
    frame.setContentPane(this);
    frame.pack();
    frame.setVisible(true);
    // the following operation causes the application to exit when
    // the user closes the print preview.Please uncoment it when you want
    // that the application should continue running 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.toFront();
    return frame;
  }
  
  public PreviewPanel getPreviewPanel() {
    return _previewPanel;
  }
  
  //// commands
 
  private JButton createButton(ImageIcon icon, String toolTip) {
    JButton button = new JButton(icon);
    button.setToolTipText(toolTip);
    button.addActionListener(this);
    button.setPreferredSize(new Dimension(28, 26));
    return button;
  }
 
 
}
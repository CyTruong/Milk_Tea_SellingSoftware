package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import bus.Size;
import mdlaf.MaterialLookAndFeel;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class chooseSizeDialog extends JDialog {
	
	interface iChooseSizeFinish {
		public void ChoosesizeFinish(int i);
	}
	
	iChooseSizeFinish _iChooseSizeFinish = null;

	/**
	 * Launch the application.
	 */
	private int _size =1;
	
	public static void main(String[] args) {
		try {
			chooseSizeDialog dialog = new chooseSizeDialog();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public void setOnFinishChooseSizeListener(iChooseSizeFinish i) {
		this._iChooseSizeFinish = i;
	}
	
	
	public chooseSizeDialog() {
		getContentPane().setBackground(new Color(240, 255, 255));
		
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel ());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(500, 300, 204, 298);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(166,98,5));
		JButton btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_size = 1;
				if(_iChooseSizeFinish!=null) {
					_iChooseSizeFinish.ChoosesizeFinish(_size);
				}
				dispose();
			}
		});
		btnS.setBounds(10, 11, 181, 85);
		getContentPane().add(btnS);
		btnS.setFont(new Font("ARIAL", Font.BOLD, 30));
		
		JButton btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_size = 2;
				if(_iChooseSizeFinish!=null) {
					_iChooseSizeFinish.ChoosesizeFinish(_size);
				}
				dispose();

			}
		});
		btnM.setBounds(10, 107, 181, 85);
		getContentPane().add(btnM);
		btnM.setFont(new Font("ARIAL", Font.BOLD, 30));

		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_size =3;
				if(_iChooseSizeFinish!=null) {
					_iChooseSizeFinish.ChoosesizeFinish(_size);
				}
				dispose();

			}
		});
		btnL.setBounds(10, 203, 181, 85);
		getContentPane().add(btnL);
		btnL.setFont(new Font("ARIAL", Font.BOLD, 30));

	}
	
	@Override
	public void dispose() {
		System.out.println(_size);
		super.dispose();
	}


}

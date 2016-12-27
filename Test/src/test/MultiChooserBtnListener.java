package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MultiChooserBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		chooser.showOpenDialog(null);
		
		File[] files = chooser.getSelectedFiles();
		String[] fileNames = new String[files.length];
		String message = "";
		for(int i=0;i<files.length;i++){
			fileNames[i] = files[i].getPath();
			message+= fileNames[i]+"\n";
		}
		
		JOptionPane.showMessageDialog(null, message);
		
	}

}

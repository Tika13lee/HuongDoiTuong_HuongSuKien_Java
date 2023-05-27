package demoComponents;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class STT30_LeThiThuyKieu_JList extends JFrame implements ListSelectionListener {
	private JTextField txtSelec;
	private JList dsEntry;

	public STT30_LeThiThuyKieu_JList() {
		setTitle("Creating a Simple JList");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		String[] entries = { "Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6" };
		dsEntry = new JList<>(entries);
		dsEntry.setVisibleRowCount(4);
		JScrollPane dsPane = new JScrollPane(dsEntry);

		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("Simple JList"));
		jp.add(dsPane);

		JPanel jp2 = new JPanel();
		jp2.setBorder(BorderFactory.createTitledBorder("List Selection"));
		jp2.add(new Label("Last selection"));
		jp2.add(txtSelec = new JTextField(10));

		add(jp);
		add(jp2, BorderLayout.SOUTH);

		dsEntry.addListSelectionListener(this);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JList().setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		txtSelec.setText(dsEntry.getSelectedValue().toString());

	}
}

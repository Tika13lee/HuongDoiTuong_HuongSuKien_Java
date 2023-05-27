package tuan7_30_XML;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DOMvsGUI extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 6736610855443618564L;
	private DefaultTableModel model;
	private JTable table;
	private ManageProduct dom;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnAdd;
	private TableRowSorter<TableModel> sorter;
	private JButton btnFilter;
	private JLabel lblProductID;
	private JLabel lblProductName;
	private JLabel lblManufacture;
	private JLabel lblDescription;
	private JLabel lblSuplierName;
	private JLabel lblCountry;
	private JLabel lblWebsite;
	private JLabel lblPrice;
	private JTextField txtProductID;
	private JTextField txtProductName;
	private JTextField txtManufacture;
	private JTextField txtDescription;
	private JTextField txtSuplierName;
	private JTextField txtCountry;
	private JTextField txtWebsite;
	private JTextField txtPrice;
	

	public DOMvsGUI() {
		setTitle("Dom parser");
//		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// north
		JPanel jpNorth = new JPanel();
		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		jpNorth.setLayout(null);
		jpNorth.setPreferredSize(new Dimension(800, 200));

		jpNorth.add(lblProductID = new JLabel("ProductID:"));
		jpNorth.add(lblProductName = new JLabel("ProductName:"));
		jpNorth.add(lblSuplierName = new JLabel("Suplier Name:"));
		jpNorth.add(lblManufacture = new JLabel("Manufacture:"));
		jpNorth.add(lblCountry = new JLabel("Country:"));
		jpNorth.add(lblDescription = new JLabel("Description:"));
		jpNorth.add(lblWebsite = new JLabel("Website:"));
		jpNorth.add(lblPrice = new JLabel("Price:"));

		jpNorth.add(txtProductID = new JTextField(20));
		jpNorth.add(txtProductName = new JTextField(20));
		jpNorth.add(txtManufacture = new JTextField(20));
		jpNorth.add(txtDescription = new JTextField(20));
		jpNorth.add(txtSuplierName = new JTextField(20));
		jpNorth.add(txtCountry = new JTextField(20));
		jpNorth.add(txtWebsite = new JTextField(20));
		jpNorth.add(txtPrice = new JTextField(20));

		int x = 50, y = 30, w = 150, w2 = 330, h = 20;
		lblProductID.setBounds(x, 30, w, h);
		lblProductName.setBounds(x, y += 25, w, h);
		lblManufacture.setBounds(x, y += 25, w, h);
		lblDescription.setBounds(x, y += 25, w, h);
		

		x += 80;
		txtProductID.setBounds(x, y -= 75, w2, h);
		txtProductName.setBounds(x, y += 25, w2, h);
		txtManufacture.setBounds(x, y += 25, w2, h);
		txtDescription.setBounds(x, y += 25, w2, h);
		

		x += 400;
		lblSuplierName.setBounds(x, y -= 75, w, h);
		lblCountry.setBounds(x, y += 25, w, h);
		lblWebsite.setBounds(x, y += 25, w, h);
		lblPrice.setBounds(x, y += 25, w, h);

		x += 80;
		txtSuplierName.setBounds(x, y -= 75, w2, h);
		txtCountry.setBounds(x, y += 25, w2, h);
		txtWebsite.setBounds(x, y += 25, w2, h);
		txtPrice.setBounds(x, y += 25, w2, h);

		// table
		String[] headers = { "productID", "name", "manufacture", "description", "sname", "country", "web", "price" };
		add(new JScrollPane(table = new JTable(model = new DefaultTableModel(headers, 0))), BorderLayout.CENTER);

		dom = new ManageProduct();
		updateTableData();

		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

		// south
		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		pnlSouth.add(btnAdd = new JButton("Add"));
		pnlSouth.add(btnDelete = new JButton("Delete"));
		pnlSouth.add(btnUpdate = new JButton("UpdatePrice"));
		pnlSouth.add(btnSave = new JButton("Save"));
		pnlSouth.add(btnFilter = new JButton("Filter"));

		//event
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSave.addActionListener(this);
		btnFilter.addActionListener(this);
		btnAdd.addActionListener(this);
		table.addMouseListener(this);
	}

	private void updateTableData() {

		// xoa du lieu tren table
		while (table.getRowCount() != 0)
			model.removeRow(0);
//		model.setRowCount(0);

		ArrayList<Product> list = dom.getAllProducts();
		for (Product p : list) {
			String rowData[] = { p.getProductId(), p.getProductName(), p.getManufacture(), p.getDescription(),
					p.getSuplier().getSuplierName(), p.getSuplier().getCountry(), p.getSuplier().getWebsite(),
					p.getPrice() + "" };
			model.addRow(rowData);
		}
	}

	public static void main(String[] args) {
		new DOMvsGUI().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			String id = txtProductID.getText().trim();
			String name = txtProductName.getText().trim();
			String manu = txtManufacture.getText().trim();
			String des = txtDescription.getText().trim();
			String tenNcc = txtSuplierName.getText().trim();
			String country = txtCountry.getText().trim();
			String website = txtWebsite.getText().trim();
			String gia = txtPrice.getText().trim();
			Suplier s = new Suplier(tenNcc, country, website);
			Product p = new Product(id, name, manu, des, Integer.parseInt(gia), s);
			dom.addProduct(p);
			dom.writeXMLFile();
			updateTableData();
		} else if (o.equals(btnDelete)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				if (JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa dong nay?", "Canh bao",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String ma = model.getValueAt(row, 0).toString();
					model.removeRow(row);
					dom.deleteProduct(ma);
					dom.writeXMLFile();
				}
			} else
				JOptionPane.showMessageDialog(this, "Vui long chon dong can xoa");
		} else if (o.equals(btnUpdate)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				String id = txtProductID.getText().trim();
				double gia = Double.parseDouble(txtPrice.getText().trim());
				dom.updatePrice(id, gia);
				dom.writeXMLFile();
				updateTableData();
			} else
				JOptionPane.showMessageDialog(this, "Vui long chon dong can cap nhat gia");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row != -1) {
			txtProductID.setText(model.getValueAt(row, 0).toString());
			txtProductName.setText(model.getValueAt(row, 1).toString());
			txtManufacture.setText(model.getValueAt(row, 2).toString());
			txtDescription.setText(model.getValueAt(row, 3).toString());
			txtSuplierName.setText(model.getValueAt(row, 4).toString());
			txtCountry.setText(model.getValueAt(row, 5).toString());
			txtWebsite.setText(model.getValueAt(row, 6).toString());
			txtPrice.setText(model.getValueAt(row, 7).toString());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package tuan3_30_Employees;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUIEmp extends JFrame implements ActionListener, MouseListener {
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblTuoi;
	private JLabel lblPb;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JComboBox<String> cboPb;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnLuu;
	private DefaultTableModel modelEmp;
	private JTable tableEmp;
	private JScrollPane sp;

	private ListEmp ds = new ListEmp();
	private JButton btnTim;
	private JButton btnSua;
	private JButton btnXoa;
	private static final String FILE = "src/data/dsEmp.txt";

	public GUIEmp() {
		setTitle("Employee!!!");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel jpN, jpC, jpS;

		jpN = new JPanel();
		this.add(jpN, BorderLayout.NORTH);
		jpN.setLayout(new BoxLayout(jpN, BoxLayout.Y_AXIS));

		Box b1, b2, b3;

		b1 = Box.createHorizontalBox();
		b1.add(lblMa = new JLabel("Mã nhân viên:"));
		b1.add(txtMa = new JTextField(10));
		lblMa.setPreferredSize(new Dimension(100, 10));

		b2 = Box.createHorizontalBox();
		b2.add(lblTen = new JLabel("Họ tên nhân viên:"));
		b2.add(txtTen = new JTextField(10));
		lblTen.setPreferredSize(lblMa.getPreferredSize());

		b3 = Box.createHorizontalBox();
		b3.add(lblTuoi = new JLabel("Tuổi:"));
		lblTuoi.setPreferredSize(lblMa.getPreferredSize());
		b3.add(txtTuoi = new JTextField(10));
		b3.add(lblPb = new JLabel("Phòng ban"));
		String[] str = { "Phòng tổ chức", "Phòng kỹ thuật", "Phòng nhân sự" };
		b3.add(cboPb = new JComboBox<>(str));

		// set data
		txtMa.setText("111");
		txtTen.setText("Thúy Kiều");
		txtTuoi.setText("20");

		jpN.add(Box.createRigidArea(new Dimension(10, 10)));
		jpN.add(b1);
		jpN.add(Box.createRigidArea(new Dimension(10, 10)));
		jpN.add(b2);
		jpN.add(Box.createRigidArea(new Dimension(10, 10)));
		jpN.add(b3);
		jpN.add(Box.createRigidArea(new Dimension(10, 10)));

		String[] cols = { "Mã nhân viên", "Họ tên nhân viên", "Tuổi", "Phòng ban" };
		modelEmp = new DefaultTableModel(cols, 0);
		tableEmp = new JTable(modelEmp);
		sp = new JScrollPane(tableEmp);
		this.add(sp, BorderLayout.CENTER);

		// load data
//		LuuTruEmp lt = new LuuTruEmp();
//		try {
//			ds = (ListEmp) lt.docFile(FILE);
//			loadDataToTable();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		jpC = new JPanel();
		this.add(jpC, BorderLayout.SOUTH);
		jpC.add(btnThem = new JButton("Thêm"));
		jpC.add(btnXoaRong = new JButton("Xóa trắng"));
		jpC.add(btnTim = new JButton("Tìm"));
		jpC.add(btnLuu = new JButton("Lưu"));
		jpC.add(btnSua = new JButton("Sửa"));
			

		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnTim.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
//		btnXoa.addActionListener(this);
		tableEmp.addMouseListener(this);
	}

	public static void main(String[] args) {
		new GUIEmp().setVisible(true);
	}

	private void loadDataToTable() {
		modelEmp.setRowCount(0);
		for (Employee emp : ds.getDs()) {
			modelEmp.addRow(new Object[] { emp.getMaNV(), emp.getHoTen(), emp.getTuoi(), emp.getPhongBan() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (txtMa.getText().equals("") || txtTen.getText().equals("") || txtTuoi.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			else {
				String ma = txtMa.getText().trim();
				String ten = txtTen.getText().trim();
				int tuoi = Integer.parseInt(txtTuoi.getText().trim());
				String pb = (String) cboPb.getSelectedItem();
				Employee emp = new Employee(ma, ten, tuoi, pb);
				if (ds.them(emp)) {
//					modelEmp.addRow(new Object[] { emp.getMaNV(), emp.getHoTen(), emp.getTuoi(), emp.getPhongBan() });
					loadDataToTable();
				} else {
					JOptionPane.showMessageDialog(this, "Trùng mã");
				}
			}
		} else if (o.equals(btnXoaRong)) {
			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtMa.requestFocus();
			txtMa.setEditable(true);
			tableEmp.clearSelection();
		} else if (o.equals(btnTim)) {
			String str = JOptionPane.showInputDialog("Nhập mã nhân viên cần tìm:");
			Employee emp2 = ds.tim(str);
			if (emp2 != null) {
				modelEmp = (DefaultTableModel) tableEmp.getModel();
				modelEmp.getDataVector().removeAllElements();
				modelEmp.addRow(new Object[] { emp2.getMaNV(), emp2.getHoTen(), emp2.getTuoi(), emp2.getPhongBan() });
			} else {
				JOptionPane.showMessageDialog(this, "Not found");
			}
		} else if (o.equals(btnLuu)) {
			LuuTruEmp lt = new LuuTruEmp();
			try {
				lt.ghiFile(ds, FILE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		} else if (o.equals(btnSua)) {
			int r = tableEmp.getSelectedRow();
			if (r == -1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
			else {
				String ma = txtMa.getText();
				String ten = txtTen.getText();
				int tuoi = Integer.parseInt(txtTuoi.getText());
				String pb = cboPb.getSelectedItem().toString();
				Employee emp = new Employee(ma, ten, tuoi, pb);
				if (ds.sua(emp)) {
					modelEmp.setValueAt(ma, r, 0);
					modelEmp.setValueAt(ten, r, 1);
					modelEmp.setValueAt(tuoi, r, 2);
					modelEmp.setValueAt(pb, r, 3);
					txtMa.setEditable(true);
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				}
			}
		} else if (o.equals(btnXoa)) {
			int r = tableEmp.getSelectedRow();
			if (r == -1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
			else {
				if (JOptionPane.showConfirmDialog(this, "Bạn chắc muốn xóa dòng này không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Employee emp = ds.getEle(r);
					ds.xoa(emp);
					modelEmp.removeRow(r);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		txtMa.setEditable(false);
		int r = tableEmp.getSelectedRow();
		if (r != -1) {
			txtMa.setText(modelEmp.getValueAt(r, 0).toString());
			txtTen.setText(modelEmp.getValueAt(r, 1).toString());
			txtTuoi.setText(modelEmp.getValueAt(r, 2).toString());
			if (modelEmp.getValueAt(r, 3).toString().equals("Phòng tổ chức")) {
				cboPb.setSelectedIndex(0);
			} else if (modelEmp.getValueAt(r, 3).toString().equals("Phòng kỹ thuật")) {
				cboPb.setSelectedIndex(1);
			} else {
				cboPb.setSelectedIndex(2);
			}
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

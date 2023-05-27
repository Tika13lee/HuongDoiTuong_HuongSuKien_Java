package tuan2_30_QuanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUINhanVien extends JFrame implements MouseListener, ActionListener {
	private ListNV dsNV = new ListNV();
	private DefaultTableModel modelNV;
	private JTable tableNV;

	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnTaiLai;
	private JButton btnLuu;
	private JRadioButton radNu;
	private JRadioButton radNam;

	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private ButtonGroup gr;

	private static final String FILENAME = "src/data/NV.txt";

	public GUINhanVien() throws Exception {
		setTitle("ThuyKieu");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel jpNorth, jpCenter;

		// title
		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		Label lblTitle;
		jpNorth.add(lblTitle = new Label("THÔNG TIN NHÂN VIÊN"));
		lblTitle.setFont(new Font("Santa", Font.BOLD, 20));
		lblTitle.setForeground(Color.BLUE);

		// info
		jpCenter = new JPanel();
		jpCenter.setLayout(new BoxLayout(jpCenter, BoxLayout.Y_AXIS));
		this.add(jpCenter, BorderLayout.CENTER);

		Box b1, b2, b3, b4;
		JLabel lblMa, lblHo, lblTen, lblTuoi, lblTien;
		b1 = Box.createHorizontalBox();
		b1.add(lblMa = new JLabel("Ma nhan vien:"));
		lblMa.setPreferredSize(new Dimension(90, 10));
		b1.add(txtMa = new JTextField(20));

		b2 = Box.createHorizontalBox();
		b2.add(lblHo = new JLabel("Ho:"));
		lblHo.setPreferredSize(lblMa.getPreferredSize());
		lblHo.getPreferredSize();
		b2.add(txtHo = new JTextField(20));
		b2.add(lblTen = new JLabel("Ten nhan vien:"));
		b2.add(txtTen = new JTextField(20));

		b3 = Box.createHorizontalBox();
		b3.add(lblTuoi = new JLabel("Tuoi:"));
		lblTuoi.setPreferredSize(lblMa.getPreferredSize());
		b3.add(txtTuoi = new JTextField(20));
		b3.add(new JLabel("Phai:"));
		b3.add(radNu = new JRadioButton("Nu"));
		b3.add(radNam = new JRadioButton("Nam"));
		gr = new ButtonGroup();
		gr.add(radNu);
		gr.add(radNam);

		b4 = Box.createHorizontalBox();
		b4.add(lblTien = new JLabel("Tien luong:"));
		lblTien.setPreferredSize(lblMa.getPreferredSize());
		b4.add(txtTienLuong = new JTextField(20));

		jpCenter.add(b1);
		jpCenter.add(Box.createRigidArea(new Dimension(10, 10)));
		jpCenter.add(b2);
		jpCenter.add(Box.createRigidArea(new Dimension(10, 10)));
		jpCenter.add(b3);
		jpCenter.add(Box.createRigidArea(new Dimension(10, 10)));
		jpCenter.add(b4);
		jpCenter.add(Box.createRigidArea(new Dimension(10, 10)));

		// set data
		txtMa.setText("NV000");
		txtHo.setText("Vu");
		txtTen.setText("Thanh");
		txtTuoi.setText("10");
		txtTienLuong.setText("100000");

		// tao bang
		String[] cols = { "Ma NV", "Ho", "Ten", "Tuoi", "Phai", "Tien luong" };
		modelNV = new DefaultTableModel(cols, 0);
		tableNV = new JTable(modelNV);
		JScrollPane pane = new JScrollPane(tableNV);
		jpCenter.add(pane);

		// Đọc danh sách từ file ra đối tượng ds

		try {
			LuuTru lt = new LuuTru();
			dsNV = (ListNV) lt.docFile(FILENAME);
			loadDataToTable();
		} catch (Exception er) {
			er.printStackTrace();
		}

//		taoCung(dsNV);
//		loadDataToTable();

		// split
		JSplitPane split;
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.add(split, BorderLayout.SOUTH);
		split.setResizeWeight(0.5);

		JPanel jpSearch = new JPanel();
		jpSearch.add(new Label("Nhập mã nhân viên cần tìm:"));
		jpSearch.add(txtTim = new JTextField(10));
		jpSearch.add(btnTim = new JButton("Tim"));
		split.add(jpSearch);

		JPanel jpChucNang = new JPanel();
		jpChucNang.add(btnThem = new JButton("Them"));
		jpChucNang.add(btnXoaTrang = new JButton("Xoa trang"));
		jpChucNang.add(btnXoa = new JButton("Xoa"));
		jpChucNang.add(btnTaiLai = new JButton("Tai lai"));
		jpChucNang.add(btnLuu = new JButton("Luu"));
		split.add(jpChucNang);

		// dang ky su kien
		tableNV.addMouseListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTaiLai.addActionListener(this);

	}

	public static void main(String[] args) throws Exception {
		new GUINhanVien().setVisible(true);
	}

	private boolean validData() {
		String ma = txtMa.getText().trim();
		String ho = txtHo.getText().trim();
		String ten = txtTen.getText().trim();
		String tuoi = txtTuoi.getText().trim();
		String tien = txtTienLuong.getText().trim();

		if (!(ma.length() > 0 && ma.matches("NV\\d{3}"))) {
			JOptionPane.showMessageDialog(this,
					"Mã nhân viên không được rỗng và có dạng 'NVxxx' với x là số nguyên dương bất kỳ");
			return false;
		}
		if (!(ho.length() > 0 && ho.matches("[a-zA-Z ]*"))) {
			JOptionPane.showMessageDialog(this,
					"Họ nhân viên không được rỗng, không là ký tự số và ký tự đặc biệt trừ");
			return false;
		}
		if (!(ten.length() > 0 && ten.matches("[a-zA-Z ]*"))) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được rỗng, không là ký tự số và ký tự đặc biệt");
			return false;
		}
		if (tuoi.length() > 0) {
			try {
				int x = Integer.parseInt(tuoi);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn 0");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Tuổi phải nhập số nguyên dương");
				return false;
			}
		}
		if (tien.length() > 0) {
			try {
				double x = Double.parseDouble(tien);
				if (x < 0) {
					JOptionPane.showMessageDialog(this, "Tiền lương phải lớn hơn hoặc bằng 0");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Tiền lương phải nhập số dương");
				return false;
			}
		}

		if ((!radNam.isSelected() && !radNu.isSelected())) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
			return false;
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				String ma = txtMa.getText();
				String ho = txtHo.getText();
				String ten = txtTen.getText();
				boolean phai = true;
				if (radNu.isSelected())
					phai = false;
				if (radNam.isSelected())
					phai = true;
				double luong = Double.parseDouble(txtTienLuong.getText());
				int tuoi = Integer.parseInt(txtTuoi.getText());
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong);
				if (dsNV.addNV(nv))
					loadDataToTable();
				else
					JOptionPane.showMessageDialog(this, "Thêm không thành công - Trùng mã");
			}
//			}
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if (o.equals(btnXoa)) {
			xoaMotNV();
		}
		if (o.equals(btnTim)) {
			timTheoMa();
		}
		if (o.equals(btnTaiLai)) {
			xoaAllDuLieu();
			loadDataToTable();
		}
		if (o.equals(btnLuu)) {
			try {
				LuuTru lt = new LuuTru();
				lt.ghiFile(dsNV, FILENAME);

			} catch (Exception er) {
				er.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
	}

	private void loadDataToTable() {
		modelNV.setRowCount(0);
		String str = "";
		for (NhanVien nv : dsNV.getDs()) {
			if (nv.isPhai())
				str = "Nam";
			if (nv.isPhai() == false)
				str = "Nu";
			Object[] obj = { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), str, nv.getTienLuong() };
			modelNV.addRow(obj);
		}
	}

	private void xoaTrang() {
		txtMa.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		txtMa.requestFocus();
	}

	private void xoaMotNV() {
		int r = tableNV.getSelectedRow();
		if (r == -1)
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa");
		else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dòng này không?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				modelNV.removeRow(r);
				NhanVien nv = dsNV.getElement(r);
				dsNV.deleteNV(nv);
			}
		}
	}

	private void timTheoMa() {
		String strMa = txtTim.getText();
		if (strMa != null && strMa.trim().length() > 0) {
			NhanVien nv = dsNV.searchNV(strMa);
			if (nv != null) {
				xoaAllDuLieu();
				// them 1 dong vua tim duoc vao model
				String str;
				if (nv.isPhai())
					str = "Nam";
				else
					str = "Nữ";
				modelNV.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), str,
						nv.getTienLuong() });
			} else {
				JOptionPane.showMessageDialog(this, "Ma nhan vien khong ton tai");
				txtTim.selectAll();
				txtTim.requestFocus();
			}
		}
	}

	// xoa tat ca du lieu tren table
	private void xoaAllDuLieu() {
		DefaultTableModel dm = (DefaultTableModel) tableNV.getModel();
		dm.getDataVector().removeAllElements();
	}

	private void loadDataToText(NhanVien nv) {
		txtMa.setText(nv.getMaNV());
		txtHo.setText(nv.getHoNV());
		txtTen.setText(nv.getTenNV());
		txtTuoi.setText(nv.getTuoi() + "");
		txtTienLuong.setText(nv.getTienLuong() + "");
		if (nv.isPhai())
			radNam.setSelected(true);
		else
			radNu.setSelected(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNV.getSelectedRow();
		if (row != -1) {
			NhanVien nv = dsNV.getElement(row);
			loadDataToText(nv);
//			txtMa.setText(modelNV.getValueAt(row, 0).toString());
//			txtHo.setText(modelNV.getValueAt(row, 1).toString());
//			txtTen.setText(modelNV.getValueAt(row, 2).toString());
//			txtTuoi.setText(modelNV.getValueAt(row, 3).toString());
//			txtTienLuong.setText(modelNV.getValueAt(row, 5).toString());
//			String gender = modelNV.getValueAt(row, 4).toString();
//			if (gender == "Nam")
//				radNam.setSelected(true);
//			else
//				radNu.setSelected(true);
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

package tuan9_30_QLCauThu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CauThu_GUI extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = -1554680235689968471L;

	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnKetThuc;
	private JButton btnLoc;

	private DefaultTableModel dataModel;
	private JTable table;

	private JScrollPane scroll;
	private JComboBox<String> cboViTriThiDau;
	private JTextField txtMaCauThu;
	private JTextField txtTenCauThu;
	private JTextField txtTuoi;

	private ViTri_DAO viTri_dao;
	private CauThu_DAO cauThu_dao;

	public CauThu_GUI() {

		try {
			ConnecDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		viTri_dao = new ViTri_DAO();
		cauThu_dao = new CauThu_DAO();

		setTitle("Bai Thi Cuoi Ky - TL HSK Java - HK2 (2020-2021)");
		setSize(630, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Box b, b1, b2, b3, b4, b5, b6, b7, b8;
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());

		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		JLabel lblTieuDe, lblMaVDV, lblTenVDV, lblViTri, lblTuoi;
		b1.add(lblTieuDe = new JLabel("-THÔNG TIN CẦU THỦ-", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setForeground(Color.BLUE);

		b2.add(lblMaVDV = new JLabel("Mã số cầu thủ:  ", JLabel.RIGHT));
		b2.add(txtMaCauThu = new JTextField());
		b2.add(Box.createHorizontalStrut(50));
		b3.add(lblTenVDV = new JLabel("Tên cầu thủ:  ", JLabel.RIGHT));
		b3.add(txtTenCauThu = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b4.add(lblViTri = new JLabel("Vị trí thi đấu:  ", JLabel.RIGHT));
		b4.add(cboViTriThiDau = new JComboBox<String>());
		b4.add(Box.createHorizontalStrut(300));

		b5.add(lblTuoi = new JLabel("Tuổi:  ", JLabel.RIGHT));
		b5.add(txtTuoi = new JTextField());
		b5.add(Box.createHorizontalStrut(50));

		DefaultComboBoxModel<String> dataModelLop = new DefaultComboBoxModel<String>();
		cboViTriThiDau.setModel(dataModelLop);
		// load data from database to combobox
		ArrayList<ViTriThiDau> dsViTri = viTri_dao.getAllViTri();
		for (ViTriThiDau vt : dsViTri) {
			cboViTriThiDau.addItem(vt.getMaViTri());
		}

		lblViTri.setPreferredSize(lblMaVDV.getPreferredSize());
		lblTenVDV.setPreferredSize(lblMaVDV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaVDV.getPreferredSize());

		b6.add(Box.createHorizontalStrut(40));
		b6.add(btnThem = new JButton("Thêm mới"));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnLuu = new JButton("Lưu "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnXoa = new JButton("Xóa"));
		b6.add(Box.createHorizontalStrut(50));
		b6.add(btnKetThuc = new JButton("Kết thúc"));

		String[] tieuDe = { "Mã số", "Tên cầu thủ", "Tuổi", "Vị trí thi đấu" };
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách cầu thủ:"));

		loadData();

		JLabel lblName;
		b8.add(lblName = new JLabel("Họ tên sv: ................massv:.............."));
		lblName.setFont(new Font("Times", Font.ITALIC, 12));
		lblName.setForeground(Color.RED);
		b8.add(Box.createHorizontalStrut(50));
		b8.add(btnLoc = new JButton("Lọc danh sách cầu thủ theo vị trí thi đấu"));
		btnLoc.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnLoc.setForeground(Color.BLUE);

		// set text
		txtMaCauThu.setText("VDV13");
		txtTenCauThu.setText("Lê Trường Duy");
		txtTuoi.setText("10");

		// event
		table.addMouseListener(this);
		btnKetThuc.addActionListener(this);
		btnLoc.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	// load data from database to table
	public void loadData() {
		dataModel.setRowCount(0);
		ArrayList<CauThu> dsCauThu = cauThu_dao.getAllCauThu();
		for (CauThu ct : dsCauThu) {
			dataModel.addRow(
					new Object[] { ct.getMaCauThu(), ct.getTenCauThu(), ct.getTuoi(), ct.getViTri().getMaViTri() });
		}

	}

	public CauThu createCT() {
		String ma = txtMaCauThu.getText().trim();
		String ten = txtTenCauThu.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		String viTri = cboViTriThiDau.getSelectedItem().toString();
		ViTriThiDau vt = new ViTriThiDau(viTri);
		CauThu ct = new CauThu(ma, ten, tuoi, vt);
		return ct;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			txtMaCauThu.setText("");
			txtTenCauThu.setText("");
			txtTuoi.setText("");
			cboViTriThiDau.setSelectedIndex(0);
			txtMaCauThu.requestFocus();
		} else if (o.equals(btnLuu)) {
			CauThu ct = createCT();
			if (cauThu_dao.create(ct)) {
				loadData();
			} else
				JOptionPane.showMessageDialog(this, "Trung ma");
		} else if (o.equals(btnXoa)) {
			int r = table.getSelectedRow();
			if (r != -1) {
				String ma = dataModel.getValueAt(r, 0).toString();
				if (cauThu_dao.xoaCTTheoMa(ma)) {
					dataModel.removeRow(r);
					JOptionPane.showMessageDialog(this, "Xóa thành công");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xoá");
			}
		} else if (o.equals(btnKetThuc)) {
			System.exit(0);
		} else if (o.equals(btnLoc)) {
			String ma = cboViTriThiDau.getSelectedItem().toString();
			ArrayList<CauThu> dsCauThu = cauThu_dao.getCauThuTheoViTri(ma);
			dataModel = (DefaultTableModel) table.getModel();
			dataModel.getDataVector().removeAllElements();
			for (CauThu ct : dsCauThu) {
				dataModel.addRow(
						new Object[] { ct.getMaCauThu(), ct.getTenCauThu(), ct.getTuoi(), ct.getViTri().getMaViTri() });
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table.getSelectedRow();
		if (r != -1) {
			txtMaCauThu.setText(dataModel.getValueAt(r, 0).toString());
			txtTenCauThu.setText(dataModel.getValueAt(r, 1).toString());
			txtTuoi.setText(dataModel.getValueAt(r, 2).toString());
			cboViTriThiDau.setSelectedItem(dataModel.getValueAt(r, 3).toString());
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

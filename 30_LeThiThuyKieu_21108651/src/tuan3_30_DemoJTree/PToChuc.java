package tuan3_30_DemoJTree;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PToChuc extends JFrame {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelNV;
	private JTable tableNV;
	private ListNV data;
	private PhongBan pb;

	public PToChuc(PhongBan p) {
		super(p.getTenPB() + "( " + p.getMaPB() + ")");
		pb = p;
		setTitle("Phòng tổ chức");
		setSize(500, 300);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);

		String[] cols = { "Mã", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		modelNV = new DefaultTableModel(cols, 0);
		tableNV = new JTable(modelNV);
		JScrollPane pane = new JScrollPane(tableNV);
		add(pane);

		data = pb.getDsNV();
		if (data == null)
			data = new ListNV();
		loadDataToTable();

	}

	public void loadDataToTable() {
		String str = "";
		for (NhanVien nv : data.getDsNV()) {
			if (nv.isPhai())
				str = "Nam";
			if (nv.isPhai() == false)
				str = "Nữ";
			Object[] obj = new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), str, nv.getTuoi(),
					nv.getTienLuong() };
			modelNV.addRow(obj);
		}
	}
}

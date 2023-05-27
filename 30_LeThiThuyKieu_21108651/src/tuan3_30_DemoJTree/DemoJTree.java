package tuan3_30_DemoJTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class DemoJTree extends JFrame implements MouseListener{
	private JTree tree;
	private DefaultTreeModel treeModel;
	ListPB dsPB;

	public DemoJTree() {
		setTitle("Demo JTree");
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// tao cay
		DefaultMutableTreeNode root = createTree();
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		JScrollPane scrollTree = new JScrollPane(tree);
		tree.expandPath(new TreePath(tree.getModel().getRoot()));

		add(tree);
//		add(scrollTree);

		// dang ky su kien cho cay
		tree.addMouseListener(this);
	}

	private DefaultMutableTreeNode createTree() {
		dsPB = new ListPB();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Danh sách phòng ban");

		PhongBan pb1 = new PhongBan("pTC", "Phòng tổ chức");
		PhongBan pb2 = new PhongBan("pKT", "Phòng kĩ thuật");
		dsPB.themPB(pb1);
		dsPB.themPB(pb2);

		NhanVien nv1 = new NhanVien("0111", "Nguyễn", "An", "pTC", true, 25, 3000);
		NhanVien nv2 = new NhanVien("0222", "Lê", "Dung", "pTC", false, 27, 7000);
		NhanVien nv3 = new NhanVien("0333", "Hoàng", "Bình", "pTC", true, 25, 4000);
		NhanVien nv4 = new NhanVien("0444", "Nguyễn", "An", "pTC", true, 25, 3000);
		NhanVien nv5 = new NhanVien("0555", "Nguyễn", "An", "pTC", true, 25, 3000);
		NhanVien nv6 = new NhanVien("0666", "Nguyễn", "An", "pTC", true, 25, 3000);

		pb1.getDsNV().themNV(nv1);
		pb1.getDsNV().themNV(nv2);
		pb1.getDsNV().themNV(nv3);
		pb2.getDsNV().themNV(nv4);
		pb2.getDsNV().themNV(nv5);
		pb2.getDsNV().themNV(nv6);

		for (PhongBan p : dsPB.getDsPB()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(p);
			root.add(node);
		}

		for (int i = 0; i < root.getChildCount(); i++) {
			PhongBan temp = (PhongBan) ((DefaultMutableTreeNode) root.getChildAt(i)).getUserObject();
			ListNV dsTemp = temp.getDsNV();
			for (NhanVien nv : dsTemp.getDsNV()) {
				((DefaultMutableTreeNode) root.getChildAt(i)).add(new DefaultMutableTreeNode(nv));
			}
		}

		return root;
	}

	// main
	public static void main(String[] args) {
		new DemoJTree().setVisible(true);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = tree.getSelectionPath().getLastPathComponent();
		DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) o;
		if (e.getClickCount() == 2) {
			if (dmt.getLevel() == 1)
				new PToChuc((PhongBan) ((DefaultMutableTreeNode) o).getUserObject()).setVisible(true);
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

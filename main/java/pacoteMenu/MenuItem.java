package pacoteMenu;

import javax.swing.JButton;

public class MenuItem extends JButton {

	private int index;
	private boolean subMenuAble;

	// submenu

	private int subMenuIndex;
	private int length;

	public MenuItem(String name, int index, boolean subMenuAble) {
		super(name);
		this.index = index;
		this.subMenuAble = subMenuAble;
	}

	public void initSubMenu(int subMenuIndex, int length) {
		this.subMenuIndex = subMenuIndex;
		this.setLength(length);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isSubMenuAble() {
		return subMenuAble;
	}

	public void setSubMenuAble(boolean subMenuAble) {
		this.subMenuAble = subMenuAble;
	}

	public int getSubMenuIndex() {
		return subMenuIndex;
	}

	public void setSubMenuIndex(int subMenuIndex) {
		this.subMenuIndex = subMenuIndex;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}

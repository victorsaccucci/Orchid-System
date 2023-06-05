package pacoteMenu;

import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;

public class Menu extends JComponent{
	
	private static final long serialVersionUID = -4098115678649126882L;
	
	private MigLayout layout;
	private String [][] menuItems = new String[][] {
		{"DashBoard"}, 
		{"Email", "Inbox", "Read","Compost"}
	};
	
	public Menu() {
		init();
	}

	private void init() {
		layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
		setLayout(layout);
		
		for(int i = 0; i < menuItems.length; i++) {
			addMenu(menuItems[i][0],i);
		}
	}
	
	private void addMenu(String menuName, int index) {
		int length = menuItems[index].length;
		MenuItem item = new MenuItem(menuName, index, length>1);
		add(item);
		revalidate();
		repaint();
	}

}

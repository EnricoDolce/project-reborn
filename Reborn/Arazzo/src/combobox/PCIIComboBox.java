package combobox;


import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;

public class PCIIComboBox extends JComboBox implements PopupMenuListener {

	private final static int SCROLLBAR_WIDTH = 0;

	private boolean dragMoveListenerSet = false;

	public PCIIComboBox() {
		super();
		addPopupMenuListener(this);
	}

	public PCIIComboBox(ComboBoxModel aModel) {
		super(aModel);
		addPopupMenuListener(this);
	}

	public PCIIComboBox(Object[] items) {
		super(items);
		addPopupMenuListener(this);
	}

	public PCIIComboBox(Vector<?> items) {
		super(items);
		addPopupMenuListener(this);
	}

	public void popupMenuCanceled(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		JComboBox comboBox = (JComboBox) e.getSource();

		ComboBoxUI comboBoxUI = comboBox.getUI();
		BasicComboPopup basicComboPopup = (BasicComboPopup) comboBoxUI
				.getAccessibleChild(comboBox, 0);

		JScrollPane scrollPane = (JScrollPane) basicComboPopup.getComponent(0);

		// code for different scrollBar width
		JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
		Dimension scrollBarDim = new Dimension(SCROLLBAR_WIDTH,
				scrollBar.getPreferredSize().height);
		scrollBar.setPreferredSize(scrollBarDim);
		
		// code for no scrollbar
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		if (!dragMoveListenerSet) {
			JList list = basicComboPopup.getList();

			MouseListener[] listMouseListeners = list.getMouseListeners();
			MouseListener replacedListMouseListener = null;
			for (int iMouseListener = 0; iMouseListener < listMouseListeners.length; iMouseListener++) {
				replacedListMouseListener = listMouseListeners[iMouseListener];
				String className = replacedListMouseListener.getClass()
						.getName();
				if (className
						.equals("javax.swing.plaf.basic.BasicComboPopup$Handler")) {
					break;
				}
			}
			if (replacedListMouseListener != null) {
				list.removeMouseListener(replacedListMouseListener);
				PCIIComboBoxMouseAdapter mouseDragAdapter = new PCIIComboBoxMouseAdapter(
						list, replacedListMouseListener);
				list.addMouseListener(mouseDragAdapter);
				list.addMouseMotionListener(mouseDragAdapter);
			}

			dragMoveListenerSet = true;
		}
	}

	


}
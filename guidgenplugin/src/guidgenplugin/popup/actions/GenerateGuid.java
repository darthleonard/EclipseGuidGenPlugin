package guidgenplugin.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import guidgenplugin.GuidGenerator;

public class GenerateGuid implements IObjectActionDelegate {

	@Override
	public void run(IAction arg0) {
		new GuidGenerator().Generate();
	}

	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {
		// runs after setActivePart and on closing ide
		//JOptionPane.showMessageDialog(null, "selectionChanged");
	}

	@Override
	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {
		// run first
		//JOptionPane.showMessageDialog(null, "setActivePart");
	}

}

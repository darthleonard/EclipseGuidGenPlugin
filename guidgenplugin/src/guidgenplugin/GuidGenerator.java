package guidgenplugin;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

public class GuidGenerator {
	public void Generate() {
		var editor = getEditor();
		var textEditor = (ITextEditor) editor;
		var textSelection = (ITextSelection) editor.getEditorSite().getSelectionProvider().getSelection();
		var document = textEditor.getDocumentProvider().getDocument(editor.getEditorInput());
		
		try {
			document.replace(
					textSelection.getOffset(), 
					textSelection.getLength(), 
					createAndCopyNewGuid());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	private IEditorPart getEditor() {
		return PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow()
				.getActivePage()
				.getActiveEditor();
	}
	
	private String createAndCopyNewGuid() {
		var guid = UUID.randomUUID().toString();
		var selection = new StringSelection(guid);
		var clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		return guid;
	}
}

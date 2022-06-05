package team.arcticfox.frms.program.function;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Clipboard {
    public static void copy(String s) {
        StringSelection stsel = new StringSelection(s);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, null);
    }
}

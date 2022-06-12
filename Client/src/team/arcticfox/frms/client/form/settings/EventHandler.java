package team.arcticfox.frms.client.form.settings;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.system.Function;

import java.io.File;
import java.io.FilenameFilter;

final class EventHandler {
    private static void loadLang(SettingsForm settingsForm) {

    }

    static void initialize(SettingsForm settingsForm) {
        settingsForm.comboBoxLanguage.removeAllItems();
        loadLang(settingsForm);

        // init combo box
        {
            File dir = new File(Environment.DIR_LANG);
            dir.mkdirs();
            String[] list = dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".json");
                }
            });
            if (list != null) {
                for (String name : list) {
                    settingsForm.comboBoxLanguage.addItem(name.split("\\.")[0]);
                }
            }
        }
    }
}

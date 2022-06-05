package team.arcticfox.frms.form.view;

import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.dataset.MedicineInfo;
import team.arcticfox.frms.program.environment.Constant;
import team.arcticfox.frms.program.environment.Variable;

import javax.swing.*;
import java.awt.*;

class EventHandler {
    static MedicineInfo initialize(View view, int id) {
        Database db = new Database(Constant.DB_NAME);
        db.open();
        MedicineInfo info = MedicineInfo.parse(db.sqlQuery(Variable.getQueryByIdNoSQL(id))).get(0);
        db.close();

        ImageIcon medicineImage = new ImageIcon(view.getClass().getResource("/images/" + info.getImageName()));
        medicineImage.setImage(medicineImage.getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING));
        view.labelImage.setIcon(medicineImage);

        view.labelGrade.setText(view.labelGrade.getText().replaceAll("%grade%", info.getGrade().getLabel()));
        view.labelMedicineName.setText(view.labelMedicineName.getText().replaceAll("%medicine_name%", info.getMedicineName()));
        view.labelPrice.setText(view.labelPrice.getText().replaceAll("%price%", String.valueOf(info.getPrice())));
        view.labelApprovalNo.setText(view.labelApprovalNo.getText().replaceAll("%approval_no%", info.getApprovalNo()));
        view.labelType.setText(view.labelType.getText().replaceAll("%type%", info.getType().getLabel()));
        view.labelSpecification.setText(view.labelSpecification.getText().replaceAll("%specification%", info.getSpecification()));
        view.labelManufacturer.setText(view.labelManufacturer.getText().replaceAll("%manufacturer%", info.getManufacturer()));

        view.setTitle(view.getTitle().replaceAll("%medicine_name%", info.getMedicineName()));

        ImageIcon copyImage = new ImageIcon(view.getClass().getResource("/icons/copy.png"));
        copyImage.setImage(copyImage.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        view.buttonCopyMedicineName.setIcon(copyImage);
        view.buttonCopyApprovalNo.setIcon(copyImage);
        view.buttonCopyType.setIcon(copyImage);
        view.buttonCopySpecification.setIcon(copyImage);
        view.buttonCopyManufacturer.setIcon(copyImage);
        return info;
    }
}

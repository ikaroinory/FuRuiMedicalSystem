package team.arcticfox.frms.form.view;

import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.dataset.MedicineInfo;
import team.arcticfox.frms.program.environment.Constant;
import team.arcticfox.frms.program.environment.Variable;

import javax.swing.*;
import java.awt.*;

class EventHandler {
    static void initialize(View view) {
        ImageIcon imageIcon = new ImageIcon(view.getClass().getResource("/images/potion 60x60.png"));
        Image img = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING);
        imageIcon.setImage(img);
        view.labelImage.setIcon(imageIcon);
    }

    static void initialize(View view, int id) {
        Database db = new Database(Constant.DB_NAME);
        db.open();
        MedicineInfo info = MedicineInfo.parse(db.sqlQuery(Variable.getQueryByIdNoSQL(id))).get(0);
        db.close();

        String path = "/images/" + info.getImageName();
        ImageIcon image = new ImageIcon(view.getClass().getResource(path));
        Image img = image.getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING);
        image.setImage(img);
        view.labelImage.setIcon(image);

        view.labelGrade.setText(view.labelGrade.getText().replaceAll("%grade%", info.getGrade().getLabel()));
        view.labelMedicineName.setText(view.labelMedicineName.getText().replaceAll("%medicine_name%", info.getMedicineName()));
        view.labelPrice.setText(view.labelPrice.getText().replaceAll("%price%", String.valueOf(info.getPrice())));
        view.labelApprovalNo.setText(view.labelApprovalNo.getText().replaceAll("%approval_no%", info.getApprovalNo()));
        view.labelType.setText(view.labelType.getText().replaceAll("%type%", info.getType().getLabel()));
        view.labelSpecification.setText(view.labelSpecification.getText().replaceAll("%specification%", info.getSpecification()));
        view.labelManufacturer.setText(view.labelManufacturer.getText().replaceAll("%manufacturer%", info.getManufacturer()));

        view.setTitle(info.getMedicineName()+" - View");
    }
}

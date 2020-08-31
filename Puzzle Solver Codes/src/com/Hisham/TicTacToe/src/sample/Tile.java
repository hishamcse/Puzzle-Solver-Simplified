package sample;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    public final Text text = new Text();
    Rectangle rectangle = new Rectangle(200, 200);

    public Tile() {
//        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setFill(Color.valueOf("Grey"));
        rectangle.setStroke(Color.BLACK);

        text.setFont(Font.font(72));

        setAlignment(Pos.CENTER);
        getChildren().addAll(rectangle, text);

        setOnMouseClicked(event -> {
            if (!Main.playable)
                return;

            if (event.getButton() == MouseButton.PRIMARY) {     // left mouse button
                if (!Main.turnX)
                    return;

                drawX();
                Main.turnX = false;
                Main.checkState();
            } else if (event.getButton() == MouseButton.SECONDARY) {    // right mouse button
                if (Main.turnX)
                    return;

                drawO();
                Main.turnX = true;
                Main.checkState();
            }
        });
    }

    public double getCenterX() {
        return getTranslateX() + 100;
    }

    public double getCenterY() {
        return getTranslateY() + 100;
    }

    public String getValue() {
        return text.getText();
    }

    public void drawX() {
        text.setFill(Color.valueOf("Red"));
        text.setText("X");
    }

    public void drawO() {
        text.setFill(Color.valueOf("Blue"));
        text.setText("O");
    }

    public void drawColor(){
        rectangle.setFill(Color.CYAN);
    }
}

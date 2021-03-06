package com.example.demoq;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private Rectangle p1_label;

    @FXML
    private Rectangle p2_label;

    @FXML
    private Rectangle p1_top;

    @FXML
    private Rectangle p2_top;

    @FXML
    private Rectangle p1_bottom;

    @FXML
    private Rectangle p2_bottom;

    @FXML
    private ImageView p2_bg;

    @FXML
    private ImageView p1_bg;

    @FXML
    private Label P1_disname;

    @FXML
    private Label P2_disname;

    @FXML
    private ImageView arrow;

    @FXML
    private ImageView win_display;

    @FXML
    private Rectangle Win_dim;

    @FXML
    private Button low_token1;

    @FXML
    private Button low_token2;

    @FXML
    private Button replay;

    @FXML
    private ImageView board;

    @FXML
    private Button token2;

    @FXML
    private Button dice;

    @FXML
    private ImageView dice_img;

    @FXML
    private Button token1;

    private Game game;

    private static ArrayList<Cell> cells;
    private static HashMap<Cell, Snake_Ladder> SandL;

    private Cell P1_start;
    private Cell P2_start;

    @FXML
    void initialize() {
        initialise_cells();
        initialise_s_l();
        Image img1 = new Image(String.valueOf(HelloApplication.class.getResource("/images/blue.png")));
        ImageView view1 = new ImageView(img1);
        view1.setFitHeight(40);
        view1.setFitWidth(40);
        view1.setPreserveRatio(true);
        Image img2 = new Image(String.valueOf(HelloApplication.class.getResource("/images/green.png")));
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(40);
        view2.setFitWidth(40);
        view2.setPreserveRatio(true);
        Image img3 = new Image(String.valueOf(HelloApplication.class.getResource("/images/blue.png")));
        ImageView view3 = new ImageView(img3);
        view3.setFitHeight(40);
        view3.setFitWidth(40);
        view3.setPreserveRatio(true);
        token1.setGraphic(view1);
        token2.setGraphic(view2);
        Image img4 = new Image(String.valueOf(HelloApplication.class.getResource("/images/green.png")));
        ImageView view4 = new ImageView(img4);
        view4.setFitHeight(40);
        view4.setFitWidth(40);
        view4.setPreserveRatio(true);
        low_token1.setGraphic(view3);
        low_token2.setGraphic(view4);
        game = new Game(low_token1, low_token2, replay, dice, token1, token2, dice_img, p1_label, p2_label, p1_top, p2_top, p1_bottom, p2_bottom, p1_bg, p2_bg, P1_disname, P2_disname, P1_start, P2_start, arrow, win_display, Win_dim);
    }

    public void initialise_s_l()
    {
        SandL = new HashMap<>();

        SandL.put(cells.get(23), new Snake(cells.get(23), cells.get(4)));
        cells.get(23).setSnakeMouth(true);
        SandL.put(cells.get(42), new Snake(cells.get(42), cells.get(21)));
        cells.get(42).setSnakeMouth(true);
        SandL.put(cells.get(59), new Snake(cells.get(59), cells.get(41)));
        cells.get(59).setSnakeMouth(true);
        SandL.put(cells.get(55), new Snake(cells.get(55), cells.get(24)));
        cells.get(55).setSnakeMouth(true);
        SandL.put(cells.get(68), new Snake(cells.get(68), cells.get(47)));
        cells.get(68).setSnakeMouth(true);
        SandL.put(cells.get(89), new Snake(cells.get(89), cells.get(71)));
        cells.get(89).setSnakeMouth(true);
        SandL.put(cells.get(85), new Snake(cells.get(85), cells.get(52)));
        cells.get(85).setSnakeMouth(true);
        SandL.put(cells.get(93), new Snake(cells.get(93), cells.get(72)));
        cells.get(93).setSnakeMouth(true);
        SandL.put(cells.get(95), new Snake(cells.get(95), cells.get(83)));
        cells.get(95).setSnakeMouth(true);
        SandL.put(cells.get(97), new Snake(cells.get(97), cells.get(57)));
        cells.get(97).setSnakeMouth(true);

        SandL.put(cells.get(2), new Ladder(cells.get(2), cells.get(20)));
        cells.get(2).setLadderLow(true);
        SandL.put(cells.get(7), new Ladder(cells.get(7), cells.get(45)));
        cells.get(7).setLadderLow(true);
        SandL.put(cells.get(15), new Ladder(cells.get(15), cells.get(25)));
        cells.get(15).setLadderLow(true);
        SandL.put(cells.get(28), new Ladder(cells.get(28), cells.get(32)));
        cells.get(28).setLadderLow(true);
        SandL.put(cells.get(36), new Ladder(cells.get(36), cells.get(64)));
        cells.get(36).setLadderLow(true);
        SandL.put(cells.get(49), new Ladder(cells.get(49), cells.get(69)));
        cells.get(49).setLadderLow(true);
        SandL.put(cells.get(63), new Ladder(cells.get(63), cells.get(76)));
        cells.get(63).setLadderLow(true);
        SandL.put(cells.get(60), new Ladder(cells.get(60), cells.get(81)));
        cells.get(60).setLadderLow(true);
        SandL.put(cells.get(75), new Ladder(cells.get(75), cells.get(94)));
        cells.get(75).setLadderLow(true);
        SandL.put(cells.get(88), new Ladder(cells.get(88), cells.get(90)));
        cells.get(88).setLadderLow(true);
    }

    public void initialise_cells()
    {
        P1_start = new Cell(-1, 51.0, 691.0);
        P2_start = new Cell(-2, 77.0, 691.0);

        ArrayList<Double> X = new ArrayList<>();
        X.add(62.0);
        X.add(108.0);
        X.add(153.0);
        X.add(200.0);
        X.add(244.0);
        X.add(289.0);
        X.add(335.0);
        X.add(381.0);
        X.add(426.0);
        X.add(471.0);

        ArrayList<Double> Y = new ArrayList<>();
        Y.add(630.0);
        Y.add(565.0);
        Y.add(501.0);
        Y.add(434.0);
        Y.add(370.0);
        Y.add(305.0);
        Y.add(238.0);
        Y.add(174.0);
        Y.add(107.0);
        Y.add(44.0);

        cells = new ArrayList<>();
        int Xcoor, Ycoor;

        for (int i = 1; i <= 100; i++)
        {
            if (i % 10 == 0)
                Ycoor = (i / 10) - 1;
            else
                Ycoor = i / 10;

            if ((i <= 10) || (i >= 21 && i <= 30) || (i >= 41 && i <= 50) || (i >= 61 && i <= 70) || (i >= 81 && i <= 90))
            {
                Xcoor = i % 10;
                Xcoor--;
                if (Xcoor == -1)
                    Xcoor = 9;
            }
            else
            {
                Xcoor = 10 - i % 10;
                if (Xcoor == 10)
                    Xcoor = 0;
            }
            cells.add(new Cell(i, X.get(Xcoor), Y.get(Ycoor)));
        }

        for (Cell cell: cells)
        {
            System.out.println("Cell: "+cell.getValue()+" X: "+cell.getX()+" Y: "+cell.getY());
        }
    }

    public void playDice(MouseEvent mouseEvent) {
        game.rollDice();
    }

    public static ArrayList<Cell> getCells() {
        return cells;
    }

    public static HashMap<Cell, Snake_Ladder> getSandL() {
        return SandL;
    }

    public void replay_game(MouseEvent mouseEvent)
    {
        game.replay_game();
    }
}
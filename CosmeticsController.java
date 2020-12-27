package Cosmetics;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.IntegerStringConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class CosmeticsController {


        @FXML
        private ListView<Stock> listView;

        @FXML
        private ImageView imageShow;

        @FXML
        private TextArea descriptionShow;

        @FXML
        private Button incrementButton;

        @FXML
        private Slider soldItemSlider;

        @FXML
        private TextField soldItemTextField;

        @FXML
        private Button suctractButton;

        @FXML
        private TextField itemAddName;

        @FXML
        private TextField itemAddDescription;

        @FXML
        private TextField itemAddPrice;

        @FXML
        private TextField itemAddImage;

        @FXML
        private Button addButton;
    @FXML
    private TextField itemAddQuantity;

        @FXML
        private Button updateButton;
    @FXML
    private Label itemLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label priceLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Button deleteButton;

    @FXML
    private Label currentSoldLabel;

    private int soldCount=0;
    private int soldItemAmount = 0;




    private final ObservableList<Stock> stocks = FXCollections.observableArrayList();



    public void initialize() {

        stocks.add(new Stock("Крем дневной", "Обладает мощным смягчающим и успокаивающим свойством. Данный тип кожи чаще всего является реактивным и состав крема подобран именно так, чтобы снять раздражение, успокоить, напитать и увлажнить кожу.", "800", "Cosmetics/images/im1.jpeg", "2"));
        stocks.add(new Stock("Увлажняющий спрей-тоник", "Продукт показан для молодой кожи, чтобы обогатить ее витаминами, обеспечить детоксом и придать тонус. ", "790", "Cosmetics/images/im2.jpeg", "5"));
        stocks.add(new Stock("Гель для рук антибактериальный", "Состав: вода очищенная, спирт изопропиловый, карбомер, глицерин, пропиленгликоль,  алое вера гель, парфюмерная композиция ", "95", "Cosmetics/images/im3.jpeg", "7"));
        stocks.add(new Stock("Гидрофильные плитки ", "Плитки прекрасно подойдут обладательницам сухой и чувствительной кожи, потому, как вместе с умыванием обеспечивается питание и увлажнение кожи", "480", "Cosmetics/images/img4.png", "10"));
        stocks.add(new Stock("Бальзам для губ", "Бальзам Лечебный содержит большое количество ценных ухаживающих масел, в комплексе дающий лечебный эффект травмированной коже губ", "280", "Cosmetics/images/im5.jpeg", "42"));
        stocks.add(new Stock("Гель для умывания", "Рецепт геля не усложнен всевозможными активами, а имеет просто хорошую очищающую способность. Продукт имеет приятный аромат зеленого чая с ментолом", "450", "Cosmetics/images/im6.jpeg", "9"));
        stocks.add(new Stock("Масло для роста и лечения ресниц и бровей.", "Оригинальный состав масла HALAL' COSMETICS быстро восстанавливает поврежденные ресницы. После применения масла, брови и ресницы становятся, шелковистыми, густыми и длинными.", "610", "Cosmetics/images/img7.png", "11"));


        listView.setItems(stocks);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Stock>() {

            @Override
            public void changed(ObservableValue<? extends Stock> observableValue, Stock stock, Stock t1) {

                itemLabel.setText(t1.getName());
                descriptionShow.setText(t1.getDescription());
                imageShow.setImage(new Image(t1.getImagePath()));
                priceLabel.setText("Price: " + t1.getPrice());
                quantityLabel.setText(t1.getQuantity());

                //soldItemTextField.textProperty().bindBidirectional(soldItemSlider.valueProperty(), NumberFormat.getNumberInstance());
            }
        });



        soldItemSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                soldItemSlider.setValue(t1.intValue());

              soldItemTextField.textProperty().bindBidirectional(soldItemSlider.valueProperty(), NumberFormat.getNumberInstance());


            }


        });

    }

    @FXML
    void update(ActionEvent event) {
        try {
            Stock s = new Stock(itemAddName.getText(), itemAddDescription.getText(), itemAddImage.getText(), itemAddImage.getText());
            stocks.removeIf(i -> i.getName().equals(s.getName()));
            stocks.add(s);
            listView.setItems(stocks);
        }catch (Exception e){
            System.out.println("Sorry!");
        }
    }

    @FXML
    void delete(ActionEvent event) {
        Stock newS =new Stock(itemAddName.getText());
                //, itemAddDescription.getText(), itemAddImage.getText(), itemAddImage.getText());

        //imageShow.setImage(new Image(newS.getImagePath()));
        stocks.removeIf((i->i.getName().equals(newS.getName())));
        listView.setItems(stocks);

    }
    @FXML
    void subtractMethod(ActionEvent event) {
        try {
            IntegerStringConverter isc = new IntegerStringConverter();
            String inputAmount = soldItemTextField.getText().trim();
            String actualAmount = quantityLabel.getText().trim();

            int a = (int) Double.parseDouble(inputAmount);
            int b = (int) Double.parseDouble(actualAmount);
            int c = 0;
            if (a <= b) {
                c = b - a;
                quantityLabel.setText(String.valueOf(c));
            }else quantityLabel.setText(actualAmount);



        }catch (Exception e){

                soldItemTextField.setText("Invalid input");
                soldItemTextField.selectAll();
                soldItemTextField.requestFocus();;

        }
    }



    }




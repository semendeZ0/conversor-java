package conversormain.conversor;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private String conversao;

    @FXML
    private TextField valorConverter;

    @FXML
    private Label errorLabel;


    @FXML
    private ComboBox<String> opcoesConvert;

    ObservableList<String> listaDeOpcoes = FXCollections.observableArrayList(
            "Graus - Fahrenheit",
            "Fahrenheit - Graus",
            "KM - Metros",
            "Metros - KM"
    );


    public void mudarConversao(){
        this.conversao = opcoesConvert.getValue();
        System.out.println("Opção escolhida: " + conversao);
    }


    @FXML
    public void initialize(){
        opcoesConvert.setItems(listaDeOpcoes);
    } // Lista com as opções de conversões disponíveis

    public void resultado(){
        String valorTexto = valorConverter.getText();
        double valor = 0;
        double resultado;

        if (valorTexto == null){
            errorLabel.setText("Digite um valor");
        } else if (conversao == null) {
            errorLabel.setText("Escolha uma conversão!");
        }


        try{
            assert valorTexto != null;
            valor = Double.parseDouble(valorTexto);
        } catch (Exception e){
            errorLabel.setText("Apenas números!");
            return;
        }

        switch (conversao){
            case "Graus - Fahrenheit":
                resultado = (valor * 1.8) + 32;
                valorConverter.setText(String.format("%.2f Fº", resultado));
                break;

            case "Fahrenheit - Graus":
                resultado = (valor - 32) / 1.8;
                valorConverter.setText(String.format("%.2f Cº", resultado));
                break;

            case "KM - Metros":
                resultado = valor * 1000;
                valorConverter.setText(String.format("%.2f M", resultado));
                break;

            case "Metros - KM":
                resultado = valor / 1000;
                valorConverter.setText(String.format("%.2f KM", resultado));
                break;


            default:
                valorConverter.setText("ERROR");
                break;
        }
    }
}


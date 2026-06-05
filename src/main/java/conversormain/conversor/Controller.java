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
            "Fahrenheit - Graus"
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
            valor = Double.parseDouble(valorTexto);
        } catch (Exception e){
            errorLabel.setText("Apenas números!");
            return;
        }



        switch (conversao){
            case "Graus - Fahrenheit":
                resultado = (valor * 1.8) + 32;
                valorConverter.setText(resultado + " Fº");
                break;

            case "Fahrenheit - Graus":
                resultado = (valor - 32) / 1.8;
                valorConverter.setText(resultado + " Cº");
                break;

            default:
                valorConverter.setText("ERROR");
                break;
        }
    }
}


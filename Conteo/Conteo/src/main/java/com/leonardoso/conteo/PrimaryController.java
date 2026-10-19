package com.leonardoso.conteo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txtContador;
    @FXML private Button btnContar;
    @FXML private ProgressBar progressBar;
    @FXML private Button btnEsperar;

    private int contadorClics = 0;

    @FXML
    private void contarClics() {
        contadorClics++;
        txtContador.setText(String.valueOf(contadorClics));
    }

    @FXML
    private void iniciarEspera() {
        
        btnEsperar.setDisable(true);
        progressBar.setProgress(0.0);

        // Crear un hilo independiente para los 10 segundos
        new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(100); // retrasarlo 10 segundos.
                    final double progreso = i / 100.0;

                    
                    Platform.runLater(() -> {
                        progressBar.setProgress(progreso);
                    });
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Al finalizar los 10 segundos, se rehabilita el botón del hilo principal.
                Platform.runLater(() -> {
                    btnEsperar.setDisable(false);
                });
            }
        }).start();
    }
}

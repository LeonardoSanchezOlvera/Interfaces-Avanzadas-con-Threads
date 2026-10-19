package com.leonardoso.fabulasgraficasdeesopo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML private Button btnIniciar;
    @FXML private Label lblLiebre;
    @FXML private ProgressBar progressLiebre;
    @FXML private Label lblTortuga;
    @FXML private ProgressBar progressTortuga;

    @FXML
    private void iniciarCarrera() {
        // Deshabilitar botón para evitar múltiples clics durante la carrera
        btnIniciar.setDisable(true);
        progressLiebre.setProgress(0.0);
        progressTortuga.setProgress(0.0);

        // Hilo de la Liebre
        new Thread(() -> {
            try {
                // Fase 1: La liebre corre al principio
                for (int i = 1; i <= 50; i++) {
                    Thread.sleep(60);
                    final double avance = i / 100.0;
                    Platform.runLater(() -> {
                        progressLiebre.setProgress(avance);
                        lblLiebre.setText("La liebre: Esta corriendo!");
                    });
                }

                // Fase 2: La liebre se duerme
                Platform.runLater(() -> {
                    lblLiebre.setText("La liebre: Se durmio!");
                });
                Thread.sleep(4000); 

                
                for (int i = 51; i <= 100; i++) {
                    Thread.sleep(50);
                    final double avance = i / 100.0;
                    Platform.runLater(() -> {
                        progressLiebre.setProgress(avance);
                        lblLiebre.setText("La liebre: Esta corriendo!");
                    });
                }

                Platform.runLater(() -> {
                    lblLiebre.setText("La liebre: Meta!");
                });

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Hilo de la Tortuga.
        new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(90); 
                    final double avance = i / 100.0;
                    Platform.runLater(() -> {
                        progressTortuga.setProgress(avance);
                        lblTortuga.setText("La tortuga: Esta corriendo!");
                    });
                }

                Platform.runLater(() -> {
                    lblTortuga.setText("La tortuga: Meta!");
                    btnIniciar.setDisable(false);
                });

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
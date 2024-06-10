package com.medtech.model.componente.bateria;

import com.medtech.model.componente.Hardware;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

import java.util.List;

    public class Bateria extends Hardware {

        public double exibeBateria() {
            SystemInfo si = new SystemInfo();
            HardwareAbstractionLayer hal = si.getHardware();
            List<PowerSource> powerSources = hal.getPowerSources();

            for (PowerSource ps : powerSources) {
                System.out.println("Nome da Bateria: " + ps.getName());
                System.out.println("Capacidade Restante: " + String.format("%.1f",ps.getRemainingCapacityPercent() * 100) + "%");

                double tempoRestanteSegundos = ps.getTimeRemainingEstimated();
                if (tempoRestanteSegundos == -1) {
                    System.out.println("Tempo Restante: Carregando ou desconhecido");
                } else {
                    double tempoRestanteMinutos = tempoRestanteSegundos / 60.0;
                    System.out.println("Tempo Restante: " + String.format("%.1f",tempoRestanteMinutos) + " minutos");
                }

            }
            return 0.0;
        }
    }


package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoVehicle;
import com.konduto.sdk.models.KondutoVehicleOwner;
import com.konduto.sdk.models.KondutoVehicleType;
import com.konduto.sdk.models.KondutoVehicleUsage;

public class KondutoVehicleFactory {

    public static KondutoVehicle getVehicle() {
        // fake taxId generated with https://www.4devs.com.br/gerador_de_cpf
        KondutoVehicleOwner owner = new KondutoVehicleOwner()
                .with("taxId", "540.830.640-21")
                .with("name", "Cicero");

        return new KondutoVehicle()
                .with("make", "Bentley")
                .with("model", "Bacalar")
                .with("renavam", "144003058")
                .with("registration", "ABC1234")
                .with("vid", "5GZCZ43D13S812715")
                .with("type", KondutoVehicleType.CAR)
                .with("usage", KondutoVehicleUsage.PRIVATE)
                .with("owner", owner);
    }
}

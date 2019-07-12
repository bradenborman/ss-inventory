package com.softsurroundings.soft.surroundings.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckedOut {

    private String userId;
    private String scannerId;
    private boolean isCheckedOut;
    private String lastScanString;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastTimeScanned;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScannerId() {
        return scannerId;
    }

    public void setScannerId(String scannerId) {
        this.scannerId = scannerId;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public LocalDateTime getLastTimeScanned() {
        return lastTimeScanned;
    }

    public void setLastTimeScanned(LocalDateTime lastTimeScanned) {
        this.lastTimeScanned = lastTimeScanned;
    }

    public String getLastScanString() {
        if(this.lastTimeScanned != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            return lastTimeScanned.format(formatter);
        }
        return lastScanString;
    }

    public void setLastScanString(String lastScanString) {
        this.lastScanString = lastScanString;
    }


    @Override
    public String toString() {
        return String.format("USER_ID: %s | SCANNER #: %s | TIME: %s ", userId, scannerId, lastScanString);

    }
}

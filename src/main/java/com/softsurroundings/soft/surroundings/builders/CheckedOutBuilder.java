package com.softsurroundings.soft.surroundings.builders;

import com.softsurroundings.soft.surroundings.models.CheckedOut;

import java.time.LocalDateTime;

public final class CheckedOutBuilder {
    private String userId;
    private String scannerId;
    private String lastScanString;
    private LocalDateTime lastTimeScanned;

    private CheckedOutBuilder() {
    }

    public static CheckedOutBuilder aCheckedOut() {
        return new CheckedOutBuilder();
    }

    public CheckedOutBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public CheckedOutBuilder withScannerId(String scannerId) {
        this.scannerId = scannerId;
        return this;
    }

    public CheckedOutBuilder withLastScanString(String lastScanString) {
        this.lastScanString = lastScanString;
        return this;
    }

    public CheckedOutBuilder withLastTimeScanned(LocalDateTime lastTimeScanned) {
        this.lastTimeScanned = lastTimeScanned;
        return this;
    }

    public CheckedOut build() {
        CheckedOut checkedOut = new CheckedOut();
        checkedOut.setUserId(userId);
        checkedOut.setScannerId(scannerId);
        checkedOut.setLastScanString(lastScanString);
        checkedOut.setLastTimeScanned(lastTimeScanned);
        return checkedOut;
    }
}

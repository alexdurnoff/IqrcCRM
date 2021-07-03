package ru.durnov.building;

public class DeviceFactory {
    private final String macAddress;

    public DeviceFactory(String macAddress) {
        this.macAddress = macAddress;
    }

    public Device device() {
        if (macAddress.contains("A0E25A03")) return new ControlPanel(macAddress);
        return new Head(macAddress);
    }
}

package lab.kunmc.net.exclusiveblock.constant;

public enum CommandEnum {
    EXCLUSIVEBLOCK(),
    MODE(),
    ENABLE(),
    DISABLE();

    public String commandName() {
        return this.name().toLowerCase();
    }
}

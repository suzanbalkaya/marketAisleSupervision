package marketAisleSupervision.user.models.Enum;


public enum TaskStatusEnum {

    INSERTED(1),
    ACCEPTED(2),
    NOTACCEPTED(3),
    STARTED(4),
    FINSHED(5),
    CANCELLED(6);

    private int value;

    TaskStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

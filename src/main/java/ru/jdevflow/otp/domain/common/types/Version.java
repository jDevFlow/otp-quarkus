package ru.jdevflow.otp.domain.common.types;

public class Version {

    private final Long value;

    Version(Long value) {
        this.value = value;
    }

    public Long toLongValue() {
        return this.value;
    }

    public Version next() {
        return new Version(this.value + 1);
    }

    public Version previous() {
        return new Version(this.value - 1);
    }

    public static Version init() {
        return new Version(0L);
    }

    public static Version of(Long value) {
        return new Version(value);
    }

}

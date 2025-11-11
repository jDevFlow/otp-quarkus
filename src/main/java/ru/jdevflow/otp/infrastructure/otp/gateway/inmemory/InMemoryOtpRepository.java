package ru.jdevflow.otp.infrastructure.otp.gateway.inmemory;

import ru.jdevflow.otp.infrastructure.otp.gateway.OtpRepository;
import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.data.OtpData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InMemoryOtpRepository implements OtpRepository {

    private final Map<String, OtpData> store = new ConcurrentHashMap<>();

    public void save(OtpData otpData) {
        this.store.put(otpData.getId().toString(), otpData);
    }

    public OtpData getById(String otpId) {
        return this.store.get(otpId);
    }
}

package com.walkers.sportslight.userReward.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRewardId;

    private long receiverNo;
    private long senderNo;
    private long challengeRewardId;
    private String address;

    @Enumerated(EnumType.STRING) // Enum을 문자열로 저장
    private ReceiveStatus receiveStatus;


    @Builder
    public UserReward(long receiverNo, long senderNo, long challengeRewardId, String address, ReceiveStatus receiveStatus) {
        this.receiverNo = receiverNo;
        this.senderNo = senderNo;
        this.challengeRewardId = challengeRewardId;
        this.address = address;
        this.receiveStatus = receiveStatus;
    }

    public void setAddress(String address) {
        if (isValidAddress(address)) {
            this.address = address;
            this.receiveStatus = ReceiveStatus.ADDRESS_REGISTERED; // 주소가 등록된 상태로 변경
        } else {
            throw new IllegalArgumentException("유효하지 않은 주소입니다.");
        }
    }

    // 상태 변경 메서드
    public void markAsSent() {
        if (this.receiveStatus != ReceiveStatus.ADDRESS_REGISTERED) {
            throw new IllegalStateException("보상을 발송할 수 없는 상태입니다.");
        }
        this.receiveStatus = ReceiveStatus.SENT;
    }

    private boolean isValidAddress(String address) {
        // 주소 검증 로직 구현 (예: 주소가 비어있지 않은지 체크)
        return address != null && !address.trim().isEmpty();
    }

    public void markAsReceived() {
        if (this.receiveStatus != ReceiveStatus.SENT) {
            throw new IllegalStateException("보상을 수령할 수 없는 상태입니다.");
        }
        this.receiveStatus = ReceiveStatus.RECEIVED;
    }

    public void markAsFailed() {
        this.receiveStatus = ReceiveStatus.FAILED;
    }

    public void markAsRejected() {
        this.receiveStatus = ReceiveStatus.REJECTED;
    }
}

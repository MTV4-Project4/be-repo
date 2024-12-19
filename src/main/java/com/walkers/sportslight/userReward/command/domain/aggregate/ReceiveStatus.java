package com.walkers.sportslight.userReward.command.domain.aggregate;

public enum ReceiveStatus {
    PENDING,            // 초기 상태, 보상 발송 준비 단계
    ADDRESS_REGISTERED, // 주소가 설정되었지만 발송되지 않은 상태
    SENT,               // 보상이 발송된 상태
    RECEIVED,           // 보상을 수령한 상태
    REJECTED,           // 보상이 거절된 상태
    FAILED              // 보상 발송에 실패한 상태
}

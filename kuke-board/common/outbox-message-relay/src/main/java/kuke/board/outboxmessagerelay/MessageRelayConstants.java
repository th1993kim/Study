package kuke.board.outboxmessagerelay;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageRelayConstants {

    public static final int SHARD_COUNT = 4; // 임의의 값, 애플리케이션마다 샤드 적절하게 분배



}

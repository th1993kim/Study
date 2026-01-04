package kuke.board.common.outboxmessagerelay;

import kuke.board.outboxmessagerelay.AssignedShard;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AssignedShardTest {


    @Test
    void ofTest() {
        Long shardCount = 64L;
        List<String> appIdList = List.of("appId1", "appId2", "appId3");

        AssignedShard assignedShard = AssignedShard.of(appIdList.get(0), appIdList, shardCount);
        AssignedShard assignedShard2 = AssignedShard.of(appIdList.get(1), appIdList, shardCount);
        AssignedShard assignedShard3 = AssignedShard.of(appIdList.get(2), appIdList, shardCount);
        AssignedShard assignedShard4 = AssignedShard.of("invalid", appIdList, shardCount);


        List<Long> result = Stream.of(assignedShard.getShards(), assignedShard2.getShards(), assignedShard3.getShards(), assignedShard4.getShards())
                .flatMap(List::stream)
                .toList();

        assertThat(result).hasSize(shardCount.intValue());

        for (int i = 0; i < 64; i++) {
            assertThat(result.get(i)).isEqualTo(i);
        }

        assertThat(assignedShard4.getShards()).isEmpty();
    }
}
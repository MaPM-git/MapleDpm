package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

import java.sql.Timestamp;

@Getter
@Setter
public class MapleWorldGoddessBlessing extends BuffSkill {

    private Timestamp endTime = new Timestamp(30 * 1000);
    public MapleWorldGoddessBlessing(Long level) {
        this.setName("메이플 여신의 축복");
        this.setCooldown(0.0);  // 스택형이라 딜사이클에서 따로 처리
        this.setDelay(630L);
        this.setDuration(60L);
        this.setBuffDamage(20L);
        this.setBuffMainStat((long) ((level + 2) * 5 * 0.16 * 4));
    }
}

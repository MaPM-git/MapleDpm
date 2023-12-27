package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class InclinePower extends BuffSkill {
    public InclinePower() {
        this.setName("인클라인 파워");        // 에너지 소비 측정용
        this.setDuration(480L);             // 버프지속시간 증가 적용
        this.setCooldown(480.0);
    }
}

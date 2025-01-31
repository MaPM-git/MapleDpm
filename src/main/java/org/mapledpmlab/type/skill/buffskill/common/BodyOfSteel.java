package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BodyOfSteel extends BuffSkill {
    // 1초마다 데미지 6퍼 증가
    public BodyOfSteel(Long burningTime) {
        this.setName("바디 오브 스틸");
        this.addBuffDamage(burningTime / 1000 * 6);
        this.setDelayByAttackSpeed(720L);
        this.setDuration(18L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
    }
}

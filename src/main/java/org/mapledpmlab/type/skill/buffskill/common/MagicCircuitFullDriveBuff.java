package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MagicCircuitFullDriveBuff extends BuffSkill {
    public MagicCircuitFullDriveBuff() {
        this.setName("매직 서킷 풀드라이브");
        this.setDelayByAttackSpeed(720L);
        this.setBuffDamage(45L);
        this.setDuration(60L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
    }
}

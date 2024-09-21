package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class WrathOfGod extends BuffSkill {
    public WrathOfGod() {
        this.setName("레이스 오브 갓");
        this.setCooldown(120.0);
        this.setDuration(60L);
        this.setBuffDamage(10L);
        this.setApplyServerLag(true);
    }
}

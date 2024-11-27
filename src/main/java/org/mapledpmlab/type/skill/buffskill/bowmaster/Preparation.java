package org.mapledpmlab.type.skill.buffskill.bowmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Preparation extends BuffSkill {
    public Preparation() {
        this.setName("프리퍼레이션");
        this.setCooldown(120.0);
        this.setDelay(540L);
        this.setDuration(40L);
        this.setBuffDamage(20L);
        this.setBuffAttMagic(50L);
        this.setApplyServerLag(true);
    }
}

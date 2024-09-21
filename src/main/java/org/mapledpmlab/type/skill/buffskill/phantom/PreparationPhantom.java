package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PreparationPhantom extends BuffSkill {
    public PreparationPhantom() {
        this.setName("프리퍼레이션(팬텀)");
        this.setCooldown(120.0);
        this.setDelayByAttackSpeed(540L);
        this.setDuration(30L);
        this.setBuffDamage(20L);
        this.setBuffAttMagic(50L);
        this.setApplyServerLag(true);
    }
}

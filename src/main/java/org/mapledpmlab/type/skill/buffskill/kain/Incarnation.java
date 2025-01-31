package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Incarnation extends BuffSkill {
    public Incarnation() {
        this.setName("인카네이션");
        this.setDelayByAttackSpeed(780L);
        this.setCooldown(180.0);
        this.addBuffDamage(15L);
        this.addBuffAttMagicPer(15L);
        this.setDuration(40L);
        this.setApplyServerLag(true);
    }
}

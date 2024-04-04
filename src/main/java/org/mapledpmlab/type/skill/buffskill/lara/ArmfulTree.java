package org.mapledpmlab.type.skill.buffskill.lara;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ArmfulTree extends BuffSkill {
    public ArmfulTree() {
        this.setName("아름드리 나무");
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(180.0);
        this.setDuration(30L);
        this.addBuffIgnoreDefense(15L);
        this.addBuffDamage(30L);
        this.addBuffCriticalDamage(10.0);
    }
}

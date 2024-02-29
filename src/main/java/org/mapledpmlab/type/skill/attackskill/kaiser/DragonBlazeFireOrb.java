package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBlazeFireOrb extends AttackSkill {
    public DragonBlazeFireOrb() {
        this.setName("드래곤 블레이즈(화염구)");
        this.setDamage(770.0);
        this.setAttackCount(3L * 6);
        this.setCooldown(10.0);
        this.getMultiAttackInfo().add(360L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}

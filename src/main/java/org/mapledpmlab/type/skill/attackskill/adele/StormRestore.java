package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StormRestore extends AttackSkill {
    public StormRestore() {
        this.setName("스톰(리스토어)");
        this.setDamage(550.0);
        this.setAttackCount(8L);
        this.setDelay(780L);
        this.setCooldown(90.0);
        this.setDotDuration(14700L);
        this.setInterval(300L);
        this.setLimitAttackCount(49L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}

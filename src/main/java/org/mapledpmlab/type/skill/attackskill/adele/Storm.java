package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Storm extends AttackSkill {
    public Storm() {
        this.setName("스톰");
        this.setDamage(550.0);
        this.setAttackCount(6L);
        this.setDelay(780L);
        this.setCooldown(90.0);
        //this.setDotDuration(14700L);
        this.setDotDuration(17700L);
        this.setInterval(300L);
        //this.setLimitAttackCount(49L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setApplyServerLag(true);
    }
}

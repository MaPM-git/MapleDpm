package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlashMirage extends AttackSkill {
    public FlashMirage() {
        this.setName("플레시 미라주");
        this.setAttackCount(16L);   //4*4
        this.setCooldown(1.0);
        this.setDamage(542.0);
        //this.setDotDuration(1000L);
        //this.setInterval(250L);
        this.setFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}

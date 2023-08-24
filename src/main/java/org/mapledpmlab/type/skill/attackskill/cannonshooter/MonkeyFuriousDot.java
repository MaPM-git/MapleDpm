package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyFuriousDot extends AttackSkill {
    public MonkeyFuriousDot() {
        this.setName("몽키 퓨리어스(도트)");
        this.setDamage(200.0);
        this.setAttackCount(1L);
        this.setInterval(1000L);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}

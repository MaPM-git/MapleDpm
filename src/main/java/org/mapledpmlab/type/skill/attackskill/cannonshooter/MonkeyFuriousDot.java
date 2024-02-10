package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.MonkeyFuriousBuff;

public class MonkeyFuriousDot extends AttackSkill {
    public MonkeyFuriousDot() {
        this.setName("몽키 퓨리어스(도트)");
        this.setDamage(200.0);
        this.setAttackCount(1L);
        this.setDotDuration(60000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new MonkeyFuriousBuff());
    }
}

package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AMIceWave extends AttackSkill {
    public AMIceWave() {
        this.setName("아드레날린 맥시멈(얼음 파동)");
        this.setDamage(897.0);
        this.setAttackCount(2L);
        this.setDotDuration(20000L);
        this.setInterval(390L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}

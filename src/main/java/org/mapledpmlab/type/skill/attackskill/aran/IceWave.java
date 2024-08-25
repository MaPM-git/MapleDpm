package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceWave extends AttackSkill {
    public IceWave() {
        this.setName("얼음 파동");
        this.setDamage(350.0 + 329);    // 아드레날린 맥시멈
        this.setAttackCount(2L);
        this.setDotDuration(20000L);
        this.setInterval(600L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}

package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AMIceStorm extends AttackSkill {
    public AMIceStorm() {
        this.setName("아드레날린 맥시멈(얼음 폭풍)");
        this.setDamage(1560.0);
        this.setAttackCount(14L);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}

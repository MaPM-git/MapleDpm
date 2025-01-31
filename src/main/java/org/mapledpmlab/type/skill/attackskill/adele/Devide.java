package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Devide extends AttackSkill {
    public Devide() {
        this.setName("디바이드");
        this.setDamage(750.0 + 40);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(6L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 트리거-리인포스, 보스 킬러
    }
}

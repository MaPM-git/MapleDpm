package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AfterImageShockActive extends AttackSkill {
    public AfterImageShockActive() {
        this.setName("애프터이미지 쇼크(액티브)");
        this.setAttackCount(5L);
        this.setDamage(990.0);
        this.setCooldown(0.1);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}

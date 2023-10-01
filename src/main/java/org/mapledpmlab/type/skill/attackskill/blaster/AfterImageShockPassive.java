package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AfterImageShockPassive extends AttackSkill {
    public AfterImageShockPassive() {
        this.setName("애프터이미지 쇼크(패시브)");
        this.setAttackCount(3L);
        this.setDamage(1100.0);
        this.setCooldown(4.0);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}

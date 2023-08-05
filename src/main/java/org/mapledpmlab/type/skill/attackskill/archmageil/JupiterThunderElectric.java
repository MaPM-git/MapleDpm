package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JupiterThunderElectric extends AttackSkill {
    public JupiterThunderElectric() {
        this.setName("주피터 썬더(전류)");
        this.setDamage(440.0);
        this.setAttackCount(4L);
        this.setCooldown(120.0);
        this.setDotDuration(30000L);
        this.setInterval(660L);
        this.setLimitAttackCount(15L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new JupiterThunderDelay());
        this.addFinalDamage(1.6);       // 코어강화
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}

package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JupiterThunder extends AttackSkill {
    public JupiterThunder() {
        this.setName("주피터 썬더");
        this.setDamage(660.0);
        this.setAttackCount(8L);
        this.setCooldown(120.0);
        this.setDotDuration(30000L);
        this.setInterval(330L);
        this.setLimitAttackCount(30L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new JupiterThunderElectric());
        this.addFinalDamage(1.6);       // 코어강화
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}

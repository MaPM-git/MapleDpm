package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainSickle extends AttackSkill {
    public ChainSickle() {
        this.setName("[처형] 체인 시클");
        this.setDamage(525.0);
        this.setAttackCount(6L);
        this.setDelayByAttackSpeed(330L);
        this.setCooldown(7.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new ChainSickleFinish());
        this.setAddDamage(20L);
        this.setApplyCooldownReduction(true);
    }
}

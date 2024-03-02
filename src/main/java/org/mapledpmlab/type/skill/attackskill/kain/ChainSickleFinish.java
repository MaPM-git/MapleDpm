package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainSickleFinish extends AttackSkill {
    public ChainSickleFinish() {
        this.setName("[처형] 체인 시클(마무리 일격)");
        this.setDamage(523.0);
        this.setAttackCount(14L);
        this.setDelayByAttackSpeed(510L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);
    }
}

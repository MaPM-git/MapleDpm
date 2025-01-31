package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessAgonyFinish extends AttackSkill {
    public EndlessAgonyFinish() {
        this.setName("끝없는 고통(심연의 파수꾼)");
        this.setDamage(336.0);
        this.setAttackCount(12L);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}

package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossom2FallingPetals extends AttackSkill {
    public PlumBlossom2FallingPetals() {
        this.setName("매화검 2초식 : 쇄매");
        this.setAttackCount(3L);
        this.setDamage(180.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(450L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}

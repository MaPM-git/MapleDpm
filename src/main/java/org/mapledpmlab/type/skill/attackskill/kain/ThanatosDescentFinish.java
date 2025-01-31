package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThanatosDescentFinish extends AttackSkill {
    public ThanatosDescentFinish() {
        this.setName("타나토스 디센트(죽음의 영역)");
        this.setDamage(1430.0);
        this.setAttackCount(15L);
        this.setDelayByAttackSpeed(6510L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(2670L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
    }
}

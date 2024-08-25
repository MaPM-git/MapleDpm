package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThanatosDescentDeathArrow extends AttackSkill {
    public ThanatosDescentDeathArrow() {
        this.setName("타나토스 디센트(죽음의 화살)");
        this.setDamage(715.0);
        this.setAttackCount(3L);
        this.setCooldown(3.0);
        this.addFinalDamage(1.6);   // 코어강화
        this.setApplyReuse(true);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}

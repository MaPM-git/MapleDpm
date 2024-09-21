package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightOfCourageAttack extends AttackSkill {
    public LightOfCourageAttack() {
        this.setName("라이트 오브 커리지(용기의 빛)");
        this.setAttackCount(10L);
        this.setDamage(2100.0);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(660L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
